package cn.zgys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.sound.midi.SysexMessage;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.schk.oatest.OaWfWebService;
import cn.schk.oatest.OaWfWebServiceSoap;
import cn.schk.oatest.WFInterfaceEntity;
import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.service.EmployeeBeanService;
import cn.zgys.wifi.service.LogBeanService;
import cn.zgys.wifi.service.StaffService;
import cn.zgys.wifi.util.RedisDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchkWifiApplicationTests {
	
	@Resource
	private  LogBeanService logBeanServiceImpl;
	@Resource
	private  EmployeeBeanService employeeBeanService;
	@Resource
	private  StaffService staffServiceImpl;
		
	
	@Resource
    RedisDao redisDao;

	@Test
	public void contextLoads() {
//		System.err.println(employeeBeanService.findByLevelEquals("4").size());
		System.err.println(employeeBeanService.findByAccount("004323"));
		
	}
	
	@Test
	public void test8() {
		OaWfWebService oa = new OaWfWebService();
		OaWfWebServiceSoap soap = (OaWfWebServiceSoap) oa.getOaWfWebServiceSoap();
		cn.schk.oatest.WFInterfaceEntity entity = new WFInterfaceEntity();
		entity.setInstanceID("123456");//项目编号
		entity.setStepID("1");
		entity.setProjectCode("WIFI");
		entity.setProjectName("WIFI"); 		
		entity.setInstanceTitle("互联网无线网络申请");						
		entity.setFormURL("http://172.18.81.246:80/approveOut?realName="+"xxx"+
				"&phoneNumber="+"17608095674"+"&idCard="+"511124199612070054"+"&day="+"10"+"&reason="+
				"软件开发"+"&account="+"007957"+"&name="+"卞光尧"+"&apn="+"钟瑞"+
				"&apa="+"007962");//处理相关事项的表单页面的地址,连接外网。
		entity.setStepName("领导审批");//步骤名称
		entity.setFlowType("WIFI");//流转步骤的类型
		entity.setImportLevel("0");//缓急程度
		entity.setUserID("007962");//处理人员工号
		entity.setUserName("钟瑞");//处理人姓名
		entity.setUserDeptName("信息服务部");//处理人所在部门名称
		entity.setCreatID("007957");//撰稿人员工号
		entity.setCreatName("卞光尧");//撰稿人姓名
		//获取当前时间  
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		entity.setCreatTime(df.format(new Date()));
		entity.setCreatDeptName("信息服务部");//撰稿人所在部门名称
		String result = soap.insertNewWFInstanceByEntity("WIFI", "WIFI", "123", entity);
		System.err.println(result);	
	}
	
//	public static void main(String[] args) {
//		 DefaultHttpClient client = new DefaultHttpClient();
//	        client.getCredentialsProvider().setCredentials(
//	            new AuthScope("172.18.81.245", 8080, "iMC RESTful Web Services"),
//	            new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
////	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/online?size=60");
//	        HttpPost post = new HttpPost("http://172.18.81.245:8080/imcrs/uam/acmUser/uamlogin?userName=002340&password=shan1981&ifEncrypt=0");
////	        post.
////	        post.addHeader("accept", "application/xml");
////	        String str1 = "\n" + 
////	        		"\n" + 
////	        		"<acmUser>\n" + 
////	        		" <platUserId>95674</platUserId>\n" + 
////	        		" <userName>5674</userName>\n" + 
////	        		" <userPassword>095674</userPassword>\n" + 
////	        		"<ifSelfModifyPsd>false</ifSelfModifyPsd>\n" + 	        		
////	        		" <appliedService>\n" + 
////	        		"  <serviceTemplateId>6</serviceTemplateId>\n" +
////	        		"  <userIp></userIp>"+
////	        		" </appliedService>\n" + 	        	
////	        		"</acmUser>\n" + 
////	        		"\n" + 
////	        		"";
////	        StringEntity entity = new StringEntity(str1, Charset.forName("UTF-8"));
////	        entity.setContentType("application/xml");
////	        entity.setContentEncoding("UTF-8");
////	        post.setEntity(entity);
//	        HttpResponse response = null;
//			try {
//				response = client.execute(post);
//				System.err.println(response.getStatusLine());
////				String s = EntityUtils.toString(response.getEntity());
//				String str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
//				System.err.println(str);
////				System.err.println(EntityUtils.toString(response.getEntity()));
//			} catch (ClientProtocolException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//	}
	
	
//	public static void main(String[] args) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd%20HH:mm");
//	    String str = format.format(new Date());
//		System.out.println(str);
//	}
	
	public static void main(String[] args) {
		String str = "<Root><Error><Code>0</Code><Message></Message></Error><Return>"
				+ "<TaskDetialID>145522980</TaskDetialID></Return></Root>\n"; 
		System.err.println(str.contains("<Code>0</Code>")); 
	}
	
	/**
	 * 增加用户
	 */
	@Test
	public void test7() {
		 DefaultHttpClient client = new DefaultHttpClient();
	        client.getCredentialsProvider().setCredentials(
	            new AuthScope("172.18.81.245", 8080, "iMC RESTful Web Services"),
	            new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
//	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/online?size=60");
	        HttpPost post = new HttpPost("http://172.18.81.245:8080/imcrs/uam/acmUser");//?userName=002340&password=shan1981&ifEncrypt=0
	        post.addHeader("accept", "application/xml");
	        String str1 = "\n" + 
	        		"\n" + 
	        		"<acmUser>\n" + 
	        		" <platUserId>95674</platUserId>\n" + 
	        		" <userName>5674</userName>\n" + 
	        		" <userPassword>095674</userPassword>\n" + 
	        		"<ifSelfModifyPsd>false</ifSelfModifyPsd>\n" + 	        		
	        		" <appliedService>\n" + 
	        		"  <serviceTemplateId>6</serviceTemplateId>\n" +
	        		"  <userIp></userIp>"+ 
	        		" </appliedService>\n" + 	        	
	        		"</acmUser>\n" + 
	        		"\n" + 
	        		"";
	        StringEntity entity = new StringEntity(str1, Charset.forName("UTF-8"));
	        entity.setContentType("application/xml");
	        entity.setContentEncoding("UTF-8");
	        post.setEntity(entity);
	        HttpResponse response = null;
			try {
				response = client.execute(post);
				System.err.println(response.getStatusLine());
//				String s = EntityUtils.toString(response.getEntity());
				String str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
				System.err.println(str);
//				System.err.println(EntityUtils.toString(response.getEntity()));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

	}
	
	//在线终端类型
	@Test
	public void test4() {
		 DefaultHttpClient client = new DefaultHttpClient();
	        client.getCredentialsProvider().setCredentials(
	            new AuthScope("172.18.81.245", 8080, "iMC RESTful Web Services"),
	            new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/online?size=100000");
//	        HttpPost post = new HttpPost("http://172.18.81.245:8080/imcrs/uam/acmUser/acmUserList");
//	        post.
	        get.addHeader("accept", "application/xml");
	        HttpResponse response = null;
			try {
				response = client.execute(get);
				System.err.println(response.getStatusLine());
//				String s = EntityUtils.toString(response.getEntity());
				String str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
				System.err.println(str);
//				System.err.println(EntityUtils.toString(response.getEntity()));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

	}
	
	//根据时间查询在线人数
	@Test
	public void test6() {
		
		 DefaultHttpClient client = new DefaultHttpClient();
	        client.getCredentialsProvider().setCredentials(
	            new AuthScope("172.18.81.245", 8080, "iMC RESTful Web Services"),
	            new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
//	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/acmUser/002340");
//	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/acmUser/userPwd/002340");
	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/onlineStat?startDate=2018-07-10%2000%3A00&endDate=2018-07-10%203%3A59");
//	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/plat/operator/1");
//	        HttpPost post = new HttpPost("http://172.18.81.245:8080/imcrs/uam/acmUser/acmUserList");
//	        post.
//	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/online?size=100000");
	        get.addHeader("accept", "application/xml");
	        HttpResponse response = null;
	        String str = null;
			try {
				response = client.execute(get);
				System.err.println(response.getStatusLine());
//				String s = EntityUtils.toString(response.getEntity());
				str = new String(EntityUtils.toString(response.getEntity()).getBytes("ISO-8859-1"),"UTF-8");
				System.err.println(str);
//				System.err.println(EntityUtils.toString(response.getEntity()));
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		try {
			Document doc=(Document)DocumentHelper.parseText(str);
			Element rootElt  = doc.getRootElement();
			 System.err.println("根节点"+rootElt .getName()); 
			 Iterator  Elements = rootElt.elementIterator("online");
			 int i =1;
			 while(Elements.hasNext()){  
	                Element user = (Element)Elements.next();   
	                String OS = user.elementTextTrim("terminalOs");	                
	                	System.err.print("节点"+user.getName()+"  "); 
		                System.err.println(OS+"  "+i++);	                	        	               
	            }   
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
	}
	
	//在线人数
	@Test
	public void test5() {
		 DefaultHttpClient client = new DefaultHttpClient();
	        client.getCredentialsProvider().setCredentials(
	            new AuthScope("172.18.81.245", 8080, "iMC RESTful Web Services"),
	            new UsernamePasswordCredentials("admin", "Scal#$%(!@#"));
	        HttpGet get = new HttpGet("http://172.18.81.245:8080/imcrs/uam/online?total=true");
	        get.addHeader("accept", "application/xml");
	        HttpResponse response = null;
			try {
				response = client.execute(get);
//				System.err.println(response.getStatusLine());
//				System.err.println(response.getFirstHeader("Total"));
				String s = response.getFirstHeader("Total").toString();
				String[] a =s.split(":");
				System.err.println(a[1].trim());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	
	
//	public static void main(String[] args) {
//		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><list><acmUser><userName>wpsadmin</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>wpsadmin</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/wpsadmin\"/></acmUser><acmUser><userName>wpsbind</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>wpsbind</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/wpsbind\"/></acmUser><acmUser><userName>000008</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>ææµ·é¹°</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/000008\"/></acmUser><acmUser><userName>001950</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>éç²A</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/001950\"/></acmUser><acmUser><userName>002137</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>ææ</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/002137\"/></acmUser><acmUser><userName>000011</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>å¨æå</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/000011\"/></acmUser><acmUser><userName>002481</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>æå</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/002481\"/></acmUser><acmUser><userName>000168</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>ç³ç¥ä¹</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/000168\"/></acmUser><acmUser><userName>003342</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>ç³å</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/003342\"/></acmUser><acmUser><userName>003340</userName><userGroupId>1</userGroupId><userGroupName>æªåç»</userGroupName><fullName>è®¸çè¾</fullName><status>1</status><userCreateTime>2017-07-13</userCreateTime><invalidTime></invalidTime><ifWsmEnable>0</ifWsmEnable><ifEnableDelMAC>false</ifEnableDelMAC><link op=\"GET\" rel=\"self\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/003340\"/></acmUser><link op=\"GET\" rel=\"next\" href=\"http://172.18.81.245:8080/imcrs/uam/acmUser/acmUserList?start=10&amp;size=10\"/></list>\n" + 
//				"";
//		
//		try {
//			String str = new String(s.getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println(str);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
	
	@Test
	public void test2() {
		Date d=new Date();
		LogBean log = new LogBean();
		log.setLoginTime(d);
		logBeanServiceImpl.saveLogBean(log);
		System.err.println("ok");
		
		System.err.println(logBeanServiceImpl.getLogBeanById(3L).getLoginTime());
		
	}
	@Test
	public void test3() {
//		PageBean pager = new PageBean();
//		pager.setPageNumber(1);
//		pager.setPageSize(10);
//		LogBean log = new LogBean();
//		log.setArea("区域一");
//		logBeanServiceImpl.findAll1(pager, log);
		LogBean log1 = new LogBean(0, "13608095674", "访客", "登录", "区域一", "13608095674", null, null);
		LogBean log2= new LogBean(0, "12628294756", "访客", "登录", "区域二", "13608095674", null, null);
		LogBean log3 = new LogBean(0, "13608095674", "内部人员", "登录", "区域一", "13608095674", null, null);
		LogBean log4 = new LogBean(0, "13656740809", "内部人员", "注册", "区域一", "13608095674", null, null);
		LogBean log5 = new LogBean(0, "13608095674", "访客", "登录", "区域一", "13608095674", null, null);
		LogBean log6 = new LogBean(0, "13609085674", "内部人员", "登录", "区域二", "13608095674", null, null);
		LogBean log7 = new LogBean(0, "13608095674", "访客", "登录", "区域一", "13608095674", null, null);
		logBeanServiceImpl.saveLogBean(log1);
		logBeanServiceImpl.saveLogBean(log2);
		logBeanServiceImpl.saveLogBean(log3);
		logBeanServiceImpl.saveLogBean(log4);
		logBeanServiceImpl.saveLogBean(log5);
		logBeanServiceImpl.saveLogBean(log6);
		logBeanServiceImpl.saveLogBean(log7);
		
	}
	
	@Test
	public void test1() {
//		redisDao.setKey("123", "789");
		Date d=new Date();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		LogBean log = new LogBean();
//		log.setType("访客");
//		df.format(logBeanServiceImpl.getLogBeanById(15L).getLoginTime());
		 String str = df.format(d);
		log.setLoginTime(logBeanServiceImpl.getLogBeanById(15L).getLoginTime());
		System.err.println(df.format(logBeanServiceImpl.getLogBeanById(15L).getLoginTime()));
		System.err.println(log.getLoginTime());
		PageBean pager = new PageBean();
		pager.setPageNumber(1);
		pager.setPageSize(10);
		try {
//			logBeanServiceImpl.getLogsByQueryParams(pager, log);
//			System.out.println(logBeanServiceImpl.getLogsByQueryParams(pager, log));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
