package cn.zgys.wifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import cn.zgys.wifi.entity.LogBean;

public interface LogBeanRepository extends JpaRepository<LogBean, Long>,JpaSpecificationExecutor<LogBean>{
	
	LogBean findLogBeanById(Long id);
	
}
