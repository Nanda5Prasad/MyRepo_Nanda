package com.nanda.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BasePage {
    private final By heading = By.tagName("h1");
    private final By dashboardMarker = By.id("dashboard");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String headingText() {
        return text(heading);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardMarker);
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(heading);
    }
}
