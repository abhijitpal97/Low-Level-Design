package com.practice.bean;

public class Parking {
	
	private String parkingId;
	private String parkingFloor;
	private String status;
	public String getParkingId() {
		return parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	public String getParkingFloor() {
		return parkingFloor;
	}
	public void setParkingFloor(String parkingFloor) {
		this.parkingFloor = parkingFloor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Parking [parkingId=" + parkingId + ", parkingFloor=" + parkingFloor + ", status=" + status + "]";
	}
	
	
}
