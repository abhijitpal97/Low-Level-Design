package com.example.controller;

import java.util.List;
import com.example.bean.CarDetailsResponse;
import com.example.interfaces.CustomerInterface;
import com.example.service.CustomerServices;

public class CustomerController implements CustomerInterface{

	CustomerServices customerServices = new CustomerServices();
	@Override
	public CarDetailsResponse placeBookingService(String carType, int id) {
		return customerServices.placeBooking(carType , id);
		
	}

	@Override
	public List<CarDetailsResponse> getBookingHistory(int id) {
		return customerServices.getBookingHistory(id);
	}

}
