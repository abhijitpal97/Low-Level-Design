package com.practice.interfaces;

import java.sql.Date;

import com.practice.bean.Parking;
import com.practice.bean.Vehicle;

public interface VehicleEntryInterface {
	
	 Vehicle entryVehicle(String vehicleType , String vehicleNumber);

}
