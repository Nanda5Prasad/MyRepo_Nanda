# Professional Selenium Java Framework

A maintainable Selenium framework for IntelliJ IDEA and Maven using Java 21, JUnit 5, Page Object Model, thread-safe WebDriver management, explicit waits, configuration profiles, logging, and failure screenshots.

## Architecture

```text
src/
├── main/java/com/nanda/automation/
│   ├── config/Config.java              configuration and system-property overrides
│   ├── driver/DriverFactory.java       browser creation
│   ├── driver/DriverManager.java       ThreadLocal WebDriver lifecycle
│   ├── pages/BasePage.java             reusable page actions and waits
│   └── utils/ScreenshotUtil.java       failure screenshot utility
├── main/resources/log4j2.xml
├── test/java/com/nanda/automation/
│   ├── base/BaseTest.java              JUnit lifecycle and failure capture
│   ├── pages/HomePage.java             page object
│   └── tests/HomePageTest.java         test layer only
└── test/resources/config.properties    default test configuration
```

## IntelliJ IDEA

1. Install a JDK 21 distribution, such as Temurin 21.
2. Open the repository in IntelliJ IDEA.
3. Select **JDK 21** under **Project Structure → Project → SDK**.
4. Set the language level to **21**.
5. Open `pom.xml` and select **Load Maven Project**.
6. In **Settings → Build, Execution, Deployment → Build Tools → Maven**, ensure Maven uses JDK 21.
7. Right-click `HomePageTest` and choose **Run**.

## Run

```bash
mvn clean test
```

Verify the runtime first if needed:

```bash
java -version
mvn -version
```

Override configuration without changing source code:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=false -DbaseUrl=https://example.com
```

Supported browsers: `chrome`, `firefox`, and `edge`.

Screenshots from failed tests are saved in `target/screenshots/`.
