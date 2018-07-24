package cn.zgys.wifi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class UserBean implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//帐号
	private String account;
	//密码
	private String pwd;
}
