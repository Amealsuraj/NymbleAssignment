package com.nymble.assignment;

public class Main {
	public static void main(String[] args) {

		Destination goa = new Destination("Goa");
		Destination manali = new Destination("Manali");

		// Adding activities to destinations
		goa.addActivity(new Activity("Water Sports", "Thrilling Jet Ski Ride,Parasailing", 50.0, 20, goa));
		manali.addActivity(new Activity("Paragliding", "Paragliding at Solang Valley", 40.0, 2, manali));

		// travel package
		TravelPackage travelPackage = new TravelPackage("India Tour", 50);
		travelPackage.addDestination(goa);
		travelPackage.addDestination(manali);

		// Adding passengers
		Passenger standardPassenger = new Passenger("Suraj", 1, 100.0,PassengerType.STANDARD);
		Passenger goldPassenger = new Passenger("Mohan", 2, 200.0,PassengerType.GOLD);
		Passenger premiumPassenger = new Passenger("Avesh",3,0.0, PassengerType.PREMIUM);
		
		
		travelPackage.addPassenger(standardPassenger);
		travelPackage.addPassenger(goldPassenger);
		travelPackage.addPassenger(premiumPassenger);

		standardPassenger.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		goldPassenger.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding
		premiumPassenger.signUpForActivity(manali.getActivities().get(0));

		System.out.println("Printing itinerary");
		travelPackage.printItinerary();

		System.out.println("\nPassenger list");
		travelPackage.printPassengerList();
		System.out.println("\nStandard passenger details");
		travelPackage.printPassengerDetails(standardPassenger);
		System.out.println("\nGold passenger details");
		travelPackage.printPassengerDetails(goldPassenger);
		System.out.println("\nPremium passenger details");
		travelPackage.printPassengerDetails(premiumPassenger);
		System.out.println();
		System.out.println("\nAvailable activities");
		travelPackage.printAvailableActivities();

	}
}
