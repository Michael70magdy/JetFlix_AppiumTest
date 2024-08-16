# Mobile Application Testing Automation with Appium

This project is a test automation suite for a mobile application using Java and Appium. The project automates two scenarios: verifying movie names across screens and validating the release date filter.

## Project Structure
- **`src/test/java`**: Contains the test classes for each scenario.
- **`resources`**: Includes any necessary configuration files.
- **`reports`**: Holds the generated test execution reports.
- **`pom.xml`**: Maven configuration file for managing project dependencies.

## Scenarios Covered

### Scenario 1: Verify Movie Name Consistency
- **Description**: Checks that the movie name displayed on the home screen is the same as the movie name on the movie details screen.
  
  **Steps**:
  1. Write a generic method to click on any movie name on the home screen.
  2. Write a generic method to retrieve the movie name from both the home screen and the movie screen.
  3. Assert that the retrieved movie names from both screens are the same.

### Scenario 2: Verify Release Date Filter
- **Description**: Ensures that the release date filter on the home screen only displays movies that are scheduled for future release dates.

  **Steps**:
  1. Click on the menu filter.
  2. Choose the release date filter.
  3. Assert that the filtered movies have release dates in the future.

## Tools and Technologies Used

- **Java**: Programming language used for writing the test scripts.
- **Appium**: Automation framework for testing mobile applications.
- **Maven**: Build automation tool for managing dependencies and running the project.
