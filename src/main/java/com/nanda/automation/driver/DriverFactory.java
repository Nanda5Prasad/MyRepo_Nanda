package com.nanda.automation.driver;

import com.nanda.automation.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver create() {
        return switch (Config.browser().toLowerCase()) {
            case "chrome" -> chrome();
            case "firefox" -> firefox();
            case "edge" -> edge();
            default -> throw new IllegalArgumentException("Unsupported browser: " + Config.browser());
        };
    }

    private static WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080", "--disable-dev-shm-usage", "--no-sandbox");
        if (Config.headless()) options.addArguments("--headless=new");
        return new ChromeDriver(options);
    }

    private static WebDriver firefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (Config.headless()) options.addArguments("-headless");
        return new FirefoxDriver(options);
    }

    private static WebDriver edge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (Config.headless()) options.addArguments("--headless=new");
        return new EdgeDriver(options);
    }
}
