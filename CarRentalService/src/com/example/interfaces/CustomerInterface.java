package com.example.interfaces;

import java.util.List;
import com.example.bean.CarDetailsResponse;

public interface CustomerInterface {
	
	public CarDetailsResponse placeBookingService(String carType , int id);
	public List<CarDetailsResponse> getBookingHistory(int id);
}
