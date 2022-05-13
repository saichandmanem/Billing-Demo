package com.saichand.fairbilling;

public class EachLine {

	private String time;
	private String userName;
	private String mode;
	
	public EachLine() {
		
	}

	public EachLine(String time, String userName, String mode) {
		this.time = time;
		this.userName = userName;
		this.mode = mode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Lines [time=" + time + ", userName=" + userName + ", mode=" + mode + "]";
	}
	
	
}
