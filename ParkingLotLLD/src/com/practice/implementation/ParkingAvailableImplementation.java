package com.practice.implementation;

import java.util.ArrayList;
import java.util.List;

import com.practice.bean.Parking;
import com.practice.driver.Main;

public class ParkingAvailableImplementation {
	
	Main main = new Main();
	List<Parking> parkingList = Main.parkingList;
	
	public List<Parking> getAllAvailableParking()
	{
		List<Parking> availableParking = new ArrayList<>();
		
		for(Parking park : parkingList)
		{
			if(park.getStatus().equals("A")) availableParking.add(park);
		}
		
		return availableParking;
	}

}
