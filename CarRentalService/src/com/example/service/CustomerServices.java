package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.bean.CarDetailsResponse;
import com.example.staticMethods.StaticConstants;

public class CustomerServices {

	public CarDetailsResponse placeBooking(String carType, int id) {
		if(StaticConstants.availableCarList.containsKey(carType)
				&& ! StaticConstants.availableCarList.get(carType).isEmpty())
		{
			List<CarDetailsResponse> set = StaticConstants.availableCarList.get(carType);
			CarDetailsResponse response = set.remove(0);
			
			StaticConstants.availableCarList.put(carType, set);
			
			updateBookingHistory(id , response);
			
			return response;
		}
		
		return null;
	}

	private void updateBookingHistory(int id, CarDetailsResponse response) {
		if(StaticConstants.bookingDetails.containsKey(id))
		{
			StaticConstants.bookingDetails.get(id).add(response);
		}
		else
			StaticConstants.bookingDetails.put(id, new ArrayList<>(Arrays.asList(response)));
	}

	public List<CarDetailsResponse> getBookingHistory(int id) {
		if(StaticConstants.bookingDetails.containsKey(id))
			return StaticConstants.bookingDetails.get(id);
		else return null;
	}

}
