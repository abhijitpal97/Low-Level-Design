package com.example.interfaces;

import com.example.bean.CarDetailsResponse;

public interface OwnerInterface {
	
	public CarDetailsResponse carForRent(CarDetailsResponse carDetails);
	public boolean RemoveCarForRent(String carType ,int carId);
	public String updateRentChartForCar(String carType , double price);

}
