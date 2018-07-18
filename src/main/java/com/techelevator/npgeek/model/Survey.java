package com.techelevator.npgeek.model;

public class Survey {
	private int sureveyId;
	private String parkCode;
	private String emailAddress;
	private String state;
	private String activityLevel;
	
	public int getSureveyId() {
		return sureveyId;
	}
	public void setSureveyId(int sureveyId) {
		this.sureveyId = sureveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
