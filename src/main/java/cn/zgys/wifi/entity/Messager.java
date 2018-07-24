package cn.zgys.wifi.entity;

//页面返回消息实体
public class Messager {
	//状态
	private boolean status;
	//信息
	private String information;
	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messager(boolean status, String information) {
		super();
		this.status = status;
		this.information = information;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Messager [status=" + status + ", information=" + information + "]";
	}
	
	
}
