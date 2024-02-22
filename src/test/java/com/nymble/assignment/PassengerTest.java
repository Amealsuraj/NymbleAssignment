package com.nymble.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PassengerTest {

	private Passenger standardPassenger;
	private Passenger goldPassenger;
	private Passenger premiumPassenger;

	private Destination goa;
	private Destination manali;

	@Before
	public void setUp() {

		goa = new Destination("Goa");
		manali = new Destination("Manali");

		goa.addActivity(new Activity("Water Sports", "Thrilling Jet Ski Ride,Parasailing", 50.0, 20, goa));
		manali.addActivity(new Activity("Paragliding", "Paragliding at Solang Valley", 40.0, 2, manali));

		standardPassenger = new Passenger("Suraj", 1, 100.0, PassengerType.STANDARD);
		goldPassenger = new Passenger("Mohan", 2, 200.0, PassengerType.GOLD);
		premiumPassenger = new Passenger("Avesh", 3, 0.0, PassengerType.PREMIUM);

	}

	@Test
	public void testGetName() {
		assertEquals("Suraj", standardPassenger.getName());
		assertEquals("Mohan", goldPassenger.getName());
		assertEquals("Avesh", premiumPassenger.getName());
	}

	@Test
	public void testGetPassengerNumber() {
		assertEquals(1, standardPassenger.getPassengerNumber());
		assertEquals(2, goldPassenger.getPassengerNumber());
		assertEquals(3, premiumPassenger.getPassengerNumber());
	}

	@Test
	public void testGetBalance() {
		assertEquals(100.0, standardPassenger.getBalance(), 0.001);
		assertEquals(200.0, goldPassenger.getBalance(), 0.001);
		assertEquals(0.0, premiumPassenger.getBalance(), 0.001);
	}

	@Test
	public void testGetActivities() {
		assertTrue(standardPassenger.getActivities().isEmpty());
		assertTrue(goldPassenger.getActivities().isEmpty());
		assertTrue(premiumPassenger.getActivities().isEmpty());
	}

	@Test
	public void testGetType() {
		assertEquals(PassengerType.STANDARD, standardPassenger.getType());
		assertEquals(PassengerType.GOLD, goldPassenger.getType());
		assertEquals(PassengerType.PREMIUM, premiumPassenger.getType());
	}

	@Test
	public void testPassengerSignUpForActivity() {

		standardPassenger.signUpForActivity(goa.getActivities().get(0));
		List<Activity> standardActivities = standardPassenger.getActivities();
		assertEquals(1, standardActivities.size());
		assertEquals("Water Sports", standardActivities.get(0).getName());

		goldPassenger.signUpForActivity(goa.getActivities().get(0));
		List<Activity> goldActivities = goldPassenger.getActivities();
		assertEquals(1, goldActivities.size());
		assertEquals("Water Sports", goldActivities.get(0).getName());

		premiumPassenger.signUpForActivity(manali.getActivities().get(0));
		List<Activity> premiumActivities = premiumPassenger.getActivities();
		assertEquals(1, premiumActivities.size());
		assertEquals("Paragliding", premiumActivities.get(0).getName());
	}

	@Test
	public void testPassengerBalanceAfterSignUp() {

		standardPassenger.signUpForActivity(goa.getActivities().get(0));
		assertEquals(50.0, standardPassenger.getBalance(), 0.001);

		goldPassenger.signUpForActivity(goa.getActivities().get(0));
		assertEquals(155.0, goldPassenger.getBalance(), 0.001);

		premiumPassenger.signUpForActivity(manali.getActivities().get(0));
		assertEquals(0.0, premiumPassenger.getBalance(), 0.001);
	}
}
