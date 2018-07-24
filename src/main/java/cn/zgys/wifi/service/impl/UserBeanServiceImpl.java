package cn.zgys.wifi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zgys.wifi.entity.UserBean;
import cn.zgys.wifi.repository.UserBeanRepository;
import cn.zgys.wifi.service.UserBeanService;

@Service("UserBeanService")
public class UserBeanServiceImpl implements UserBeanService {
	
	private final UserBeanRepository userBeanRepository;
	
	@Autowired
	public UserBeanServiceImpl(UserBeanRepository userBeanRepository) {
		this.userBeanRepository = userBeanRepository;
	}

	@Override
	public UserBean findUserBean(String account,String pwd) {
		// TODO Auto-generated method stub
		return userBeanRepository.findByAccountAndPwd(account, pwd);
	}

}
