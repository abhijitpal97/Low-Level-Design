package com.example.controller;

import com.example.interfaces.DriverInterfaces;
import com.example.service.DriverServices;

public class DriverController implements DriverInterfaces{
	
	DriverServices driverServices = new DriverServices();
	
	@Override
	public boolean startRide(int otp) {
		return true;
	}

	@Override
	public boolean endRide(String carType , int carId) {
		return driverServices.endRide(carType , carId);
	}

}
