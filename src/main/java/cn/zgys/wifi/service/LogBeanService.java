package cn.zgys.wifi.service;

import java.util.Map;

import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.entity.UserBean;

public interface LogBeanService {
	
	//
	void saveLogBean(LogBean log);

	//
	void updateLogBean(LogBean log);
	
	//
	void deleteLogBean(LogBean log);
	
	//
	LogBean getLogBeanById(Long id);
	
	//PageBean getLogsByQueryParams(PageBean pager,LogBean log)throws Exception;
	
	//查询访客登录信息
	PageBean findAll(PageBean pager, LogBean log);
	
	
}
