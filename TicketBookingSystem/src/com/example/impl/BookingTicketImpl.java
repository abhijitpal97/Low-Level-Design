package com.example.impl;

import com.example.interfaces.BookingInterface;
import com.example.utility.UtilityClass;

public class BookingTicketImpl implements BookingInterface{

	@Override
	public void bookTicket(int id, int ticket) {
		System.out.println("User Id started for Booking Proess - "+id);
		boolean isTicketAvailable = UtilityClass.validateTicketCount(ticket);
		boolean status = false;
		if(isTicketAvailable)
		{
			synchronized (this) {
				status = UtilityClass.bookTicket(ticket);				
			}
		}
		if(status) System.out.println(ticket+" ticket Booked for User - "+id);
		else System.out.println("Sorry! No seat available for User - "+id);
	}

}
