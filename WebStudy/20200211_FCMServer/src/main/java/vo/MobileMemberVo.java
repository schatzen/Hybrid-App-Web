package vo;

import java.io.Serializable;

public class MobileMemberVo implements Serializable{

	int idx;
	String name;
	String id;
	String pwd;
	String device_token;
	
	public MobileMemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MobileMemberVo(String name, String id, String pwd) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}




	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	
	
	
}
