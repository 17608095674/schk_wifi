package cn.zgys.wifi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import cn.zgys.wifi.entity.LogBean;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.repository.LogBeanRepository;
import cn.zgys.wifi.service.LogBeanService;
import cn.zgys.wifi.util.DateUtil;

@Service("LogBeanService")
public class LogBeanServiceImpl implements LogBeanService {
	
	private final LogBeanRepository logBeanRepository;
	
	@Autowired
	private LogBeanServiceImpl(LogBeanRepository logBeanRepository) {
		this.logBeanRepository = logBeanRepository;
	}

	@Override
	public void saveLogBean(LogBean log) {
		// TODO Auto-generated method stub
		logBeanRepository.save(log);
	}

	@Override
	public void updateLogBean(LogBean log) {
		// TODO Auto-generated method stub
		logBeanRepository.saveAndFlush(log);
	}

	@Override
	public void deleteLogBean(LogBean log) {
		// TODO Auto-generated method stub
		logBeanRepository.delete(log);
	}

	@Override
	public LogBean getLogBeanById(Long id) {
		// TODO Auto-generated method stub
		return logBeanRepository.findLogBeanById(id);
	}

	

	@Override
	public PageBean findAll(PageBean pager, LogBean log) {
		System.err.println(pager);
		Pageable LogPageable = new PageRequest(pager.getPageNumber()-1, pager.getPageSize());
		System.err.println("顺序===="+pager.getSort());
		System.err.println("排序字段"+pager.getOrder());
		if(!(pager.getSort()==null)) {
			if(pager.getOrder().equals("asc")) {
				LogPageable = new PageRequest(pager.getPageNumber()-1, pager.getPageSize(),new Sort(Sort.Direction.ASC,pager.getSort()));	
			}else {
				LogPageable = new PageRequest(pager.getPageNumber()-1, pager.getPageSize(),new Sort(Sort.Direction.DESC,pager.getSort()));	
			}
		}
				
//		Pageable LogPageable = new PageRequest(pager.getPageNumber()-1, pager.getPageSize());
		// TODO Auto-generated method stub
		Page<LogBean> page = logBeanRepository.findAll(new Specification<LogBean>() {
			@Override
			public Predicate toPredicate(Root<LogBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				List<Predicate> list = new ArrayList<Predicate>();
				if (!StringUtils.isEmpty(log.getUserName())) {
	                list.add(cb.like(root.get("userName").as(String.class),log.getUserName() + "%"));
	            }

            	list.add(cb.greaterThanOrEqualTo(root.get("loginTime").as(Date.class),DateUtil.getHalfYearAgo()));
	            
//	            if (!StringUtils.isEmpty(log.getArea())) {
//	                list.add(cb.equal(root.get("area").as(String.class), log.getArea()));
//	            }
	            //模糊查询时间
//	            if (!(log.getLoginTime()==null)) {
//	            	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	            	String str = df.format(log.getLoginTime().getTime() + (long)(1 * 24 * 60 * 60 * 1000));
//	            	Date date = null;
//					try {
//						date = df.parse(str);
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	            	list.add(cb.greaterThanOrEqualTo(root.get("loginTime").as(Date.class), log.getLoginTime()));
//	            	list.add(cb.lessThanOrEqualTo(root.get("loginTime").as(Date.class),date ));
//	            	System.err.println(date+"****");
////	            	list.add(cb.equal(root.get("loginTime").as(Date.class), log.getLoginTime()));    
//	            }	            
				Predicate[] p = new Predicate[list.size()];
	            return cb.and(list.toArray(p));	
			}
		},LogPageable);
		pager.setRows(page.getContent());
		pager.setPageSize(page.getSize());
		pager.setTotal(page.getTotalElements());
		return pager;

	}

}



//	@Override
//	public PageBean getLogsByQueryParams(PageBean pager, LogBean log) throws Exception {
//		// TODO Auto-generated method stub
//		List<LogBean> result = logBeanRepository.findAll(new Specification<LogBean>() {
//			
//			@Override
//			public Predicate toPredicate(Root<LogBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				// TODO Auto-generated method stub
//				 List<Predicate> list = new ArrayList<Predicate>();
//				 System.err.println(log.getArea().equals("null"));
//				 	if (!StringUtils.isEmpty(log.getUserName())) {
//		                list.add(cb.like(root.get("userName").as(String.class),log.getUserName() + "%"));
//		            }
//
//		            if (!StringUtils.isEmpty(log.getType())) {
//		                list.add(cb.equal(root.get("type").as(String.class), log.getType()));
//		            }	
//		            
//		            if (!StringUtils.isEmpty(log.getArea())) {
//		                list.add(cb.equal(root.get("area").as(String.class), log.getArea()));
//		            }
//		            
//		            if (!(log.getLoginTime()==null)) {
//		            	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		            	String str = df.format(log.getLoginTime().getTime() + (long)(1 * 24 * 60 * 60 * 1000));
//		            	Date date = null;
//						try {
//							date = df.parse(str);
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		            	list.add(cb.greaterThanOrEqualTo(root.get("loginTime").as(Date.class), log.getLoginTime()));
//		            	list.add(cb.lessThanOrEqualTo(root.get("loginTime").as(Date.class),date ));
//		            	System.err.println(date+"****");
////		            	list.add(cb.equal(root.get("loginTime").as(Date.class), log.getLoginTime()));
//		            }
//		            if(!StringUtils.isEmpty(pager.getSort())) {
//		            	System.err.println(pager.getOrder()+"  "+pager.getSort());
//		            	if(pager.getOrder().equals("desc")&&pager.getSort().equals("loginTime")) {
//		            		query.orderBy(cb.desc(root.get("loginTime").as(Date.class)));
//		            	}
//		            	if(pager.getOrder().equals("desc")&&pager.getSort().equals("overTime")) {
//		            		query.orderBy(cb.desc(root.get("overTime").as(Date.class)));
//		            	}
//		            	if(pager.getOrder().equals("asc")&&pager.getSort().equals("overTime")) {
//		            		query.orderBy(cb.asc(root.get("overTime").as(Date.class)));
//		            	}
//		            	if(pager.getOrder().equals("asc")&&pager.getSort().equals("loginTime")){
//		            		query.orderBy(cb.asc(root.get("loginTime").as(Date.class)));
//		            	}
//		            }
//		            		       		            
//		            Predicate[] p = new Predicate[list.size()];
//		            return cb.and(list.toArray(p));				 
//			}
//				
//		});
//		//分页
//		pager.setTotal(result.size());
//		List<LogBean> datas =  result.subList(pager.getIndex(),(result.size()-pager.getIndex()>pager.getPageSize()?pager.getPageNumber()+pager.getPageSize():result.size()));		
//		pager.setRows(datas);				
//		return pager;
//	}