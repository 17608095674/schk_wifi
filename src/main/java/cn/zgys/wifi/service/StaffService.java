package cn.zgys.wifi.service;

import org.springframework.web.bind.annotation.RequestParam;

import cn.zgys.wifi.entity.Staff;

public interface StaffService {
	/**
	 * 内部人员和驻地人员登录
	 * @param userName
	 * @param password
	 * @return
	 */
	String login(String userName,String password);
	/**
	 * 互联网申请注册
	 * @param staff
	 * @return
	 */
	String regist1(String realName,String phoneNumber,String code,String idCard,String name,String account,String limit,String day,String reason);
	/**
	 * 内网申请注册
	 * @param staff
	 * @return
	 */
	String regist2(String realName,String phoneNumber,String code,String idCard,String name,String account,String limit,String day,String reason);
	/**
	 * 获取验证码
	 * @param phone
	 * @return
	 */
	
	String getCode(String phoneNumber);
	
//	/**
//	 * 访客登录
//	 * 仅需要通过手机接收二维码登录即可
//	 * @param phoneNumber
//	 * @param code
//	 * @return
//	 */
//	String visitorLogin(String phoneNumber,String code);
	/**
	 * 审批通过
	 * 根据传入的手机号码，调用oa修改时间，并且根据传入的申请时间，修改数据库中的过期时间
	 * @param phoneNumber
	 * @param day
	 * @return
	 */
	String check(String phoneNumber,String day);
	
	/**
	 * 内网第一级审批
	 * @param phoneNumber
	 * @param day
	 * @param date1 第一级审批时间
	 * @return
	 */
	String approve1(String phoneNumber,String day,String apa1,String date1);

	/**
	 * 内网审批通过
	 * @param phoneNumber
	 * @param day
	 * @return
	 */
	String approve2(String phoneNumber,String day);
	/**
	 * 驳回
	 * @param phoneNumber
	 * @return
	 */
	String ref(String phoneNumber,String step);

	/**
	 * 根据手机号码查询信息
	 * @param phoneNumber
	 * @return
	 */
	Staff staff(String phoneNumber);
}
