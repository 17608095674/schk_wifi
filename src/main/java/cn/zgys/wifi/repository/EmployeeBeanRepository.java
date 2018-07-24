package cn.zgys.wifi.repository;

import cn.zgys.wifi.entity.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeBeanRepository extends JpaRepository<EmployeeBean, Long>,JpaSpecificationExecutor<EmployeeBean>{	
	
	List<EmployeeBean> findByLevelEquals(String level);
	
	EmployeeBean findByAccountEquals(String account);
	
	EmployeeBean findById(String id);
	
}
