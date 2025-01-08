REST Assured API Automation Framework
Overview
This project is a scalable, robust, and flexible REST Assured API Automation Framework designed to automate RESTful web services testing. It uses Maven, TestNG, Extent Reports, and Jenkins for CI/CD integration.

Key Features
Data-Driven Testing using Excel.
Dynamic Configuration through properties files.
Detailed HTML Reporting with Extent Reports.
Retry Logic for flaky tests.
Logging using Log4j.
CI/CD Integration with Jenkins.
Prerequisites
Java: JDK 11 or later
Maven: 3.6 or later
Git
IDE: Eclipse or IntelliJ IDEA
Jenkins (for CI/CD pipeline)
Project Structure
bash
Copy code
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
Setup Instructions
Clone the Repository
bash
Copy code
git clone https://github.com/your-username/restassured-framework.git
cd restassured-framework
Configure the Project
Update the src/test/resources/config.properties file with the appropriate API base URL and timeout settings.

Run Tests Locally
To run all tests using Maven:

bash
Copy code
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
Generate Reports
After running the tests, the Extent Report can be found at:

bash
Copy code
test-output/extent-report.html
CI/CD Pipeline
The project is designed to integrate with Jenkins for automated test execution.

Parameters:

suiteXmlFile: Path to the TestNG suite XML file.
Maven Command:

bash
Copy code
clean test -DsuiteXmlFile=${suiteXmlFile}
Post-build Actions:

Publish JUnit test results: target/surefire-reports/*.xml.
Publish Extent Reports: test-output/extent-report.html.
Contributing
Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request for review.

License
This project is licensed under the MIT License.