package com.example.driver;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.implementors.ChainFilters;
import com.example.implementors.SingleTonClass;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SingleTonClass singleTon = new SingleTonClass().getInstance();
		singleTon.setFilterContent(new ArrayList<>(Arrays.asList("X","Y")), "Abusive");
		singleTon.setFilterContent(new ArrayList<>(Arrays.asList("M","N")), "Personal");

		ChainFilters filterChaining = new ChainFilters();

		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive"}, "Abhijit X"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Personal"}, "Abhijit M"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive" , "Personal"}, "Abhijit X"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive" , "Personal"}, "Abhijit Valid"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive", "Duplicative"}, "Abhijit P"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive", "Duplicative"}, "Abhijit P"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Personal"}, "Abhijit X"));
		System.out.println("Is Valid -> "+ filterChaining.isValid(new String[] {"Abusive"}, "Abhijit M"));

	}

}
