package com.example.controller;

import java.util.List;

import com.example.bean.CarDetailsResponse;
import com.example.interfaces.OwnerInterface;
import com.example.service.OwnerServices;
import com.example.staticMethods.StaticConstants;

public class OwnerController implements OwnerInterface{
	
	OwnerServices ownerservices = new OwnerServices();
	
	@Override
	public CarDetailsResponse carForRent(CarDetailsResponse carDetails) {
		ownerservices.addCarForRent(carDetails);
		
		List<CarDetailsResponse> results =  StaticConstants.carList.get(carDetails.getCarType());
		
		return results.get(results.size()-1);
	}

	@Override
	public boolean RemoveCarForRent(String carType ,int carId) {
		ownerservices.removeCarForRent(carType , carId);
		
		return ownerservices.checkForCar(carType , carId);
		
	}

	@Override
	public String updateRentChartForCar(String carType, double price) {
		return ownerservices.updateRentChartForCar(carType , price);		
	}

}
