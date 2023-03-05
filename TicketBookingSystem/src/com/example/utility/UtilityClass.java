package com.example.utility;

import com.example.staticComponent.StaticTicketDetails;

public class UtilityClass {

	public static boolean validateTicketCount(int ticket)
	{
		return StaticTicketDetails.AVAILABLETICKETCOUNT>=ticket;

	}

	public static boolean bookTicket(int ticket) {
		if(StaticTicketDetails.AVAILABLETICKETCOUNT>=ticket)
		{
			StaticTicketDetails.AVAILABLETICKETCOUNT = StaticTicketDetails.AVAILABLETICKETCOUNT-ticket;
			return true;
		}
		return false;
	}

}
