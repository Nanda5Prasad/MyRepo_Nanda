package com.nanda.automation.legacy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** @deprecated Use com.nanda.automation.pages.HomePage. */
@Deprecated
public final class HomePage {
    private final WebDriver driver;
    private final By heading = By.tagName("h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String headingText() {
        return driver.findElement(heading).getText();
    }
}
