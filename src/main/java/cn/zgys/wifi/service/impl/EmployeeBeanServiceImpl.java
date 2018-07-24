package cn.zgys.wifi.service.impl;

import cn.zgys.wifi.entity.EmployeeBean;
import cn.zgys.wifi.entity.PageBean;
import cn.zgys.wifi.repository.EmployeeBeanRepository;
import cn.zgys.wifi.service.EmployeeBeanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service("EmployeeBeanService")
public class EmployeeBeanServiceImpl implements EmployeeBeanService {
	
	private final EmployeeBeanRepository employeeBeanRepository;
	
	@Autowired
	public EmployeeBeanServiceImpl(EmployeeBeanRepository employeeBeanRepository) {
		this.employeeBeanRepository = employeeBeanRepository;
	}

	@Override
	public List<EmployeeBean> findByLevelEquals(String level){
		// TODO Auto-generated method stub
		return employeeBeanRepository.findByLevelEquals(level);		  
	}

	@Override
	public PageBean findAllByPage(PageBean pager,EmployeeBean emp) {
		System.err.println(pager);
		pager.setOrder("level");
		
		Pageable EmpPageable = new PageRequest(pager.getPageNumber()-1, pager.getPageSize(),new Sort(Sort.Direction.DESC,pager.getOrder()));	
		
		// TODO Auto-generated method stub
		Page<EmployeeBean> page = employeeBeanRepository.findAll(new Specification<EmployeeBean>() {
			@Override
			public Predicate toPredicate(Root<EmployeeBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				List<Predicate> list = new ArrayList<Predicate>();
				if (!StringUtils.isEmpty(emp.getName())) {
	                list.add(cb.like(root.get("name").as(String.class),emp.getName() + "%"));
	            }
				Predicate[] p = new Predicate[list.size()];
	            return cb.and(list.toArray(p));	
			}
		},EmpPageable);
//		System.err.println(page.getTotalElements());
//		System.err.println(page.getNumberOfElements());
//		System.err.println(page.getSize());
//		System.err.println(page.getSort());
//		System.err.println(page.getNumber());
//		System.err.println(page.getContent());
		pager.setRows(page.getContent());
		pager.setPageSize(page.getSize());
		pager.setTotal(page.getTotalElements());
		return pager;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeBeanRepository.deleteById(id);
	}

	@Override
	public void addEmployee(EmployeeBean emp) {
		// TODO Auto-generated method stub
		employeeBeanRepository.saveAndFlush(emp);
	}

	@Override
	public EmployeeBean findByAccount(String account) {
		// TODO Auto-generated method stub
		return employeeBeanRepository.findByAccountEquals(account);
	}

	@Override
	public void updateEmployee(EmployeeBean emp) {
		// TODO Auto-generated method stub
		employeeBeanRepository.saveAndFlush(emp);
	}	

}
