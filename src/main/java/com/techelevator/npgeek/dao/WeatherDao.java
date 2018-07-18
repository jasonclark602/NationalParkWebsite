package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Weather;

public interface WeatherDao {
	public List<Weather> getWeatherByParkCodeToday(String parkCode);
	public List<Weather> getWeatherByParkCodeWeek(String parkCode);
}
