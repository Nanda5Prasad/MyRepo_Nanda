package com.nanda.automation.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private DriverManager() {}

    public static void start() { DRIVER.set(DriverFactory.create()); }
    public static WebDriver get() {
        if (DRIVER.get() == null) throw new IllegalStateException("WebDriver has not been started");
        return DRIVER.get();
    }
    public static void quit() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
