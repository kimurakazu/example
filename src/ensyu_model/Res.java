package ensyu_model;

import java.sql.Timestamp;

public class Res {
	private int number;
	private String name,main;
	Timestamp time;

	public Res(int number, String name, String main, Timestamp time) {
		this.number = number;
		this.name = name;
		this.main = main;
		this.time = time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


}
