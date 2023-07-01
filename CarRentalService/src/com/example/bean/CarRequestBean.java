package com.example.bean;

public class CarRequestBean {
	
	private int requiredCapacity;
	private String requiredType;
	
	
	public int getRequiredCapacity() {
		return requiredCapacity;
	}
	public void setRequiredCapacity(int requiredCapacity) {
		this.requiredCapacity = requiredCapacity;
	}
	public String getRequiredType() {
		return requiredType;
	}
	public void setRequiredType(String requiredType) {
		this.requiredType = requiredType;
	}
	@Override
	public String toString() {
		return "CarRequestBean [requiredCapacity=" + requiredCapacity + ", requiredType=" + requiredType + "]";
	}
	
	
}
