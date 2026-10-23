# How to Run Automation Standalone Example Project

This is a **Cucumber BDD (Behavior Driven Development) automation testing project** using Selenium WebDriver with Java.

## Project Overview
- **Type**: Maven-based test automation framework
- **Test Framework**: Cucumber 6.11.0 + JUnit 4
- **Browser Automation**: Selenium 4.6.0
- **Reporting**: Extent Reports
- **Language**: Java (JDK 17)
- **Browser**: Chrome (default)

---

## Prerequisites

Before running the project, ensure you have:

1. **Java Development Kit (JDK) 17** installed
   - Check: `java -version`

2. **Maven 3.6+** installed
   - Check: `mvn -version`

3. **Google Chrome** browser installed (for default tests)

4. **Git** (optional, for cloning)

---

## Quick Start - Run Tests Locally

### 1. **Clean Compile**
```powershell
mvn clean test-compile
```

### 2. **Run All Tests**
```powershell
mvn test
```

### 3. **Run Specific Tests by Tag**

Run Wikipedia tests (tagged as @wikipedia1):
```powershell
mvn test -Dcucumber.filter.tags="@wikipedia1"
```

Run Sauce Demo tests (tagged as @sauceDemo):
```powershell
mvn test -Dcucumber.filter.tags="@sauceDemo"
```

### 4. **View Test Reports**
After tests complete, reports are generated in:
```
target/reports/extent/HtmlReport/ExtentHtml.html
```
Open this file in a browser to view detailed test results.

---

## Advanced Options

### Run with Logging
Enable trace-level logging:
```powershell
mvn test -Dlog=trace
```

### Run with Specific Chrome Version
```powershell
mvn test -Dwdm.chromeDriverVersion=115.0.5790.170
```

### Run with Proxy Settings
```powershell
mvn test -Dwdm.proxy=proxy.server.com:port
```

### Run with Specific Configuration Profile
```powershell
mvn test -Dprofile=src/test/resources/project/example/config/example.properties
```

### Run Multiple Tests in Parallel
Configure threading in pom.xml (default: 3 threads):
```powershell
mvn test -Dthreads=5
```

---

## Project Structure

```
automation_standalone_example/
├── src/test/java/com/astrazeneca/automation/
│   ├── common/                 # Shared utilities & framework code
│   │   ├── driver/            # WebDriver management
│   │   ├── logger/            # Logging
│   │   ├── pages/             # Page Object Models
│   │   ├── steps/             # Common step definitions
│   │   └── utilities/         # Helper utilities
│   └── project/example/       # Project-specific code
│       ├── pages/             # Project page objects (SauceDemoPage, WikipediaPage)
│       ├── steps/             # Project step definitions
│       └── runners/           # Cucumber runner classes
│
├── src/test/resources/
│   ├── cucumber.properties    # Cucumber config
│   ├── extent.properties      # Report config
│   ├── log4j2.xml            # Logging config
│   └── project/example/
│       ├── *.feature          # Cucumber feature files
│       └── config/            # Environment configurations
│
├── pom.xml                    # Maven configuration
├── default.properties         # Default browser settings
├── Jenkinsfile               # CI/CD pipeline configuration
└── README.txt                # Project setup instructions
```

---

## Feature Files & Tests

Available test scenarios:

| Feature File | Tag | Description |
|---|---|---|
| `wikipedia1.feature` | `@wikipedia1` | Wikipedia search tests |
| `wikipedia2.feature` | `@wikipedia2` | Additional Wikipedia tests |
| `wikipedia3.feature` | `@wikipedia3` | More Wikipedia tests |
| `wikipedia4.feature` | `@wikipedia4` | Extended Wikipedia tests |
| `sauceDemoAccessibilityTests.feature` | `@sauceDemo` | Sauce Labs demo accessibility tests |
| `wikipedia-test.feature` | (in test folder) | Additional test scenarios |

---

## Configuration Files

### Browser Configuration
- **Location**: `src/test/resources/project/example/config/`
- **Default**: `example.properties`
- **Options**: `chromebs.properties`, `edgebs.properties`, `jenkins.properties`, `ms.properties`, `xvfb.properties`

Switch config:
```powershell
mvn test -Dprofile=src/test/resources/project/example/config/jenkins.properties
```

### Default Browser Settings
Edit `default.properties` to customize:
- Browser type (chrome, edge, firefox)
- Download directory
- Chrome arguments and preferences
- SSL certificate handling

---

## Troubleshooting

### WebDriver Manager Issues
If chromedriver download fails, manually specify:
```powershell
mvn test -Dwdm.chromeDriverVersion=115.0.5790.170
```

### Proxy Issues (Corporate Networks)
Configure proxy in pom.xml or via command line:
```powershell
mvn test -Dhttp.proxyHost=proxy.server.com -Dhttp.proxyPort=9480
```

### SSL Certificate Errors
The project includes a trust store (`az-cacerts`). It's automatically configured in pom.xml.

### Test Execution Timeout
Tests may fail if browser takes too long to load. Check:
- Network connectivity
- Browser resource availability
- Log files in `target/logs/`

---

## CI/CD Pipeline (Jenkins)

The `Jenkinsfile` contains pipeline configuration for automated testing:
- Uses Docker image with Chrome and JDK17
- Kerberos authentication
- Maven build and test stages
- HTML report publishing

To trigger the pipeline on Jenkins, push to the repository.

---

## Sample Commands

```powershell
# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Run only Wikipedia tests with trace logging
mvn test -Dcucumber.filter.tags="@wikipedia1" -Dlog=trace

# Run tests in parallel (6 threads)
mvn test -Dthreads=6

# Generate reports without running tests
mvn surefire-report:report

# View test results (Windows)
start target/reports/extent/HtmlReport/ExtentHtml.html
```

---

## Key Classes

- **WebDriverFactory.java** - Creates and manages WebDriver instances
- **Steps.java** - Base class for all step definitions
- **World.java** - Shares state between steps (driver, report, context)
- **WikipediaPage.java** - Page Object for Wikipedia
- **SauceDemoPage.java** - Page Object for Sauce Demo
- **Log.java** - Centralized logging
- **ReportSteps.java** - Report generation methods

---

## Additional Resources

- Cucumber: https://cucumber.io/docs/cucumber/
- Selenium: https://www.selenium.dev/documentation/
- Maven: https://maven.apache.org/guides/
- Extent Reports: https://extentreports.com/

