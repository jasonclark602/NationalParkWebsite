package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;

@Component
public class JdbcWeatherDao implements WeatherDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCodeToday(String parkCode) {
		List<Weather> parkWeather = new ArrayList<>();
		String sqlWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ? AND fivedayforecastvalue = 1;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeatherByParkCode, parkCode.toUpperCase());
		while(results.next()) {
			parkWeather.add(mapToRow(results));
		}
		return parkWeather;
	}
	
	@Override
	public List<Weather> getWeatherByParkCodeWeek(String parkCode) {
		List<Weather> parkWeather = new ArrayList<>();
		String sqlWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ? AND fivedayforecastvalue BETWEEN 2 AND 5;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeatherByParkCode, parkCode.toUpperCase());
		while(results.next()) {
			parkWeather.add(mapToRow(results));
		}
		return parkWeather;
	}
	
	private Weather mapToRow(SqlRowSet results) {
		Weather temp = new Weather();
		temp.setParkCode(results.getString("parkcode"));
		temp.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		temp.setLow(results.getInt("low"));
		temp.setHigh(results.getInt("high"));
		temp.setForecast(results.getString("forecast"));
		return temp;
	}

}
