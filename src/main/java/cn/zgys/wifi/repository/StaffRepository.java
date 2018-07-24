package cn.zgys.wifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.zgys.wifi.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	/**
	 * 根据用户名 和 密码查询用户
	 * 用于登录
	 * @param userName
	 * @param password
	 * @return
	 */
	Staff findByUserNameAndPassword(String userName, String password);
	/**
	 * 根据用户名查找用户
	 * 用于判断用户是内部人员还是驻地人员
	 * @param username
	 * @return
	 */
	Staff findByUserName(String username);
	/**
	 * 根据手机号码查询用户
	 * 用于判断手机号码是否已经注册
	 * @param phoneNumber
	 * @return
	 */
	Staff findByPhoneNumber(String phoneNumber);
}
