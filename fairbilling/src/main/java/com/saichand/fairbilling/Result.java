package com.saichand.fairbilling;

public class Result {

	private String userName;
	private int totalSessions;
	private long totalSeconds;
	
	public Result() {
		
	}

	public Result(String userName, int totalSessions, long totalSeconds) {
		this.userName = userName;
		this.totalSessions = totalSessions;
		this.totalSeconds = totalSeconds;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotalSessions() {
		return totalSessions;
	}

	public void setTotalSessions(int totalSessions) {
		this.totalSessions = totalSessions;
	}

	public long getTotalSeconds() {
		return totalSeconds;
	}

	public void setTotalSeconds(long totalSeconds) {
		this.totalSeconds = totalSeconds;
	}

	@Override
	public String toString() {
		return "Result [userName=" + userName + ", totalSessions=" + totalSessions + ", totalSeconds=" + totalSeconds
				+ "]";
	}

	
}
