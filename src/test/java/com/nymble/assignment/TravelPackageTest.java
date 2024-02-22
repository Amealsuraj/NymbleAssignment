package com.nymble.assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class TravelPackageTest {
	private TravelPackage travelPackage;
	private Destination goa;
	private Destination manali;
	private Activity waterSports;
	private Activity paragliding;
	private Passenger suraj;
	private Passenger mohan;
	private Passenger avesh;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUp() {

		goa = new Destination("Goa");
		manali = new Destination("Manali");

		waterSports = new Activity("Water Sports", "Thrilling Jet Ski Ride,Parasailing", 50.0, 20, goa);
		paragliding = new Activity("Paragliding", "Paragliding at Solang Valley", 40.0, 30, manali);

		travelPackage = new TravelPackage("India Tour", 50);
		travelPackage.addDestination(goa);
		travelPackage.addDestination(manali);

		suraj = new Passenger("Suraj", 1, 100.0, PassengerType.STANDARD);
		mohan = new Passenger("Mohan", 2, 200.0, PassengerType.GOLD);
		avesh = new Passenger("Avesh", 3, 0.0, PassengerType.PREMIUM);

		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAddPassenger() {

		travelPackage.addPassenger(suraj);
		travelPackage.addPassenger(mohan);
		travelPackage.addPassenger(avesh);
		assertEquals(3, travelPackage.getPassengers().size());
	}

	@Test
	public void testAddActivity() {

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);
		assertEquals(1, goa.getActivities().size());
		assertEquals(1, manali.getActivities().size());
	}

	@Test

	public void testSignPassengerForActivity() {

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);

		suraj.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		mohan.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding

		assertEquals(1, suraj.getActivities().size());
		assertEquals(1, mohan.getActivities().size());
	}

	@Test
	public void testCalculatePriceForGoldPassenger() {
		double expectedPrice = paragliding.getCost() - 0.1 * paragliding.getCost();
		double actualPrice = travelPackage.calculatePrice(mohan, paragliding);
		assertEquals(expectedPrice, actualPrice, 0.01);
	}

	@Test
	public void testCalculatePriceForStandardPassenger() {
		double expectedPrice = waterSports.getCost();
		double actualPrice = travelPackage.calculatePrice(suraj, waterSports);
		assertEquals(expectedPrice, actualPrice, 0.01);
	}

	@Test
	public void testCalculatePriceForPremiumPassenger() {
		double expectedPrice = 0.0;
		double actualPrice = travelPackage.calculatePrice(avesh, waterSports);
		assertEquals(expectedPrice, actualPrice, 0.01);
	}

	@Test
	public void testPrintItinerary() {

		travelPackage.addPassenger(suraj);
		travelPackage.addPassenger(mohan);
		travelPackage.addPassenger(avesh);

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);

		suraj.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		mohan.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding

		String expectedOutput = "Travel Package: India Tour\n" + "Destination: Goa\n"
				+ "Activity: Water Sports, Cost: 50.0, Capacity: 19, Description: Thrilling Jet Ski Ride,Parasailing\n"
				+ "Destination: Manali\n"
				+ "Activity: Paragliding, Cost: 40.0, Capacity: 29, Description: Paragliding at Solang Valley\n";

		// Redirect System.out to outContent
		System.setOut(new PrintStream(outContent));

		travelPackage.printItinerary();

		// Get the printed output and sort lines
		String printedOutput = outContent.toString().trim();
		String[] expectedLines = expectedOutput.split("\\r?\\n");
		String[] printedLines = printedOutput.split("\\r?\\n");
		Arrays.sort(expectedLines);
		Arrays.sort(printedLines);

		String expectedSorted = String.join("\n", expectedLines);
		String printedSorted = String.join("\n", printedLines);

		assertEquals(expectedSorted, printedSorted);

	}

	@Test
	public void testPrintPassengerList() {

		travelPackage.addPassenger(suraj);
		travelPackage.addPassenger(mohan);
		travelPackage.addPassenger(avesh);

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);

		suraj.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		mohan.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding

		String expectedOutput = "Travel Package: India Tour\n" + "Passenger Capacity: 50\n"
				+ "Number of Passengers Enrolled: 3\n" + "Passenger: Suraj, Number: 1\n"
				+ "Passenger: Mohan, Number: 2\n" + "Passenger: Avesh, Number: 3";

		System.setOut(new PrintStream(outContent));

		travelPackage.printPassengerList();

		String printedOutput = outContent.toString().trim();
		String[] expectedLines = expectedOutput.split("\\r?\\n");
		String[] printedLines = printedOutput.split("\\r?\\n");
		Arrays.sort(expectedLines);
		Arrays.sort(printedLines);

		String expectedSorted = String.join("\n", expectedLines);
		String printedSorted = String.join("\n", printedLines);

		assertEquals(expectedSorted, printedSorted);
	}

	@Test
	public void testPrintPassengerDetails() {

		travelPackage.addPassenger(suraj);
		travelPackage.addPassenger(mohan);
		travelPackage.addPassenger(avesh);

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);

		suraj.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		mohan.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding

		travelPackage.printPassengerDetails(suraj);

		String expectedOutput = "Passenger Name: Suraj\n" + "Passenger Number: 1\n" + "Balance: 50.0\n"
				+ "Activities:\n" + "Activity: Water Sports, Destination: Goa, Price Paid: 50.0\n";

		// Get the printed output and sort lines
		String printedOutput = outContent.toString().trim();
		String[] expectedLines = expectedOutput.split("\\r?\\n");
		String[] printedLines = printedOutput.split("\\r?\\n");
		Arrays.sort(expectedLines);
		Arrays.sort(printedLines);

		// Join lines back to string for comparison
		String expectedSorted = String.join("\n", expectedLines);
		String printedSorted = String.join("\n", printedLines);

		assertEquals(expectedSorted, printedSorted);
	}

	@Test
	public void testPrintAvailableActivities() {

		travelPackage.addPassenger(suraj);
		travelPackage.addPassenger(mohan);
		travelPackage.addPassenger(avesh);

		goa.addActivity(waterSports);
		manali.addActivity(paragliding);

		suraj.signUpForActivity(goa.getActivities().get(0)); // Suraj signs up for Water Sports Activity
		mohan.signUpForActivity(manali.getActivities().get(0)); // Mohan signs up for Paragliding

		// Redirect System.out to outContent
		System.setOut(new PrintStream(outContent));

		travelPackage.printAvailableActivities();

		String expectedOutput = "Available Activities:\n"
				+ "Activity: Water Sports, Destination: Goa, Remaining Capacity: 19\n"
				+ "Activity: Paragliding, Destination: Manali, Remaining Capacity: 29";

		String printedOutput = outContent.toString().trim();
		String[] expectedLines = expectedOutput.split("\\r?\\n");
		String[] printedLines = printedOutput.split("\\r?\\n");
		Arrays.sort(expectedLines);
		Arrays.sort(printedLines);

		String expectedSorted = String.join("\n", expectedLines);
		String printedSorted = String.join("\n", printedLines);

		assertEquals(expectedSorted, printedSorted);
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
}
