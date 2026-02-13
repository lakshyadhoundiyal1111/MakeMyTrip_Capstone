# MakeMyTrip Automation Project (Complete)

## Project Overview
Complete Selenium automation framework using Cucumber BDD for testing MakeMyTrip website with ALL 26+ test scenarios from the PDF requirements.

## Framework Features
- Cucumber BDD with Gherkin syntax
- Feature files for each module
- Single TestRunner to execute all tests
- Page Object Model design pattern
- Screenshot capture on failure
- Multi-browser support (Chrome/Edge)
- Comprehensive test coverage

## Prerequisites
- Java JDK 8 or higher
- Maven
- Chrome or Edge browser
- Eclipse IDE

## Setup Instructions

1. Extract the project ZIP file
2. Open Eclipse
3. Go to File > Import > Maven > Existing Maven Projects
4. Browse to the extracted folder and select it
5. Click Finish
6. Wait for Maven to download all dependencies

## Project Structure
```
src/main/java
  - base: Driver setup
  - pages: Page Object Model classes (HomePage, FlightsPage, HotelsPage, TrainsPage, ResultsPage)
  - utils: Utility functions (WaitUtils, ScreenshotUtil)

src/test/java
  - stepdefinitions: Step definition classes for all features
  - runner: TestRunner class

src/test/resources/features
  - HomePage.feature (5 scenarios)
  - Flights.feature (7 scenarios)
  - Hotels.feature (4 scenarios)
  - Trains.feature (4 scenarios)
  - FiltersAndSorting.feature (4 scenarios)
  - SearchResults.feature (3 scenarios)
  - Navigation.feature (3 scenarios)
```

## Test Coverage (30 Scenarios)

### Home Page Module (5 tests)
1. Verify home page loads successfully
2. Verify login popup is handled
3. Verify presence of Flights tab
4. Verify presence of Hotels tab
5. Verify presence of Trains tab

### Flights Module (7 tests)
6. Verify From and To fields are present
7. Verify departure date picker is present
8. Search flights with valid cities
9. Search flights with same source and destination
10. Search flights without selecting travel date
11. Verify flight search results page is displayed
12. Verify list of available flights

### Hotels Module (4 tests)
13. Verify hotels page loads
14. Search hotels with valid city
15. Search hotels without selecting dates
16. Verify hotel results are displayed

### Trains Module (4 tests)
17. Verify trains page loads
18. Search trains with valid stations
19. Search trains without travel date
20. Verify train results page

### Filters & Sorting Module (4 tests)
21. Apply price filter and verify results
22. Apply rating filter and verify results
23. Sort search results by price
24. Clear applied filters and verify results reset

### Search Results Module (3 tests)
25. Click on a flight/hotel from search results
26. Verify details page is displayed
27. Verify fare or price details are displayed

### Navigation Module (3 tests)
28. Verify navigation from Flights to Hotels
29. Verify navigation from Hotels to Trains
30. Verify navigation from Trains to Flights

## Running Tests

### From Eclipse:
1. Right-click on TestRunner.java
2. Select Run As > TestNG Test

OR

1. Right-click on testng.xml
2. Select Run As > TestNG Suite

### From Command Line:
```
mvn clean test
```

## Reports
- Cucumber HTML report: reports/cucumber-report.html
- Screenshots: screenshots/ folder (captured on failure)
- TestNG reports: test-output/ folder

## Important Notes
- Login popup is handled with body click to dismiss overlay
- Hotel search includes APPLY button click for rooms/guests popup
- URL-based verification for results pages
- Tests run sequentially (not parallel)
- Each scenario opens new browser instance
- Login and payment flows are NOT automated as per requirements

## Key Fixes Implemented
1. Login popup handling with body click
2. Hotel APPLY button for rooms & guests
3. URL verification for all result pages
4. Error handling for invalid searches
5. Navigation between modules
6. Filters and sorting functionality
7. Details page verification

## Execution Flow
TestRunner.java → Cucumber reads all .feature files → Executes scenarios → Calls step definitions → Interacts with page objects → Returns results

## Project Completion Status
✅ ALL 26+ test scenarios from PDF implemented
✅ All modules covered (Home, Flights, Hotels, Trains, Filters, Results, Navigation)
✅ Cucumber BDD framework
✅ Page Object Model
✅ Single test runner
✅ Error handling
✅ Screenshot on failure
