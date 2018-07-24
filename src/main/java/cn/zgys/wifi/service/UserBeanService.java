package cn.zgys.wifi.service;

import cn.zgys.wifi.entity.UserBean;

public interface UserBeanService {
	/**
	 * 后台系统登录
	 * @param account 帐号
	 * @param pwd	密码
	 * @return
	 */
	UserBean findUserBean(String account,String pwd);

}
