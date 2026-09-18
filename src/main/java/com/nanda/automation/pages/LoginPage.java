package com.nanda.automation.pages;

import com.nanda.automation.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BasePage {
    private final By usernameInput = By.id(Config.usernameLocator());
    private final By passwordInput = By.id(Config.passwordLocator());
    private final By loginButton = By.id(Config.loginButtonLocator());
    private final By loginPageMarker = By.id(Config.loginPageMarkerLocator());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage(driver);
    }

    public HomePage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    public boolean isDisplayed() {
        return isDisplayed(loginPageMarker);
    }
}
