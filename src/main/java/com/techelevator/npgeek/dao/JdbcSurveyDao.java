package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;


@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveNewSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		String sqlSaveNewSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) " +
								"VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sqlSaveNewSurvey, parkCode.toUpperCase(), emailAddress, state, activityLevel);
	}

	@Override
	public List<Park> getFavoriteParks() {
		List<Park> favoriteParks = new ArrayList<>();
		String sqlSelectFavoriteParks = "SELECT park.*, COUNT(survey_result.parkcode) AS surveycount  FROM park JOIN survey_result ON park.parkcode = survey_result.parkcode " + 
				"GROUP BY park.parkname, park.parkcode " + 
				"ORDER BY COUNT(survey_result.parkcode)DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFavoriteParks);
		while(results.next()) {
			favoriteParks.add(mapToRow(results));
		}
				return favoriteParks;
	}
	
	private Park mapToRow(SqlRowSet results) {
		Park park = new Park();
		park.setAcreage(results.getInt("acreage"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setClimate(results.getString("climate"));
		park.setElevationInFeet(results.getInt("elevationinfeet"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setInspirationalQuote(results.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		park.setMilesOfTrail(results.getDouble("milesoftrail"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setParkCode(results.getString("parkcode").toLowerCase());
		park.setParkDescription(results.getString("parkdescription"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setNumberOfSurveys(results.getInt("surveycount"));
		
		return park;
		
	}
}
