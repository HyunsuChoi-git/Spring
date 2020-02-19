package test.spring.model;

import java.util.Date;

public class TestDTO {

	private String id;
	private String pw;
	private Date reg;
	
	public TestDTO() {}
	public TestDTO(String id) {
		this.id = id;
	}
	public TestDTO(String id, Date reg) {
		this.id = id; this.reg = reg;
	}
	public TestDTO(String id, String pw, Date reg) {
		this.id = id; this.reg = reg; this.pw = pw;
	}
	
	
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
