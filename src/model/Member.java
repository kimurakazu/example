package model;

public class Member {
	private int mid;
	private String name,adr;
	
	public Member() {
	}

	public Member(int mid, String name, String adr) {
		this.mid = mid;
		this.name = name;
		this.adr = adr;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	
}
