# REST Assured API Automation Framework

## Overview

This project is a scalable, robust, and flexible **REST Assured API Automation Framework** designed to automate RESTful web services testing. It uses **Maven**, **TestNG**, **Extent Reports**, and **Jenkins** for CI/CD integration.

---

## Key Features

- **Data-Driven Testing** using Excel.
- **Dynamic Configuration** through properties files.
- **Detailed HTML Reporting** with Extent Reports.
- **Retry Logic** for flaky tests.
- **Logging** using Log4j.
- **CI/CD Integration** with Jenkins.

---

## Prerequisites

Ensure you have the following installed before setting up the project:

- **Java**: JDK 11 or later  
- **Maven**: 3.6 or later  
- **Git**  
- **IDE**: Eclipse or IntelliJ IDEA  
- **Jenkins**: For CI/CD pipeline

---

## Project Structure

```bash
restassured-framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/                # Base classes for test setup
│   │       └── utils/               # Utilities for reporting, logging, and configuration
│   └── test/
│       └── java/
│           └── tests/               # Test classes
│   └── resources/                   # Configuration files (e.g., config.properties)
├── pom.xml                          # Maven configuration file
└── testng.xml                       # TestNG suite file



# REST Assured Framework

## Setup Instructions

### 1. Clone the Repository
To get started, clone the repository using the following command:

```bash
git clone https://github.com/your-username/restassured-framework.git
cd restassured-framework
```

### 2. Configure the Project
Update the `src/test/resources/config.properties` file with the appropriate API base URL and timeout settings. Example:

```properties
base.url=https://jsonplaceholder.typicode.com
timeout=5000
environment=QA
```

### 3. Run Tests Locally
You can run all tests locally using Maven. Use the following command:

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

This will execute all tests specified in the `testng.xml` file.

### 4. Generate Reports
After running the tests, the Extent Report will be generated at:

```bash
test-output/extent-report.html
```

Open this file in a browser to view the detailed test execution report.

## CI/CD Pipeline
The project is designed to integrate with Jenkins for continuous integration and continuous delivery (CI/CD).

### 1. Create a Jenkins Job
- Go to your Jenkins dashboard and create a new Freestyle project.
- Under **Source Code Management**, select **Git** and provide the repository URL.
- In the **Build** section, add a build step to invoke Maven with the following command:

```bash
clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

### 2. Configure Build Parameters
To avoid hardcoding values, add a parameterized build option in Jenkins:

- Add a **String Parameter** named `suiteXmlFile` with the default value:

```bash
src/test/resources/testng.xml
```

### 3. Post-Build Actions
- Add a post-build action to publish JUnit test results:

```bash
target/surefire-reports/*.xml
```

- Add another post-build action to publish the HTML report:
  - **HTML directory to archive**: `test-output`
  - **Index page[s]**: `extent-report.html`
  - **Report title**: `Extent Report`

## Contributing
Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch.
4. Submit a pull request for review.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.


