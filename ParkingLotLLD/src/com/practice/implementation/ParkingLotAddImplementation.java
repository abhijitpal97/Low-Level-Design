package com.practice.implementation;

import java.util.UUID;

import com.practice.bean.Parking;
import com.practice.interfaces.ParkingLotAddInterface;

public class ParkingLotAddImplementation implements ParkingLotAddInterface{

	@Override
	public Parking addParking(String floor) {
		Parking p1 = new Parking();
		p1.setParkingId(UUID.randomUUID().toString());
		p1.setParkingFloor(floor);
		p1.setStatus("A");

		return p1;
	}
}
