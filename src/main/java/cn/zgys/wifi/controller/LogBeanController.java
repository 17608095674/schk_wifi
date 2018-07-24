package cn.zgys.wifi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.service.LogBeanService;

@RestController
@RequestMapping
public class LogBeanController {
	
	private final LogBeanService logBeanService;
	
	Logger logger = LoggerFactory.getLogger(LogBeanController.class);
	
	@Autowired
	public LogBeanController(LogBeanService logBeanService) {
		this.logBeanService = logBeanService;
	}
	
	
	@RequestMapping(value="/users/page",method= {RequestMethod.GET})
	public PageBean getUsersByQueryParams( 
			@RequestParam(value="pageNumber", required=false,defaultValue = "1")int pageNumber,LogBean logBean) {
		PageBean pager = new PageBean();
		System.out.println(pageNumber);
		if(pageNumber<1) {
			pager.setPageNumber(1);
		}else {
			pager.setPageNumber(pageNumber);
		}		
		pager.setPageSize(10);
		try {
			pager = logBeanService.findAll(pager, logBean);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("LogBeanController----getUsersByQueryParams()", e);
			e.printStackTrace();
		}
		
		logger.info("LogBeanController----"+pager);
		return pager;
	} 

}
