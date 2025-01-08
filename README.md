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



##Setup Instructions
1. Clone the Repository
To get started, clone the repository using the following command:

bash
Copy code
git clone https://github.com/your-username/restassured-framework.git
cd restassured-framework
2. Configure the Project
Update the src/test/resources/config.properties file with the appropriate API base URL and timeout settings. Example:

properties
Copy code
base.url=https://jsonplaceholder.typicode.com
timeout=5000
environment=QA
3. Run Tests Locally
You can run all tests locally using Maven. Use the following command:

bash
Copy code
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
This will execute all tests specified in the testng.xml file.

4. Generate Reports
After running the tests, the Extent Report will be generated at:

bash
Copy code
test-output/extent-report.html
Open this file in a browser to view the detailed test execution report.

CI/CD Pipeline
The project is designed to integrate with Jenkins for continuous integration and continuous delivery (CI/CD).

1. Create a Jenkins Job
Go to your Jenkins dashboard and create a new Freestyle project.

Under Source Code Management, select Git and provide the repository URL.

In the Build section, add a build step to invoke Maven with the following command:

bash
Copy code
clean test -DsuiteXmlFile=src/test/resources/testng.xml
2. Configure Build Parameters
To avoid hardcoding values, add a parameterized build option in Jenkins:

Add a String Parameter named suiteXmlFile with the default value:
bash
Copy code
src/test/resources/testng.xml
3. Post-Build Actions
Add a post-build action to publish JUnit test results:
bash
Copy code
target/surefire-reports/*.xml
Add another post-build action to publish the HTML report:
HTML directory to archive: test-output
Index page[s]: extent-report.html
Report title: Extent Report
Contributing
Contributions are welcome! To contribute:

Fork the repository.
Create a new branch for your feature or bug fix.
Commit your changes and push the branch.
Submit a pull request for review.
License
This project is licensed under the MIT License. See the LICENSE file for more details.

yaml
Copy code

---

### **Steps to Add and Commit the `README.md` File**

1. **Copy the above content** into a new file named `README.md` in your Eclipse project.
2. **Save the file**.
3. **Commit the changes**:
   - Right-click on the project → **Team → Add to Index**.
   - Right-click again → **Team → Commit**.
   - Enter a commit message like:
     ```bash
     Added properly formatted README.md file
     ```
   - Click **Commit and Push**.

---

### **Expected Output on GitHub**

Once you commit and push the file, it should render perfectly on GitHub with proper headings, bullet points, code blocks, and sections.

---

Let me know if this resolves your issue! If needed, I can guide you further through the commit proce

