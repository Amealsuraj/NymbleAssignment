package com.nymble.assignment;

import java.util.ArrayList;
import java.util.List;

public class Destination {
	private String name;
	private List<Activity> activities;
	

	public Destination() {
		super();
		
	}

	public Destination(String name) {
		this.name = name;
		this.activities = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void addActivity(Activity activity) {
		activities.add(activity);
	}


}