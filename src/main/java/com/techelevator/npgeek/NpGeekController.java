package com.techelevator.npgeek;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.apache.bcel.generic.SWITCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.dao.WeatherDao;

@Controller
public class NpGeekController {

	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
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
	
	@RequestMapping(path = {"/switchTempUnit"}, method = RequestMethod.POST)
	public String switchTempUnit(@RequestParam String tempUnit,@RequestParam String parkCode ,HttpSession userSession) {
		if(tempUnit.equals("Celsius")) {
		userSession.setAttribute("tempUnit", tempUnit);
		
		}else if (tempUnit.equals("Fahrenheit")) {
			userSession.setAttribute("tempUnit", tempUnit);
		} 
		
		
		return "redirect:/detailPage?parkCode=" + parkCode;
	}
	

	
	@RequestMapping(path = {"/surveyPage"}, method = RequestMethod.GET)
	public String displaySurveyForm(ModelMap modelHolder) {
		modelHolder.put("parks", parkDao.getAllParks());
		return "surveyPage";
	}
	
	@RequestMapping(path = {"/surveyPage"}, method = RequestMethod.POST)
	public String submitSurvey(@RequestParam String parkCode, @RequestParam String emailAddress, @RequestParam String state, @RequestParam String activityLevel) {
		surveyDao.saveNewSurvey(parkCode, emailAddress, state, activityLevel);
		return "redirect:/surveyResult";
	}
	
	@RequestMapping(path = "/surveyResult", method= RequestMethod.GET)
	public String showSurveyResults(ModelMap modelHolder) {
		modelHolder.put("favoriteParks" , surveyDao.getFavoriteParks());
		
		return "surveyResult";
		
	}
	
	
}
