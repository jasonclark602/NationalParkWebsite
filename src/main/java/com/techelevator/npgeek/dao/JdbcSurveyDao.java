package com.techelevator.npgeek.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveNewSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		String sqlSaveNewSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) " +
								"VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sqlSaveNewSurvey, parkCode.toUpperCase(), emailAddress, state, activityLevel);
	}
}
