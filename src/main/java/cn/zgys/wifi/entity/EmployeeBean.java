package cn.zgys.wifi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class EmployeeBean {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String account; //工号
	private String name; //姓名
	private String department; //部门
	private String level; //职级
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", account=" + account + ", name=" + name + ", department=" + department
				+ ", level=" + level + ", createTime=" + createTime + "]";
	}
		
	
	
}
