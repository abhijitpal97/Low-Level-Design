package com.practice.helper;

import java.util.List;

import com.practice.bean.Parking;
import com.practice.driver.Main;

public class EntryVehicleHelper {

	Main main = new Main();
	List<Parking> list = Main.parkingList;
	public Parking getAvailableParking() {
		for(Parking p1:list)
		{
			if(p1.getStatus().equals("A")) return p1;
		}

		return null;
	}
	public boolean updateParkingStatus(String parkingId) {

		for(Parking p1:list)
		{
			if(p1.getParkingId().equals(parkingId)) {
				p1.setStatus("NA");
				return true;
			}
		}

		return false;
	}

}
