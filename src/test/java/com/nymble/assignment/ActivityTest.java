package com.nymble.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {

    private Destination goa;
    private Activity waterSportsActivity;

    @Before
    public void setUp() {
        goa = new Destination("Goa");
        waterSportsActivity = new Activity("Water Sports", "Thrilling Jet Ski Ride,Parasailing", 50.0, 20, goa);
    }

    @Test
    public void testGetName() {
        assertEquals("Water Sports", waterSportsActivity.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Thrilling Jet Ski Ride,Parasailing", waterSportsActivity.getDescription());
    }

    @Test
    public void testGetCost() {
        assertEquals(50.0, waterSportsActivity.getCost(), 0.001);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(20, waterSportsActivity.getCapacity());
    }

    @Test
    public void testGetDestination() {
        assertEquals(goa, waterSportsActivity.getDestination());
    }

    @Test
    public void testSetCapacity() {
        waterSportsActivity.setCapacity(15);
        assertEquals(15, waterSportsActivity.getCapacity());
    }
}

