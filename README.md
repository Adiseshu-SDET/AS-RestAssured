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
