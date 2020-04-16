package vo;

public class ProductVo {

	int idx;
	String name;
	int cnt;
	String regdate;
	
	public ProductVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductVo(String name, int cnt) {
		super();
		this.name = name;
		this.cnt = cnt;
	}
	
	public ProductVo(int idx, String name, int cnt) {
		super();
		this.idx = idx;
		this.name = name;
		this.cnt = cnt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
