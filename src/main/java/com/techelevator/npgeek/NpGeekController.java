package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.WeatherDao;

@Controller
public class NpGeekController {

	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping(path = {"/", "/homePage"}, method = RequestMethod.GET)
	public String displayHomePage(ModelMap modelHolder) {
		modelHolder.put("parks", parkDao.getAllParks());
		return "homePage";
	}
	
	@RequestMapping(path = {"/detailPage"}, method = RequestMethod.GET)
	public String displayDetailPage(ModelMap modelHolder, @RequestParam String parkCode) {
		modelHolder.put("park", parkDao.getParkByParkCode(parkCode.toUpperCase()));
		modelHolder.put("todayWeather", weatherDao.getWeatherByParkCodeToday(parkCode.toUpperCase()));
		modelHolder.put("weekWeather", weatherDao.getWeatherByParkCodeWeek(parkCode.toUpperCase()));
		return "detailPage";
	}
}
