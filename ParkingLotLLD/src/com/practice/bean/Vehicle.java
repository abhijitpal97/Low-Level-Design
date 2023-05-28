package com.practice.bean;

import java.sql.Date;

public class Vehicle {
	
	private String entryId;
	private String vehicleType;
	private String vehicleNumber;
	private Long entryTime;
	private String parkingId;
	private Long exitTime;
	private String status;
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Long getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(long l) {
		this.entryTime = l;
	}
	public String getParkingId() {
		return parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	public Long getExitTime() {
		return exitTime;
	}
	public void setExitTime(Long exitTime) {
		this.exitTime = exitTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Vehicle [entryId=" + entryId + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
				+ ", entryTime=" + entryTime + ", parkingId=" + parkingId + ", exitTime=" + exitTime + ", status="
				+ status + "]";
	}
	
	

}
