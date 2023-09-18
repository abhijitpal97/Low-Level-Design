package com.example.implementors;

public enum FilterType {
	ABUSIVE("Abusive"),
	PERSONAL("Personal"),
	DUPLICATIVE("Duplicative");


	private String value;
	private FilterType(String value) { this.value = value; }
	public String getValue() { return value ; }
}
