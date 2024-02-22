# Nymble Assignment 
This repository  implements a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.

# Classes
**TravelPackage**: Represents a travel package, including its name, passenger capacity, enrolled passengers, and destinations. It provides methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.

**Passenger**:  Passenger has attributes such as name, passenger number, type (e.g.,standard, premium, gold), balance, and activities. Passengers can signup for any activity using [signUpForActivity](https://github.com/Amealsuraj/NymbleAssignment/blob/8a1e12e01321a2aa04d7e66dcf3199de89406840/src/main/java/com/nymble/assignment/Passenger.java#L55) method.

**Destination**: Represents a destination included in a travel package. It contains a name and a list of activities available at the destination.

**Activity**: Represents an activity available at a destination. It includes attributes such as name, cost, capacity, description, and destination.

**PassengerType**: It is enumeration type which represents passenger type(premium, gold, and standard).

**Main** : Driver program to run entire software system

# Important Methods

[printItinerary](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L53): This method prints itinerary of the travel package including travel package name,destinations and details of the activities available at each destination, like name, cost, capacity and description.

[printPassengerList](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L64): This method prints the passenger list of the travel package including package name,passenger capacity, number of passengers currently enrolled and name and number of each passenger

[printPassengerDetails](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L73):This method prints the details of an individual passenger including their name, passenger number, balance (if applicable), list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity using [calculatePrice](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L98) method.

[printAvailableActivities](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L85C14-L85C38): This method prints the details of all the activities that still have spaces available, including how many spaces are available.

# The respository also have Junit test classes for above classes

**ActivityTest**: Test methods of Activity class

**DestinationTest**:Test methods of Destination class

**PassengerTest**: Test methods of Passenger class

**TravelPackageTest**: It tests methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.
