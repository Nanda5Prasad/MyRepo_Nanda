# Locator configuration

The framework now keeps application-specific values configurable through Maven or IntelliJ system properties. The default values are placeholders and can be replaced later without changing page-object code.

| Property | Default | Purpose |
|---|---|---|
| `baseUrl` | `https://example.com` | Application root URL |
| `loginUrl` | value of `baseUrl` | Login page URL |
| `usernameLocator` | `username` | Username element ID |
| `passwordLocator` | `password` | Password element ID |
| `loginButtonLocator` | `loginBtn` | Login button element ID |
| `loginPageMarkerLocator` | `login-form` | Login page marker element ID |
| `homeHeadingLocator` | `h1` | Home heading CSS selector |
| `dashboardMarkerLocator` | `dashboard` | Dashboard element ID |

Run with your real application values:

```bash
mvn clean test \
  -DbaseUrl=https://your-application.example.com \
  -DloginUrl=https://your-application.example.com/login \
  -DusernameLocator=email \
  -DpasswordLocator=password \
  -DloginButtonLocator=loginButton \
  -DloginPageMarkerLocator=loginForm \
  -DhomeHeadingLocator=h1 \
  -DdashboardMarkerLocator=dashboard \
  -Dusername=your-user \
  -Dpassword=your-password
```

`LoginPage` uses ID locators for the login controls and marker. `HomePage` uses a CSS selector for the heading and an ID for the dashboard marker. If your application uses CSS or XPath instead, change the locator factory when the real DOM is available.
