package cn.zgys.wifi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.zgys.wifi.entity.UserBean;

public interface UserBeanRepository extends JpaRepository<UserBean, Long>{
	
	UserBean findByAccountAndPwd(String account,String pwd);
	
}
