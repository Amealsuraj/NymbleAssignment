package com.nymble.assignment;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
	private String name;
	private int passengerCapacity;
	private List<Passenger> passengers;
	private List<Destination> destinations;
	

	public TravelPackage() {
		super();
		
	}

	public TravelPackage(String name, int passengerCapacity) {
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		this.passengers = new ArrayList<>();
		this.destinations = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void addDestination(Destination destination) {
		destinations.add(destination);
	}

	public void addPassenger(Passenger passenger) {
		if (passengers.size() < passengerCapacity) {
			passengers.add(passenger);
		} else {
			System.out.println("Passenger capacity reached for this travel package.");
		}
	}

	public void printItinerary() {
		System.out.println("Travel Package: " + this.getName());
		for (Destination destination : destinations) {
			System.out.println("Destination: " + destination.getName());
			for (Activity activity : destination.getActivities()) {
				System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: "
						+ activity.getCapacity() + ", Description: " + activity.getDescription());
			}
		}
	}

	public void printPassengerList() {
		System.out.println("Travel Package: " + this.getName());
		System.out.println("Passenger Capacity: " + this.getPassengerCapacity());
		System.out.println("Number of Passengers Enrolled: " + passengers.size());
		for (Passenger passenger : passengers) {
			System.out.println("Passenger: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
		}
	}

	public void printPassengerDetails(Passenger passenger) {
		System.out.println("Passenger Name: " + passenger.getName());
		System.out.println("Passenger Number: " + passenger.getPassengerNumber());
		if (!(passenger.getType().equals(PassengerType.PREMIUM)))
			System.out.println("Balance: " + passenger.getBalance());
		System.out.println("Activities:");
		for (Activity activity : passenger.getActivities()) {
			System.out.println("Activity: " + activity.getName() + ", Destination: "
					+ activity.getDestination().getName() + ", Price Paid: " + calculatePrice(passenger, activity));
		}
	}

	public void printAvailableActivities() {
		System.out.println("Available Activities:");
		for (Destination destination : destinations) {
			for (Activity activity : destination.getActivities()) {
				if (activity.getCapacity() > 0) {

					System.out.println("Activity: " + activity.getName() + ", Destination: "
							+ activity.getDestination().getName() + ", Remaining Capacity: " + activity.getCapacity());
				}
			}
		}
	}

	public double calculatePrice(Passenger passenger, Activity activity) {
		double price = activity.getCost();
		if (passenger.getType().equals(PassengerType.PREMIUM)) {
			price = 0.0;
		} else if (passenger.getType().equals(PassengerType.GOLD)) {
			price -= 0.1 * activity.getCost();
		}

		return price;
	}
}
