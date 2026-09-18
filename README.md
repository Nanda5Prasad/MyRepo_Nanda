# Professional Selenium + API Automation Framework

Java 21, Selenium, TestNG, REST Assured, Maven, Page Object Model, explicit waits, logging, and failure screenshots.

## Test layout

```text
src/test/java/com/nanda/automation/
├── api/
│   ├── base/BaseApiTest.java
│   └── tests/HealthApiTest.java
├── base/BaseTest.java
├── pages/HomePage.java
└── tests/HomePageTest.java

src/test/resources/suites/
├── smoke-suite.xml
├── api-suite.xml
└── regression-suite.xml
```

UI tests and API tests are deliberately separated by package. Both use TestNG and can be run independently or together.

## Run in IntelliJ IDEA

Open `pom.xml`, load Maven, select JDK 21, and right-click any TestNG class or suite XML file to run it.

## Run with Maven

```bash
# Default: UI smoke suite
mvn clean test

# API suite
mvn clean test -DsuiteXmlFile=src/test/resources/suites/api-suite.xml

# UI smoke suite
mvn clean test -DsuiteXmlFile=src/test/resources/suites/smoke-suite.xml

# Full regression suite
mvn clean test -DsuiteXmlFile=src/test/resources/suites/regression-suite.xml
```

Override endpoints and browser settings without editing code:

```bash
mvn clean test \
  -DsuiteXmlFile=src/test/resources/suites/api-suite.xml \
  -DapiBaseUrl=https://httpbin.org
```

API screenshots are not applicable; failed API requests are logged by REST Assured. UI failure screenshots are written to `target/screenshots/`.
