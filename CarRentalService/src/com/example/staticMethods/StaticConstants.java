package com.example.staticMethods;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.bean.CarDetailsResponse;

public class StaticConstants {
	public static Map<String, List<CarDetailsResponse>> carList = new HashMap<>();
	public static Map<String , Double> carRentChart = new HashMap<>();
	public static Map<String, List<CarDetailsResponse>> availableCarList = new HashMap<>();
	public static Map<Integer  , List<CarDetailsResponse>> bookingDetails = new HashMap<>();
}
