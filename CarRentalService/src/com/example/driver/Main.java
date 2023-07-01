package com.example.driver;

import java.util.List;
import java.util.Map;

import com.example.bean.CarDetailsResponse;
import com.example.controller.CustomerController;
import com.example.controller.DriverController;
import com.example.controller.OwnerController;
import com.example.staticMethods.StaticConstants;

public class Main {
	static OwnerController owners = new OwnerController();
	static CustomerController customer = new CustomerController();
	static DriverController drivers = new DriverController();
	static int index = 1;
	public static void main(String[] args) {
		addCars();
		System.out.println("Initial - " +StaticConstants.carList);
		System.out.println("Initial - " +StaticConstants.availableCarList);
		placeBookings();
		System.out.println("PostBooking - " +StaticConstants.availableCarList);
		endRide();
		System.out.println("PostDriverBookingEnd - " +StaticConstants.availableCarList);
	}
	
	private static void endRide() {
		for(Map.Entry<Integer  , List<CarDetailsResponse>> m1 : StaticConstants.bookingDetails.entrySet())
		{
			for(CarDetailsResponse cars : m1.getValue())
			{
				drivers.endRide(cars.getCarType(), cars.getCarId());
				System.out.println("Trip Completed for "+m1.getKey()+" with car id "+ cars.getCarId());
			}
		}
	}

	static void addCars()
	{
		for(int i = 0 ; i<5;i++)
		{
			CarDetailsResponse carDetails = new CarDetailsResponse();
			carDetails.setCarId(index);
			carDetails.setCarType("Sedan");
			carDetails.setCarNumber("Test00"+index);
			carDetails.setCarCapacity(5);
			
			owners.carForRent(carDetails);
			index++;
		}
		
		for(int i = 0 ; i<5;i++)
		{
			CarDetailsResponse carDetails = new CarDetailsResponse();
			carDetails.setCarId(index);
			carDetails.setCarType("HatchBack");
			carDetails.setCarNumber("Test00"+index);
			carDetails.setCarCapacity(5);
			
			owners.carForRent(carDetails);
			index++;
		}
		
		for(int i = 0 ; i<5;i++)
		{
			CarDetailsResponse carDetails = new CarDetailsResponse();
			carDetails.setCarId(index);
			carDetails.setCarType("SUV");
			carDetails.setCarNumber("Test00"+index);
			carDetails.setCarCapacity(7);
			
			owners.carForRent(carDetails);
			index++;
		}
	}

	static void placeBookings()
	{
		CarDetailsResponse response = customer.placeBookingService("SUV", 1);
		System.out.println("Emp - "+1+" booked "+response);
		response = customer.placeBookingService("SUV", 2);
		System.out.println("Emp - "+2+" booked "+response);
		response = customer.placeBookingService("HatchBack", 1);
		System.out.println("Emp - "+1+" booked "+response);
		response = customer.placeBookingService("HatchBack", 1);
		System.out.println("Emp - "+1+" booked "+response);
		response = customer.placeBookingService("Sedan", 2);
		System.out.println("Emp - "+2+" booked "+response);
		
		List<CarDetailsResponse> history = customer.getBookingHistory(1);
		System.out.println("Emp - "+1+" booking history "+history);
		history = customer.getBookingHistory(2);
		System.out.println("Emp - "+2+" booking history "+history);
	}
}
