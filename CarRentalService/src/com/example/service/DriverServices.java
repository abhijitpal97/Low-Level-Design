package com.example.service;

import java.util.List;

import com.example.bean.CarDetailsResponse;
import com.example.staticMethods.StaticConstants;

public class DriverServices {

	public boolean endRide(String carType, int carId) {
		if(StaticConstants.carList.containsKey(carType))
		{
			List<CarDetailsResponse> results =  StaticConstants.carList.get(carType);
			for(CarDetailsResponse details : results)
			{
				if(details.getCarId() == carId) {
					StaticConstants.availableCarList.get(carType).add(details);
					return true;
				}
			}
		}
		
		return false;
	}

}
