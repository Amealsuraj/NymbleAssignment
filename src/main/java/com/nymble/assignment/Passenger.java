package com.nymble.assignment;

import java.util.ArrayList;
import java.util.List;


enum PassengerType {
    STANDARD,
    GOLD,
    PREMIUM
}
public class Passenger {
	private String name;
	private int passengerNumber;
	private  double balance;
	private  List<Activity> activities;
	private  PassengerType type;
	

	public Passenger() {
		super();
		
	}

	public Passenger(String name, int passengerNumber, double balance,PassengerType type) {
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
		this.activities = new ArrayList<>();
		this.type=type;
	}

	public String getName() {
		return name;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public double getBalance() {
		return balance;
	}


	public List<Activity> getActivities() {
		return activities;
	}
	

	public PassengerType getType() {
		return type;
	}

	public void signUpForActivity(Activity activity) {
		if (this.getType().equals(PassengerType.PREMIUM)) {
			if (activity.getCapacity() >= 1) {

				activity.setCapacity(activity.getCapacity() - 1);
				activities.add(activity);

			}
		}

		else if (this.getType().equals(PassengerType.GOLD)) {
			if (activity.getCapacity() >= 1 && this.balance >= 0.9 * activity.getCost()) {

				activity.setCapacity(activity.getCapacity() - 1);
				activities.add(activity);
				this.balance = this.balance - 0.9 * activity.getCost();

			}
		}

		else {
			if (activity.getCapacity() >= 1 && this.balance >= activity.getCost()) {

				activity.setCapacity(activity.getCapacity() - 1);
				activities.add(activity);
				this.balance = this.balance - activity.getCost();

			}
		}

	}
}