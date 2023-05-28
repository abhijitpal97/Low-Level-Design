package com.practice.implementation;

import com.practice.bean.Vehicle;
import com.practice.helper.ExitVehicleHelper;
import com.practice.interfaces.VehicleExitInterface;

public class VehicleExitmplementation implements VehicleExitInterface{

	ExitVehicleHelper helper = new ExitVehicleHelper();
	@Override
	public boolean exitVehicle(String entryId) {

		synchronized (this) {
			Vehicle v = helper.getVehicle(entryId);
			if(v == null) return false;
			String parkingId = v.getParkingId();
			helper.updateParkingStatus(parkingId);

			boolean status = helper.paymentService(v);

			if(status)
			{
				v.setExitTime(System.currentTimeMillis());
				v.setStatus("R");
				v.setParkingId(null);
				return true;
			}

			return false;
		}
	}

}
