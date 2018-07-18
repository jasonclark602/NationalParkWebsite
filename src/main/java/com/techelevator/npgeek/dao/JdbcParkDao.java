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
public class JdbcParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapToRow(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park temp = new Park();
		String sqlGetParkByCode = "SELECT * FROM park WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByCode, parkCode);
		while(results.next()) {
			temp = mapToRow(results);
		}
		return temp;
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
		
		return park;
		
	}

}
