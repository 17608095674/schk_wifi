package cn.zgys.wifi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class LogBean implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//用户名
	private String userName;
	//密码
	private String password;
	//真实姓名
	private String realName;
	//身份证号码
	private String idCard;
	//区域
	private String area;
	//电话
	private String phoneNumber;
	//登录时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginTime;
	//过期时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date overTime;
	@Override
	public String toString() {
		return "LogBean [id=" + id + ", userName=" + userName + ", realName=" + realName + ", idCard=" + idCard
				+ ", area=" + area + ", phoneNumber=" + phoneNumber + ", loginTime=" + loginTime + ", overTime="
				+ overTime + "]";
	}
		
}
