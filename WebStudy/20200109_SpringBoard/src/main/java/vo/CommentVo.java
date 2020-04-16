package vo;

public class CommentVo {

	int idx;
	
	String content;
	String ip;
	String m_name;
	int m_idx;
	int b_idx;
	
	String regdate;
	
	
	public CommentVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentVo(String content, String ip, String m_name, int m_idx, int b_idx) {
		super();
		this.content = content;
		this.ip = ip;
		this.m_name = m_name;
		this.m_idx = m_idx;
		this.b_idx = b_idx;
	}




	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}




	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	

	
}
