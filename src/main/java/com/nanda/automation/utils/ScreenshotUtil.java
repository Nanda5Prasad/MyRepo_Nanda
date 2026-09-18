package com.nanda.automation.utils;

import com.nanda.automation.driver.DriverManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtil {
    private ScreenshotUtil() {}

    public static Path capture(String testName) {
        try {
            Path directory = Path.of("target", "screenshots");
            Files.createDirectories(directory);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            Path destination = directory.resolve(testName + "-" + timestamp + ".png");
            Files.write(destination, ((TakesScreenshot) DriverManager.get()).getScreenshotAs(OutputType.BYTES));
            return destination;
        } catch (IOException | RuntimeException exception) {
            return null;
        }
    }
}
