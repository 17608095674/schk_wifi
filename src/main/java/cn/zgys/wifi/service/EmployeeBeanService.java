package cn.zgys.wifi.service;

import java.util.List;

import cn.zgys.wifi.entity.EmployeeBean;
import cn.zgys.wifi.entity.PageBean;

public interface EmployeeBeanService {
	
	List<EmployeeBean> findByLevelEquals(String level);
	
	PageBean findAllByPage(PageBean pager,EmployeeBean emp);
	
	void deleteEmployee(Long id);
	
	void addEmployee(EmployeeBean emp);
	
	void updateEmployee(EmployeeBean emp);
	
	EmployeeBean findByAccount(String account);

}
