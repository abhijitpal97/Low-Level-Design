package com.practice.implementation;

import java.sql.Date;
import java.util.UUID;

import com.practice.bean.Parking;
import com.practice.bean.Vehicle;
import com.practice.helper.EntryVehicleHelper;
import com.practice.interfaces.VehicleEntryInterface;

public class VehicleEntryImplementation implements VehicleEntryInterface{
	EntryVehicleHelper helper = new EntryVehicleHelper();

	@Override
	public Vehicle entryVehicle(String vehicleType, String vehicleNumber) {

		synchronized (this) {
			Vehicle v = new Vehicle();
			Parking p = helper.getAvailableParking();
			if(p == null) return null;
			v.setEntryId(UUID.randomUUID().toString());
			v.setVehicleType(vehicleType);
			v.setVehicleNumber(vehicleNumber);
			v.setEntryTime(System.currentTimeMillis());
			v.setParkingId(p.getParkingId());
			v.setStatus("P");

			boolean status = helper.updateParkingStatus(p.getParkingId());
			if(status)return v;
			else return null;

		}
	}

}
