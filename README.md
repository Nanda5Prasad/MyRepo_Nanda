# Professional Selenium + API Automation Framework

Reusable UI page objects are located under `src/main/java/com/nanda/automation/pages`:

- `BasePage` — common waits, clicks, typing, text, visibility, title, and URL methods.
- `LoginPage` — reusable `login(username, password)` flow.
- `HomePage` — post-login page actions and assertions.

Example:

```java
LoginPage loginPage = new LoginPage(DriverManager.get());
HomePage homePage = loginPage.login(Config.username(), Config.password());
Assert.assertTrue(homePage.isDashboardDisplayed());
```

Update the locators in `LoginPage` and `HomePage` to match your application. The default `https://example.com` URL is only a demo page and does not contain login controls.

Credentials should be supplied as Maven system properties or environment-backed IntelliJ run configuration values, not committed to source control:

```bash
mvn clean test \
  -Dusername=your-user \
  -Dpassword=your-password \
  -DbaseUrl=https://your-application.example.com \
  -Dheadless=false
```
