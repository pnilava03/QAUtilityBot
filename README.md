# QA Utility Bot

A Java-based test automation framework for browser automation and QA testing.

## Overview

QA Utility Bot is a comprehensive automation solution built with Selenium and TestNG, designed to streamline quality assurance testing processes. It provides utilities for web application testing with support for CSV-based test data management.

## Technologies & Dependencies

- **Java 21** - Latest Java LTS version
- **Selenium 4.44.0** - Web browser automation framework
- **TestNG 7.11.0** - Testing framework for test execution and reporting
- **Apache Commons CSV 1.11.0** - CSV file parsing and data handling
- **Maven** - Build and dependency management

## Project Structure

```
QAUtilityBot/
├── src/
│   ├── main/
│   │   ├── java/          # Main source code
│   │   └── resources/     # Test resources (configs, test data)
│   └── test/
│       ├── java/          # Test cases
│       └── resources/     # Test resources
├── pom.xml                # Maven configuration
└── README.md
```

## Prerequisites

- **Java Development Kit (JDK) 21** or later
- **Maven 3.6.0** or later
- **Git**

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/pnilava03/QAUtilityBot.git
   cd QAUtilityBot
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

## Usage

### Running Tests

Execute all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=YourTestClassName
```

Run specific test method:
```bash
mvn test -Dtest=YourTestClassName#testMethodName
```

### Building the Project

```bash
mvn clean package
```

## Features

- **Selenium WebDriver Integration** - Browser automation capabilities
- **TestNG Framework** - Powerful test execution and reporting
- **CSV Data Management** - Support for data-driven testing with CSV files
- **Modular Design** - Organized structure for maintainability and scalability

### Test Data

Store test data files (CSV, JSON, etc.) in:
- `src/main/resources/` - For shared test data
- `src/test/resources/` - For test-specific resources

## Configuration

Configure your test settings:
- **Browser settings** - Update WebDriver configurations
- **Test URLs** - Modify base URLs in configuration files
- **Timeouts** - Adjust Selenium wait times as needed

## Troubleshooting

- Ensure Java 21 is installed: `java -version`
- Clear Maven cache: `mvn clean`
- Update dependencies: `mvn dependency:resolve`


## Support
For issues, questions, or contributions, please open an issue on GitHub.

---

**Project**: QA Utility Bot  
**Author**: pnilava03  
**Last Updated**: 2026-05-27
