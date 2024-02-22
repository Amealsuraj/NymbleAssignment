package com.nymble.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DestinationTest {

    private Destination goa;
    private Destination manali;
    private Activity waterSportsActivity;
    private Activity paraglidingActivity;

    @Before
    public void setUp() {
        goa = new Destination("Goa");
        manali = new Destination("Manali");

        waterSportsActivity = new Activity("Water Sports", "Thrilling Jet Ski Ride, Parasailing", 50.0, 20, goa);
        paraglidingActivity = new Activity("Paragliding", "Paragliding at Solang Valley", 40.0, 2, manali);
    }

    @Test
    public void testGetName() {
        assertEquals("Goa", goa.getName());
        assertEquals("Manali", manali.getName());
    }

    @Test
    public void testGetActivities() {
        List<Activity> goaActivities = goa.getActivities();
        assertTrue(goaActivities.isEmpty());

        List<Activity> manaliActivities = manali.getActivities();
        assertTrue(manaliActivities.isEmpty());
    }

    @Test
    public void testAddActivity() {
        goa.addActivity(waterSportsActivity);
        List<Activity> goaActivities = goa.getActivities();
        assertEquals(1, goaActivities.size());
        assertEquals("Water Sports", goaActivities.get(0).getName());

        manali.addActivity(paraglidingActivity);
        List<Activity> manaliActivities = manali.getActivities();
        assertEquals(1, manaliActivities.size());
        assertEquals("Paragliding", manaliActivities.get(0).getName());
    }
}