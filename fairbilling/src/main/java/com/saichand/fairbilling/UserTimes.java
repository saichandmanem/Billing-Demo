package com.saichand.fairbilling;

public class UserTimes {
	
	private String userName;
	private String startTime;
	private String endTime;
	
	public UserTimes() {
		
	}

	public UserTimes(String userName) {
		this.userName = userName;
	}

	public UserTimes(String userName, String startTime, String endTime) {
		this.userName = userName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "UserSession [userName=" + userName + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	

}
