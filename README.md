# Drone Flight Planner Tests

# Test Suite

These tests are written in Java using 'Selenium' and 'testNG' as a testing framework. 
The test suite contains 4 (four) test cases which test the basic functionality of the 'Drone Flight Planner' site.
The tests were designed to be executed on Google Chrome due to currently is the most used browser.


### TestNG Suite

The TestNG Suite executes 4 (four) tests to verify the behaviour of the 'Drone Flight Planner' site.

## Mission Drone Test Suite

### Mission Drone Tests

The suite has four different test cases:

- CreateANewFlightPlan: This test opens the 'stupendous-birth' site, clicks on the 'create new flight plan' button, creates a route, adds a name to it, and then verifies that the starting point is in the given coordinates;

- CreateTwoFlightPlans: This test opens the 'stupendous-birth' site, clicks on the 'create new flight plan' button, creates a route,  clicks on the '+' button in order to create a new route, adds a route to the new flight plan and verifies the 'point b'of it;

- CreateAFlightThruFirstOne: This test opens the 'stupendous-birth' site, clicks on the 'create the first one' button, creates a route, adds a name to it, and then verifies that the starting point is in the given coordinates;

- CreateANamelessFlightPlan: This test opens the 'stupendous-birth' site, clicks on the 'create new flight plan' button, creates a route, does not add a name to it, and then verifies that the starting point is in the given coordinates. The purpose of this test is to validate the autosave feature;

### Maven Project

This is a maven project, so the test suite can be executed through command line. All you need to execute is:
```
    $mvn test
```
and this will run all the tests.

### TestNG Tests

If you prefer to execute one test at a time, the command that you should execute is 
```
    $mvn test -Dtest='name of the test'.
```
You can execute more than one, separated by comma ','.

If you decide to import the whole maven project to an IDE (Eclipse, for instance), all you have to do, is to run the classes that are in the package 'appium.wonkyCalculatorTests.tests' as 'TestNG test'. Au contraire, if you prefer to run the tests altogether also from the IDE, you can do the same, but running as a 'TestNG Suite' the testng.xml file located under the 'src' folder.

### Structure
#### Wait Class
The class 'WaitForPageToLoad' located under the 'missionDrone.flightPlan.waits' package, is in charge of waiting until the page is fully loaded to avoid timeouts during the test execution.
#### Page Object class
The class 'LandingPageObjects', 'MissionObjects', 'OpenStreetObjects' located under the 'missionDrone.flightPlan.objectModel' package, hold each and every one of the objects that are present within the 'Drone Flight Planner' app.
#### Test classes
The test classes located under the 'missionDrone.flightPlan.tests' hold the test cases that verify the correct behaviour of the application.

## Preconditions

The only requirements that you need to run this tests are:
- Maven;
- Java;
- Google Chrome


