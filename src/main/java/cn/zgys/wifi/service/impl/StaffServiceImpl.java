package cn.zgys.wifi.service.impl;



import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.axis.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.schk.note.SMS2009;
import cn.schk.note.SMS2009Soap;
import cn.schk.oatest.OaWfWebServiceSoap;
import cn.schk.oatest.OaWfWebService;
import cn.schk.oatest.WFInterfaceEntity;
import cn.schk.portaltest.ValidEffectUserSoapBindingStub;
import cn.schk.portaltest.ValidEffectUser_PortType;
import cn.zgys.wifi.entity.EmployeeBean;
import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.Staff;
import cn.zgys.wifi.repository.EmployeeBeanRepository;
import cn.zgys.wifi.repository.LogBeanRepository;
import cn.zgys.wifi.repository.StaffRepository;
import cn.zgys.wifi.service.StaffService;
import cn.zgys.wifi.util.Code;
import cn.zgys.wifi.util.DateUtil;
import cn.zgys.wifi.util.RedisDao;

@Service("StaffService")
public class StaffServiceImpl implements StaffService{
	
	private final StaffRepository staffRepository;
	private final LogBeanRepository logBeanRepository;
	private final EmployeeBeanRepository employeeBeanRepository;
	
	@Resource
    RedisDao redisDao;
	
	@Autowired
	public StaffServiceImpl(StaffRepository staffRepository,LogBeanRepository logBeanRepository,EmployeeBeanRepository employeeBeanRepository) {
		this.staffRepository = staffRepository;
		this.logBeanRepository = logBeanRepository;
		this.employeeBeanRepository = employeeBeanRepository;
	}
	
	@Override
	public String login(String userName, String password) {
		// TODO Auto-generated method stub
		String pattern="^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$";
		if(userName.trim().matches(pattern)){
			
		//自己的登录方法
			Staff staff = staffRepository.findByUserNameAndPassword(userName, password); 
			if(staff==null) {
				return "用户名或者密码错误";
			}
			//1、null==staff.getOvertime()表示如果有overtime表示已经经过审批了
			//2、比较过期时间和当前时间，如果已经过期则需要重新注册
			else if((!(null==staff.getOvertime()))&&staff.getOvertime().getTime()<System.currentTimeMillis()) {
				staffRepository.delete(staff);
				return "该账户已失效";
			}
			else {
				//登录成功
				//业务代码
				LogBean log = new LogBean();
				log.setUserName(staff.getUserName());
				log.setPhoneNumber(staff.getPhoneNumber());
				log.setArea(null);
				log.setOverTime(staff.getOvertime());
				log.setLoginTime(new Date());
				logBeanRepository.save(log);
				return "登录成功";
			}
		}else {
		//调用川航门户接口
			String result = "";
			try {
				ValidEffectUser_PortType veup = new ValidEffectUserSoapBindingStub();
				result = veup.validatorLegalUser(userName, password);
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
//			OaWfWebService oa = new OaWfWebService();
//			OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
//			cn.schk.oa.WFInterfaceEntity staff = soap.getInterfaceEntity2("WIFI", "WIFI", "123", System.currentTimeMillis()+Code.getCard());
			if(result.contains("<code>0<code>")) {
				
				//登录成功
				//业务代码
				
				return "登录成功";
			}else {
				
				return "用户名或者密码错误";
			}
		}
	}
	//互联网注册
	@Override
	public String regist1(String realName,String phoneNumber,String code,String idCard,String name,String account,String limit,String day,String reason) {
		// TODO Auto-generated method stub
		//根据手机号码从redis中取出验证码比对
		Staff staff = staffRepository.findByPhoneNumber(phoneNumber.trim());
		if(staff != null) {
			return "该手机号码已经注册!";
		}
		String codeValue = redisDao.getValue(phoneNumber.trim());
		if(!code.equals(codeValue)) {
			return "验证码错误!";
		}
		//创建一个流水号
		String instanceId = System.currentTimeMillis()+"";
		//创建一个staff保存信息		
		Staff sta = new Staff();
		sta.setRealName(realName);
		sta.setIdCard(idCard);
		sta.setPhoneNumber(phoneNumber);
		sta.setStatus(1);
		sta.setInstanceId(instanceId);
		System.err.println("注册instance："+instanceId);
		staffRepository.save(sta);
		//查询第二级审批人员
		List<EmployeeBean> list = employeeBeanRepository.findByLevelEquals("2");
		String result = null;
		for (EmployeeBean employeeBean : list) {
			//1、调用川航OA，将信息加入代办事项，供OA审批			
			OaWfWebService oa = new OaWfWebService();
			OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
			cn.schk.oatest.WFInterfaceEntity entity = new WFInterfaceEntity();
			entity.setInstanceID(instanceId);//项目编号
			entity.setStepID("1");
			entity.setProjectCode("WIFI");
			entity.setProjectName("WIFI"); 		
			entity.setInstanceTitle("互联网无线网络申请");						
			entity.setFormURL("http://localhost:80/approveOut?realName="+realName+
					"&phoneNumber="+phoneNumber+"&idCard="+idCard+"&day="+day+"&reason="+
					reason+"&account="+account+"&name="+name+"&apn="+employeeBean.getName()+
					"&apa="+employeeBean.getAccount());//处理相关事项的表单页面的地址,连接外网。
			entity.setStepName("领导审批");//步骤名称
			entity.setFlowType("WIFI");//流转步骤的类型
			entity.setImportLevel("0");//缓急程度
//			entity.setUserIDConsigned("");//委托人员工号（选填）
//			entity.setUserNameConsigned("");//委托人姓名（选填）
			entity.setUserID(employeeBean.getAccount());//处理人员工号
			entity.setUserName(employeeBean.getName());//处理人姓名
			entity.setUserDeptName("信息服务部");//处理人所在部门名称
			entity.setCreatID(account);//撰稿人员工号
			entity.setCreatName(name);//撰稿人姓名
			//获取当前时间  
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			entity.setCreatTime(df.format(new Date()));
			entity.setCreatDeptName("信息服务部");//撰稿人所在部门名称
			result = soap.insertNewWFInstanceByEntity("WIFI", "WIFI", "123", entity);
			System.err.println(result);
		}				
		if("1".equals(result)) {
			return "OK";
		}else {
			return result;
		}
		
	}
	//内网注册
	@Override
	public String regist2(String realName,String phoneNumber,String code,String idCard,String name,String account,String limit,String day,String reason) {
		// TODO Auto-generated method stub
				//根据手机号码从redis中取出验证码比对
				Staff staff = staffRepository.findByPhoneNumber(phoneNumber.trim());
				if(staff != null) {
					return "该手机号码已经注册!";
				}
				String codeValue = redisDao.getValue(phoneNumber.trim());
				if(!code.equals(codeValue)) {
					return "验证码错误!";
				}
				//创建一个流水号
				String instanceId = System.currentTimeMillis()+"";
				//创建一个staff保存信息		
				Staff sta = new Staff();
				sta.setRealName(realName);
				sta.setIdCard(idCard);
				sta.setPhoneNumber(phoneNumber);
				sta.setStatus(1);
				sta.setInstanceId(instanceId);
				staffRepository.save(sta);
				//查询第二级审批人员
				List<EmployeeBean> list = employeeBeanRepository.findByLevelEquals("2");
				String result = null;
				for (EmployeeBean employeeBean : list) {
					//1、调用川航OA，将信息加入代办事项，供OA审批			
					OaWfWebService oa = new OaWfWebService();
					OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
					cn.schk.oatest.WFInterfaceEntity entity = new WFInterfaceEntity();
					entity.setInstanceID(instanceId);//项目编号
					entity.setStepID("1");
					entity.setProjectCode("WIFI");
					entity.setProjectName("WIFI"); 		
					entity.setInstanceTitle("内网无线网络申请");						
					entity.setFormURL("http://localhost:80/approve1?realName="+realName+
							"&phoneNumber="+phoneNumber+"&idCard="+idCard+"&day="+day+"&reason="+
							reason+"&account="+account+"&name="+name+"&apn1="+employeeBean.getName()+
							"&apa1="+employeeBean.getAccount());//处理相关事项的表单页面的地址,连接外网。
					entity.setStepName("领导审批");//步骤名称
					entity.setFlowType("WIFI");//流转步骤的类型
					entity.setImportLevel("0");//缓急程度
//					entity.setUserIDConsigned("");//委托人员工号（选填）
//					entity.setUserNameConsigned("");//委托人姓名（选填）
					entity.setUserID(employeeBean.getAccount());//处理人员工号
					entity.setUserName(employeeBean.getName());//处理人姓名
					entity.setUserDeptName("信息服务部");//处理人所在部门名称
					entity.setCreatID(account);//撰稿人员工号
					entity.setCreatName(name);//撰稿人姓名
					//获取当前时间  
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					entity.setCreatTime(df.format(new Date()));
					entity.setCreatDeptName("信息服务部");//撰稿人所在部门名称
					result = soap.insertNewWFInstanceByEntity("WIFI", "WIFI", "123", entity);
					System.err.println(result);
				}				
				if("1".equals(result)) {
					return "OK";
				}else {
					return result;
				}
				
		
	}
	
	//验证码
	@Override
	public String getCode(String phoneNumber) {
		// TODO Auto-generated method stub
		//生成验证码
		String code = Code.getCard();
		//调用短信接口发送验证码
		SMS2009 sms = new SMS2009();
		SMS2009Soap soap = sms.getSMS2009Soap();
		String xmlCommand = "<Root>\r\n" + 
				"	<Command>SendSingle</Command>\r\n" + 
				"	<LoginName>btim</LoginName>\r\n" + 
				"	<LoginPassword>jfwls</LoginPassword>\r\n" + 
				"	<TaskName></TaskName>\r\n" + 
				"	<TaskCategory>内部运行通知</TaskCategory>\r\n" + 
				"	<Tel>"+phoneNumber+"</Tel>\r\n" + 
				"	<SentTime></SentTime>\r\n" + 
				"	<Interval>1</Interval>\r\n" + 
				"	<Content><![CDATA[您的wifi验证码是："+code+",请于3分钟之内正确输入!]]></Content>\r\n" + 
				"	<ReturnURL></ReturnURL>\r\n" + 
				"<IsAntiDisturb>-1</IsAntiDisturb>\r\n" + 
				"</Root>";
		String result = soap.executeCommand(xmlCommand);
		System.err.println(result);
		if(result.contains("<Code>0</Code>")) {
			//将验证码存入redis
			redisDao.setKey(phoneNumber, code);
			return code;			
		}
		String jieguo = result.substring(result.indexOf("<Message>")+9,result.indexOf("</Message>"));
		return "发送失败: "+jieguo;
	}
		

//	@Override
//	public String visitorLogin(String phoneNumber, String code) {
//		// TODO Auto-generated method stub
//		String codeValue = redisDao.getValue(phoneNumber);
//		if(codeValue != code) {
//			return "验证码错误!";
//		}
//		//调用业务开通wifi		
//		return "登录成功";
//	}	

	@Override
	public String check(String phoneNumber, String day) {
		//根据手机号找到该用户的审批流水号
		Staff staff = staffRepository.findByPhoneNumber(phoneNumber);
		//该手机号码为注册页面传入过来，而在注册时就已经生成了instanceId，所以staff.getInstanceId()不可能为空！
		String instanceId = staff.getInstanceId();
		System.err.println("审批instance："+instanceId);
		//调用川航接口 
		OaWfWebService oa = new OaWfWebService();
		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
		//将申请的时间转化为int类型
		int applyTime = Integer.parseInt(day);
		//获取当前时间
		Date d=new Date();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		//设置过期时间,并保存到数据库中去
		Date overtime = DateUtil.getDayOn(applyTime);
		staff.setOvertime(overtime);
		staff.setStatus(0);
		//修改阅读时间和处理时间 审批通过
		//参数依次为 项目代码 用户名 密码 工作流步骤 委托人工号(可以为空) 委托人姓名(可以为空) 阅读时间 处理时间 
		String result = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", instanceId, "1", null, null, time, time);
		System.err.println(result);
		if("1".equals(result)) {
			String pwd = Code.getStringRandom();
			//开启内网权限，调用imc接口增加一个用户。
			
			//生成帐号密码，将更新的信息保存到数据库中
			staff.setUserName(phoneNumber);
			staff.setPassword(pwd);
			staffRepository.saveAndFlush(staff);	
			//调用短信接口告知用户已经开启无线网络
			SMS2009 sms = new SMS2009();
			SMS2009Soap smsSoap = sms.getSMS2009Soap();
			String xmlCommand = "<Root>\r\n" + 
					"	<Command>SendSingle</Command>\r\n" + 
					"	<LoginName>btim</LoginName>\r\n" + 
					"	<LoginPassword>jfwls</LoginPassword>\r\n" + 
					"	<TaskName></TaskName>\r\n" + 
					"	<TaskCategory>内部运行通知</TaskCategory>\r\n" + 
					"	<Tel>"+phoneNumber+"</Tel>\r\n" + 
					"	<SentTime></SentTime>\r\n" + 
					"	<Interval>1</Interval>\r\n" + 
					"	<Content><![CDATA[无线网络审批通过,已为您开通 "+day+" 天无线网络!您的wifi用户名："+phoneNumber+" ,密码："+pwd+"。]]></Content>\r\n" + 
					"	<ReturnURL></ReturnURL>\r\n" + 
					"<IsAntiDisturb>-1</IsAntiDisturb>\r\n" + 
					"</Root>";
			String jieguo = smsSoap.executeCommand(xmlCommand);
			if(jieguo.contains("<Code>0</Code>")) {
				return "审批通过";
			}			
			return "error:"+jieguo;
		}
		return "error:"+result;
	}

//	public static void main(String[] args) {
//		//获取当前时间
//		Date d=new Date();   
//		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = df.format(d);
//		OaWfWebService oa = new OaWfWebService();
//		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
//		WFInterfaceEntity s = soap.getInterfaceEntity("WIFI", "WIFI", "123", "1531981653785", "1");
////		String s = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", "1531981653785", "1", null, null, time, time);
//		System.err.println(s);
//	}

	

	@Override
	public String ref(String phoneNumber) {
		//根据手机号找到该用户的审批流水号
		Staff staff = staffRepository.findByPhoneNumber(phoneNumber);
		//该手机号码为注册页面传入过来，而在注册时就已经生成了instanceId，所以staff.getInstanceId()不可能为空！
		String instanceId = staff.getInstanceId();
		//从数据库删除记录
		staffRepository.delete(staff);
		//获取当前时间
		Date d=new Date();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		//调用川航接口 
		OaWfWebService oa = new OaWfWebService();
		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();			
		String result = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", instanceId, "1", null, null, time, time);
		if("1".equals(result)) {		
			SMS2009 sms = new SMS2009();
			SMS2009Soap smsSoap = sms.getSMS2009Soap();
			String xmlCommand = "<Root>\r\n" + 
					"	<Command>SendSingle</Command>\r\n" + 
					"	<LoginName>btim</LoginName>\r\n" + 
					"	<LoginPassword>jfwls</LoginPassword>\r\n" + 
					"	<TaskName></TaskName>\r\n" + 
					"	<TaskCategory>内部运行通知</TaskCategory>\r\n" + 
					"	<Tel>"+phoneNumber+"</Tel>\r\n" + 
					"	<SentTime></SentTime>\r\n" + 
					"	<Interval>1</Interval>\r\n" + 
					"	<Content><![CDATA[您的无线网络申请已被驳回！]]></Content>\r\n" + 
					"	<ReturnURL></ReturnURL>\r\n" + 
					"<IsAntiDisturb>-1</IsAntiDisturb>\r\n" + 
					"</Root>";
			String jieguo = smsSoap.executeCommand(xmlCommand);
			if(jieguo.contains("<Code>0</Code>")) {
				return "已驳回";
			}			
			return "error:"+jieguo;
		}
		return "error:"+result;
	}

	@Override
	public String approve1(String realName, String phoneNumber, String idCard, String name, String account, String day,
			String reason, String apn1, String apa1, String date1) {
		// TODO Auto-generated method stub
		//1、第一级审批通过，先将第一级的所有代办事项修改为已办
		//根据手机号找到该用户的审批流水号
		Staff staff = staffRepository.findByPhoneNumber(phoneNumber);
		//该手机号码为注册页面传入过来，而在注册时就已经生成了instanceId，所以staff.getInstanceId()不可能为空！
		String instanceId = staff.getInstanceId();
		//获取当前时间
		Date d=new Date();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		//调用川航接口 
		OaWfWebService oa = new OaWfWebService();
		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
		//参数依次为 项目代码 用户名 密码 工作流步骤 委托人工号(可以为空) 委托人姓名(可以为空) 阅读时间 处理时间 
		String result = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", instanceId, "1", null, null, time, time);
		System.err.println(result);
		//将信息发送给第二级审批人员
		//创建一个新的流水号
		instanceId = System.currentTimeMillis()+"";
		//更新staff信息				
		staff.setStatus(2);
		staff.setInstanceId(instanceId);
		//查询第二级审批人员
		List<EmployeeBean> list = employeeBeanRepository.findByLevelEquals("3");
		String res = null;
		for (EmployeeBean employeeBean : list) {
			//1、调用川航OA，将信息加入代办事项，供OA审批			
			OaWfWebService oa1 = new OaWfWebService();
			OaWfWebServiceSoap soap1 = (OaWfWebServiceSoap) oa1.getOaWfWebServiceSoap();
			cn.schk.oatest.WFInterfaceEntity entity = new WFInterfaceEntity();
			entity.setInstanceID(instanceId);//项目编号
			entity.setStepID("2");
			entity.setProjectCode("WIFI");
			entity.setProjectName("WIFI"); 		
			entity.setInstanceTitle("内网无线网络申请");						
			entity.setFormURL("http://localhost:80/approve2?realName="+realName+
					"&phoneNumber="+phoneNumber+"&idCard="+idCard+"&day="+day+"&reason="+
					reason+"&account="+account+"&name="+name+"&apn1="+apn1+"&date1="+date1+"&apn2="+employeeBean.getName()+
					"&apa2="+employeeBean.getAccount());//处理相关事项的表单页面的地址,连接外网。
			entity.setStepName("领导审批");//步骤名称
			entity.setFlowType("WIFI");//流转步骤的类型
			entity.setImportLevel("0");//缓急程度
//			entity.setUserIDConsigned("");//委托人员工号（选填）
//			entity.setUserNameConsigned("");//委托人姓名（选填）
			entity.setUserID(employeeBean.getAccount());//处理人员工号
			entity.setUserName(employeeBean.getName());//处理人姓名
			entity.setUserDeptName("信息服务部");//处理人所在部门名称
			entity.setCreatID(apa1);//撰稿人员工号
			entity.setCreatName(apn1);//撰稿人姓名
			//获取当前时间  
			entity.setCreatTime(df.format(new Date()));
			entity.setCreatDeptName("信息服务部");//撰稿人所在部门名称
			res = soap1.insertNewWFInstanceByEntity("WIFI", "WIFI", "123", entity);
			System.err.println(res);
		}				
		if("1".equals(result)) {
			return "OK";
		}else {
			return res;
		}			
	}

	@Override
	public String approve2(String realName, String phoneNumber, String idCard, String name, String account, String day,
			String reason, String apn1, String apa1, String date1, String apn2, String apa2, String date2) {
		// TODO Auto-generated method stub
			//1、第一级审批通过，先将第一级的所有代办事项修改为已办
			//根据手机号找到该用户的审批流水号
			Staff staff = staffRepository.findByPhoneNumber(phoneNumber);
			//该手机号码为注册页面传入过来，而在注册时就已经生成了instanceId，所以staff.getInstanceId()不可能为空！
			String instanceId = staff.getInstanceId();
			//获取当前时间
			Date d=new Date();   
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(d);
			//调用川航接口 
			OaWfWebService oa = new OaWfWebService();
			OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
			//参数依次为 项目代码 用户名 密码 工作流步骤 委托人工号(可以为空) 委托人姓名(可以为空) 阅读时间 处理时间 
			String result = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", instanceId, "2", null, null, time, time);
			System.err.println(result);
			//将信息发送给第二级审批人员
			//创建一个新的流水号
			instanceId = System.currentTimeMillis()+"";
			//更新staff信息		
			staff.setStatus(3);
			staff.setInstanceId(instanceId);
			//查询第二级审批人员
			List<EmployeeBean> list = employeeBeanRepository.findByLevelEquals("4");
			String res = null;
			for (EmployeeBean employeeBean : list) {
				//1、调用川航OA，将信息加入代办事项，供OA审批			
				OaWfWebService oa1 = new OaWfWebService();
				OaWfWebServiceSoap soap1 = (OaWfWebServiceSoap) oa1.getOaWfWebServiceSoap();
				cn.schk.oatest.WFInterfaceEntity entity = new WFInterfaceEntity();
				entity.setInstanceID(instanceId);//项目编号
				entity.setStepID("3");
				entity.setProjectCode("WIFI");
				entity.setProjectName("WIFI"); 		
				entity.setInstanceTitle("内网无线网络申请");						
				entity.setFormURL("http://localhost:80/approve3?realName="+realName+
						"&phoneNumber="+phoneNumber+"&idCard="+idCard+"&day="+day+"&reason="+
						reason+"&account="+account+"&name="+name+"&apn1="+apn1+"&date1="+date1+
						"&apn2="+apn2+"&date2="+date2+
						"&apn3="+employeeBean.getName()+"&apa3="+employeeBean.getAccount());
				//处理相关事项的表单页面的地址,连接外网。
				entity.setStepName("领导审批");//步骤名称
				entity.setFlowType("WIFI");//流转步骤的类型
				entity.setImportLevel("0");//缓急程度
//				entity.setUserIDConsigned("");//委托人员工号（选填）
//				entity.setUserNameConsigned("");//委托人姓名（选填）
				entity.setUserID(employeeBean.getAccount());//处理人员工号
				entity.setUserName(employeeBean.getName());//处理人姓名
				entity.setUserDeptName("信息服务部");//处理人所在部门名称
				entity.setCreatID(apa2);//撰稿人员工号
				entity.setCreatName(apn2);//撰稿人姓名
				//获取当前时间  
				entity.setCreatTime(df.format(new Date()));
				entity.setCreatDeptName("信息服务部");//撰稿人所在部门名称
				res = soap1.insertNewWFInstanceByEntity("WIFI", "WIFI", "123", entity);
				System.err.println(res);
			}				
			if("1".equals(result)) {
				return "OK";
			}else {
				return res;
			}			
	}
	
	@Override
	public String approve3(String phoneNumber, String day) {
		// TODO Auto-generated method stub
		//根据手机号找到该用户的审批流水号
		Staff staff = staffRepository.findByPhoneNumber(phoneNumber);
		//该手机号码为注册页面传入过来，而在注册时就已经生成了instanceId，所以staff.getInstanceId()不可能为空！
		String instanceId = staff.getInstanceId();		
		//调用川航接口 
		OaWfWebService oa = new OaWfWebService();
		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
		//将申请的时间转化为int类型
		int applyTime = Integer.parseInt(day);
		//获取当前时间
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		//设置过期时间,并保存到数据库中去
		Date overtime = DateUtil.getDayOn(applyTime);
		staff.setOvertime(overtime);		
		//修改阅读时间和处理时间 审批通过
		//参数依次为 项目代码 用户名 密码 工作流步骤 委托人工号(可以为空) 委托人姓名(可以为空) 阅读时间 处理时间 
		String result = soap.updateWFInstanceStatus("WIFI", "WIFI", "123", instanceId, "3", null, null, time, time);
		if("1".equals(result)) {
			String pwd = Code.getStringRandom();
			//开启内网权限，调用imc接口增加一个用户。
			
			//生成帐号密码，将更新的信息保存到数据库中
			staff.setUserName(phoneNumber);
			staff.setPassword(pwd);
			staffRepository.saveAndFlush(staff);	
			//调用短信接口告知用户已经开启无线网络
			SMS2009 sms = new SMS2009();
			SMS2009Soap smsSoap = sms.getSMS2009Soap();
			String xmlCommand = "<Root>\r\n" + 
					"	<Command>SendSingle</Command>\r\n" + 
					"	<LoginName>btim</LoginName>\r\n" + 
					"	<LoginPassword>jfwls</LoginPassword>\r\n" + 
					"	<TaskName></TaskName>\r\n" + 
					"	<TaskCategory>内部运行通知</TaskCategory>\r\n" + 
					"	<Tel>"+phoneNumber+"</Tel>\r\n" + 
					"	<SentTime></SentTime>\r\n" + 
					"	<Interval>1</Interval>\r\n" + 
					"	<Content><![CDATA[无线网络审批通过,已为您开通 "+day+" 天无线网络!您的wifi用户名："+phoneNumber+" ,密码："+pwd+"。]]></Content>\r\n" + 
					"	<ReturnURL></ReturnURL>\r\n" + 
					"<IsAntiDisturb>-1</IsAntiDisturb>\r\n" + 
					"</Root>";
			String jieguo = smsSoap.executeCommand(xmlCommand);
			if(jieguo.contains("<Code>0</Code>")) {
				return "审批通过";
			}			
			return "error:"+jieguo;
		}
		return "error:"+result;
	}

}
