package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.bean.CarDetailsResponse;
import com.example.staticMethods.StaticConstants;

public class OwnerServices {
	
	public void addCarForRent(CarDetailsResponse carDetails) {
		if(StaticConstants.carList.containsKey(carDetails.getCarType()))
			{
			StaticConstants.carList.get(carDetails.getCarType()).add(carDetails);
			StaticConstants.availableCarList.get(carDetails.getCarType()).add(carDetails);
			}
		else
		{
			List<CarDetailsResponse> list = new ArrayList<>();
			List<CarDetailsResponse> set = new ArrayList<>();
			list.add(carDetails);
			set.add(carDetails);
			StaticConstants.carList.put(carDetails.getCarType() , list);
			StaticConstants.availableCarList.put(carDetails.getCarType() , set);
			
		}
	}

	public void removeCarForRent(String carType, int carId) {
		if(StaticConstants.carList.containsKey(carType))
		{
			List<CarDetailsResponse> results =  StaticConstants.carList.get(carType);
			List<CarDetailsResponse> availableResults =  StaticConstants.availableCarList.get(carType);
			int index = 0;
			int availableIndex = 0;
			for(CarDetailsResponse details : results)
			{
				if(details.getCarId() == carId) break;
				index++;
			}
			for(CarDetailsResponse details : availableResults)
			{
				if(details.getCarId() == carId) break;
				availableIndex++;
			}
			
			results.remove(index);
			availableResults.remove(availableIndex);
			
			StaticConstants.carList.put(carType, results);
			StaticConstants.availableCarList.put(carType, availableResults);
		}
	}

	public boolean checkForCar(String carType, int carId) {
		if(StaticConstants.carList.containsKey(carType))
		{
			List<CarDetailsResponse> results =  StaticConstants.carList.get(carType);
			for(CarDetailsResponse details : results)
			{
				if(details.getCarId() == carId) return true;
			}
		}
		
		return false;
	}

	public String updateRentChartForCar(String carType, double price) {
		StaticConstants.carRentChart.put(carType, price);
		
		return "Car Rent For Car Type - "+carType+" has been updated to - "
		+StaticConstants.carRentChart.get(carType);
	}

}
