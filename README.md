# NymbleAssignment
This repository implements implements a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.

#Classes
TravelPackage: Represents a travel package, including its name, passenger capacity, enrolled passengers, and destinations. It provides methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.

Passenger:  Passenger has attributes such as name, passenger number, type (e.g.,standard, premium, gold), balance, and activities. Passengers can signup for any activity using signUpForActivity method.

Destination: Represents a destination included in a travel package. It contains a name and a list of activities available at the destination.

Activity: Represents an activity available at a destination. It includes attributes such as name, cost, capacity, description, and destination.

PassengerType: It is enumeration type which represents passenger type(premium, gold, and standard).

Main : Driver program to run entire software system

The respository also have Junit test classes for above classes
ActivityTest: Test methods of Activity class
DestinationTest:Test methods of Destination class
PassengerTest: Test methods of Passenger class
TravelPackageTest: It tests methods for managing destinations, enrolling passengers, printing itineraries, printing passenger lists, printing passenger details and printing available activities.
