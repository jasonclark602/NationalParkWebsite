package com.techelevator.npgeek.dao;

public interface SurveyDao {
	public void saveNewSurvey(String parkCode, String emailAddress, String state, String activityLevel);
}
