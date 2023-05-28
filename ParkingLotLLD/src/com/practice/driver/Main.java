package com.practice.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.practice.bean.Parking;
import com.practice.bean.Vehicle;
import com.practice.implementation.ParkingAvailableImplementation;
import com.practice.implementation.ParkingLotAddImplementation;
import com.practice.implementation.VehicleEntryImplementation;
import com.practice.implementation.VehicleExitmplementation;

public class Main {
	public static List<Parking> parkingList = new ArrayList<>();
	public static List<Vehicle> vehicleList = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {

		ParkingLotAddImplementation addImpl = new ParkingLotAddImplementation();
		VehicleEntryImplementation entry = new VehicleEntryImplementation();
		VehicleExitmplementation exit = new VehicleExitmplementation();
		ParkingAvailableImplementation available = new ParkingAvailableImplementation();

		for(int i=0;i<10;i++) parkingList.add(addImpl.addParking("1"));
		for(int i=0;i<10;i++) parkingList.add(addImpl.addParking("2"));
		for(int i=0;i<10;i++) parkingList.add(addImpl.addParking("3"));

		ExecutorService executor  = Executors.newFixedThreadPool(5);

		for(int i=0;i<12;i++)
		{
			String vehicleNum = "1234CAR"+i;

			executor.submit(
					new Runnable() {

						@Override
						public void run() {
							Vehicle v = entry.entryVehicle("CAR", vehicleNum);
							if(v == null) System.out.println("Some Issue in EntryPoint. Try in other entry point or wait for sometime.");
							else
							{
								vehicleList.add(v);
								System.out.println("Vehicle  - "+ v.getEntryId()+ "has parking Id - "+v.getParkingId());
							}


						}
					}
					);

		}
		executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		for(int i=0;i<5;i++)
		{
			String vehicle=vehicleList.get(i).getEntryId();
			executor.submit(new Runnable() {

				@Override
				public void run() {
					boolean status = exit.exitVehicle(vehicle);
					if(status) System.out.println("Successfully Vehicle exited");
					else System.out.println("Some issue while vehicle exit");
				}
			});
		}
		executor.awaitTermination(1000, TimeUnit.MILLISECONDS);

		executor.execute(
				() -> System.out.println("Available Parking "+available.getAllAvailableParking().size()));

		executor.shutdown();

	}



}
