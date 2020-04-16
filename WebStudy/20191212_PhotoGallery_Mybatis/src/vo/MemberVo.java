package vo;

public class MemberVo {

	int idx;
	String name,id,pwd,zipcode,addr,ip,regdate,modifydate;
	String grade;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MemberVo(String name, String id, String pwd, String zipcode, String addr, String ip, String grade) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.zipcode = zipcode;
		this.addr = addr;
		this.ip = ip;
		this.grade = grade;
	}

    

	public MemberVo(int idx, String name, String pwd, String zipcode, String addr, String ip, String grade) {
		super();
		this.idx = idx;
		this.name = name;
		this.pwd = pwd;
		this.zipcode = zipcode;
		this.addr = addr;
		this.ip = ip;
		this.grade = grade;
	}


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	
	
}
