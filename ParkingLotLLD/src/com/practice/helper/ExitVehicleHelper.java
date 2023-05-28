package com.practice.helper;

import java.util.List;

import com.practice.bean.Parking;
import com.practice.bean.Vehicle;
import com.practice.driver.Main;

public class ExitVehicleHelper {

	Main main = new Main();
	List<Parking> parkingList = Main.parkingList;
	List<Vehicle> list = Main.vehicleList;
	public Vehicle getVehicle(String entryId) {
		for(Vehicle v : list)
		{
			if(v.getEntryId().equals(entryId)) return v;
		}

		return null;
	}
	public void updateParkingStatus(String parkingId) {


		for(Parking p1:parkingList)
		{
			if(p1.getParkingId().equals(parkingId)) {
				p1.setStatus("A");
				return;
			}
		}	
	}
	public boolean paymentService(Vehicle v) {
		return true;
	}

}
