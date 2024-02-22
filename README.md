# Nymble Assignment
This repository  implements a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.

# Classes
[**TravelPackage**](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L6): Represents a travel package, including its name, passenger capacity, enrolled passengers, and destinations. It provides methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.

[**Passenger**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/main/java/com/nymble/assignment/Passenger.java#L12):  Passenger has attributes such as name, passenger number, type (e.g.,standard, premium, gold), balance, and activities. Passengers can signup for any activity using [signUpForActivity](https://github.com/Amealsuraj/NymbleAssignment/blob/8a1e12e01321a2aa04d7e66dcf3199de89406840/src/main/java/com/nymble/assignment/Passenger.java#L55) method.

[**Destination**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/main/java/com/nymble/assignment/Destination.java#L6): Represents a destination included in a travel package. It contains a name and a list of activities available at the destination.

[**Activity**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/main/java/com/nymble/assignment/Activity.java#L3): Represents an activity available at a destination. It includes attributes such as name, cost, capacity, description, and destination.

[**PassengerType**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/main/java/com/nymble/assignment/Passenger.java#L7): It is enumeration type which represents passenger type(premium, gold, and standard).

[**Main**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/main/java/com/nymble/assignment/Main.java#L3) : Driver program to run entire software system

# Important Methods

[printItinerary](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L53): This method prints itinerary of the travel package including travel package name,destinations and details of the activities available at each destination, like name, cost, capacity and description.

[printPassengerList](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L64): This method prints the passenger list of the travel package including package name,passenger capacity, number of passengers currently enrolled and name and number of each passenger

[printPassengerDetails](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L73):This method prints the details of an individual passenger including their name, passenger number, balance (if applicable), list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity using [calculatePrice](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L98) method.

[printAvailableActivities](https://github.com/Amealsuraj/NymbleAssignment/blob/b7ec991ee0eba296557d42f669fe4c02e1b035d5/src/main/java/com/nymble/assignment/TravelPackage.java#L85C14-L85C38): This method prints the details of all the activities that still have spaces available, including how many spaces are available.

# The respository also have Junit test classes for above classes

[**ActivityTest**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/test/java/com/nymble/assignment/ActivityTest.java#L8): Test methods of Activity class

[**DestinationTest**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/test/java/com/nymble/assignment/DestinationTest.java#L11):Test methods of Destination class

[**PassengerTest**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/test/java/com/nymble/assignment/PassengerTest.java#L11): Test methods of Passenger class

[**TravelPackageTest**](https://github.com/Amealsuraj/NymbleAssignment/blob/7f56619a8445dab9048b83562cbc3ad0b89fcdd9/src/test/java/com/nymble/assignment/TravelPackageTest.java#L14): It tests methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.
