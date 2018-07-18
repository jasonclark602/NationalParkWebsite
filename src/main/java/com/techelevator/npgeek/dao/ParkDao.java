package com.techelevator.npgeek.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;


public interface ParkDao {
	
	public List<Park> getAllParks();

}
