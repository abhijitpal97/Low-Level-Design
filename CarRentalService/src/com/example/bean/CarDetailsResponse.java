package com.example.bean;

public class CarDetailsResponse {
	
	private int carId;
	private String carNumber;
	private String carType;
	private int carCapacity;
	
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCarCapacity() {
		return carCapacity;
	}
	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}
	@Override
	public String toString() {
		return "CarDetailsResponse [carId=" + carId + ", carNumber=" + carNumber + ", carType=" + carType
				+ ", carCapacity=" + carCapacity + "]";
	}
	
	
}
