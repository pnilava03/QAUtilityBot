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
├── base/
├── pages/
├── utils/
├── reports/
├── testdata/
├── drivers/
├── tests/
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

Features

✔ Browser automation using Selenium WebDriver
✔ Data-driven testing using CSV files
✔ Smoke and regression validation support
✔ Broken link and sitemap crawling support
✔ Reusable utility-based architecture
✔ Maven-based dependency management
✔ TestNG execution and reporting
✔ Scalable framework structure for future enhancements

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

## How this helps
You can use this for:

1. Broken link checking
2. Smoke validation
3. Page title validation
4. UI content validation
5. Regression support
6. Daily health check automation
7. Report generation


## Support e-commerce site has:
1. 500 product pages
2. 100 category pages
Where Manual checking is impossible.

 ## Future Enhancements
- Extent Report / Allure Report integration
- Screenshot capture on failure
- Headless execution support
- Docker support
- Jenkins CI/CD integration
- Parallel browser execution
- Cross-browser testing
- Email report generation
- API testing integration using REST Assured
- Cloud execution support (AWS/Jenkins/Grid)

## Example QA Utilities
- Crawl all URLs from sitemap.xml
- Validate HTTP status codes
- Verify page titles
- Detect broken links
- Export validation results to CSV
- Perform smoke validation for production URLs
---
**Project**: QA Utility Bot  
**Author**: pnilava03  
**Last Updated**: 2026-05-27
