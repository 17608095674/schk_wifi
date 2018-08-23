package cn.zgys.wifi.controller;

import cn.zgys.wifi.entity.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.Messager;
import cn.zgys.wifi.service.StaffService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class StaffController {
	
	private final StaffService staffService;
	
	Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}
	
	//登录
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public Messager login( @RequestParam(value="userName", required=true) String userName,
	        @RequestParam(value="password", required=true) String password
	        ) {
		Messager msg = new Messager(true,"登录成功");		

			String str = staffService.login(userName, password);
			if("登录成功".equals(str)) {
				logger.info("=== staff login with userName :{} and msg :{}",userName,str);
				return msg;			
			}else {
				logger.error("=== staff login with userName :{} and msg :{}",userName,str);
				msg.setStatus(false);
				msg.setInformation(str);
				return msg;
			}			

	}
	
	
//	@RequestMapping(value="/visitLogin")
//	public String visitLogin(@RequestParam(value="phoneNumber", required=true) String phoneNumber,
//	        @RequestParam(value="code", required=true) String code) {
//		String msg = staffService.visitorLogin(phoneNumber, code);
//		if("验证码错误!".equals(msg)) {
//			logger.warn("=== visitor login  :{} ===",msg);
//			return msg;			
//		}else if("登录成功".equals(msg)) {
//			logger.info("=== visitor login :{} ===",msg);
//			return msg;
//		}
//		logger.error("=== visitor login error");
//		return "error";
//	}
	
	//获取验证码
	@RequestMapping(value="/code",method= {RequestMethod.GET})
	public Messager getCode(@RequestParam(value="phoneNumber", required=true) String phoneNumber) {		
		Messager msg = new Messager(true,"短信验证码发送成功");
		String code = staffService.getCode(phoneNumber.trim());
		if(code.startsWith("发送失败")) {
			logger.error(" === phoneNumber :{} and msg :{} ===",phoneNumber,code);
			msg.setStatus(false);
			msg.setInformation(code);
			return msg;
		}
		logger.info(" === phoneNumber :{} and code :{} ===",phoneNumber,code);
		return msg;
	}
	
	//注册
	@RequestMapping(value="/regist",method= {RequestMethod.POST})
	public Messager regist(@RequestParam(value="realName", required=true) String realName,
						 @RequestParam(value="phoneNumber", required=true) String phoneNumber,
	        			 @RequestParam(value="code", required=true) String code,
	        			 @RequestParam(value="idCard", required=true) String idCard,
	        			 @RequestParam(value="name", required=true) String name,
	        			 @RequestParam(value="account", required=true) String account,
	        			 @RequestParam(value="limit", required=true) String limit,
	        			 @RequestParam(value="day", required=true) String day,
	        			 @RequestParam(value="reason", required=true) String reason) {
		Messager msg = new Messager(true,"已提交申请，请等待");
		String str = null;
		if("1".equals(limit)) {//互联网
			str = staffService.regist1(realName,phoneNumber,code,idCard,name,account,limit,day,reason);
		}else {//内网
			str = staffService.regist2(realName,phoneNumber,code,idCard,name,account,limit,day,reason);
		}		
		if("OK".equals(str)) {
			logger.info("=== staff regist phoneNumber :{} and msg :{} ===",phoneNumber,msg);		
		}else {
			logger.error("=== staff regist phoneNumber :{} and msg :{} ===",phoneNumber,msg);
			msg.setStatus(false);
			msg.setInformation(str);			
		}
		return msg;
	}
	
	//互联网审批通过
	@RequestMapping(value="/check",method= {RequestMethod.POST})
	public Messager check(@RequestParam(value="phoneNumber", required=true)String phoneNumber, 
						@RequestParam(value="day", required=true)String day) {
		Messager msg = new Messager(true,"审批通过");
		String str = staffService.check(phoneNumber, day);
		if("审批通过".equals(str)) {
			logger.info("=== staff check phoneNumber :{} and day :{} 天 and msg :{}  ===",phoneNumber,day,msg);
			return msg;
		}
		logger.error("=== staff check phoneNumber :{} and day :{} 天 and msg :{} ===",phoneNumber,day,msg);
		msg.setStatus(false);
		msg.setInformation(str);
		return msg;
	}
	
	
		//内网第一级审批
		@RequestMapping(value="/approve1",method= {RequestMethod.POST})
		public Messager approve1(
				 @RequestParam(value="phoneNumber", required=true) String phoneNumber,
				 @RequestParam(value="day", required=true) String day,
				 @RequestParam(value="apa1", required=true) String apa1,
				 @RequestParam(value="date1", required=true) String date1
				 ) {
			Messager msg = new Messager(true,"审批通过");
			String str = staffService.approve1(phoneNumber,day,apa1,date1);
			if("OK".equals(str)) {
				logger.info("=== staff approve1 phoneNumber :{} and day :{} 天 and msg :{}  ===",phoneNumber,day,msg);
				return msg;
			}
			logger.error("=== staff approve1 phoneNumber :{} and day :{} 天 and msg :{} ===",phoneNumber,day,msg);
			msg.setStatus(false);
			msg.setInformation(str);
			return msg;
		}

	
	//内网审批通过
		@RequestMapping(value="/approve2",method= {RequestMethod.POST})
		public Messager approve2(@RequestParam(value="phoneNumber", required=true)String phoneNumber,
				@RequestParam(value="day", required=true)String day
					) {
				Messager msg = new Messager(true,"审批通过");
				String str = staffService.approve2(phoneNumber, day);
				if("审批通过".equals(str)) {
					logger.info("=== staff approve2 phoneNumber :{} and day :{} 天 and msg :{}  ===",phoneNumber,day,msg);
					return msg;
				}
				logger.error("=== staff approve2 phoneNumber :{} and day :{} 天 and msg :{} ===",phoneNumber,day,msg);
				msg.setStatus(false);
				msg.setInformation(str);
				return msg;
			}
	
	
	
	
	//驳回
	@RequestMapping(value="/ref",method= {RequestMethod.POST})
	public Messager ref(@RequestParam(value="phoneNumber", required=true)String phoneNumber,
	@RequestParam(value="step", required=true)String step) {
		Messager msg = new Messager(true,"已驳回");
		String str = staffService.ref(phoneNumber,step);
		if("已驳回".equals(str)) {
			logger.info("=== staff ref phoneNumber :{} and msg :{}  ===",phoneNumber,msg);
			return msg;
		}
		logger.error("=== staff ref phoneNumber :{} and msg :{} ===",phoneNumber,msg);
		msg.setStatus(false);
		msg.setInformation(str);
		return msg;
	}


	//驳回
	@RequestMapping(value="/staff",method= {RequestMethod.GET})
	public Staff staff(@RequestParam(value="phoneNumber", required=true)String phoneNumber) {
		return staffService.staff(phoneNumber);
	}

	
}
