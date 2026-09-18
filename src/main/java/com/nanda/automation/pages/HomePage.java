package com.nanda.automation.pages;

import com.nanda.automation.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BasePage {
    private final By heading = By.cssSelector(Config.homeHeadingLocator());
    private final By dashboardMarker = By.id(Config.dashboardMarkerLocator());

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
