package model;

public class Shouhin {
	private int sid;
	private String name;
	private int tanka;
	
	public Shouhin(int sid, String name, int tanka) {
		this.sid = sid;
		this.name = name;
		this.tanka = tanka;
	}

	public Shouhin() {
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTanka() {
		return tanka;
	}

	public void setTanka(int tanka) {
		this.tanka = tanka;
	}
	
	
	

}
