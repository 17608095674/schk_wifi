package cn.zgys.wifi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;




@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Staff implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//真实姓名
	private String realName;
	//帐号
	private String userName;
	//密码
	private String password;
	//电话
	private String phoneNumber;
	//身份证
	private String idCard;
	//流水号
	private String instanceId;
	//原因
	private String reason;
	//业务受理人信息
	private String business;
	//网络类别
	private String lit;
	//状态
	private int status;
	//申请时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	//过期时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date overtime;
	
}
