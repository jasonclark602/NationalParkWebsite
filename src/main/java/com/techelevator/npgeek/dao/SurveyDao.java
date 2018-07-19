package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Park;

public interface SurveyDao {
	public void saveNewSurvey(String parkCode, String emailAddress, String state, String activityLevel);
	public List<Park> getFavoriteParks();
}
