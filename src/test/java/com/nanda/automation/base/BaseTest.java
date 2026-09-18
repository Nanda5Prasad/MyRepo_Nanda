package com.nanda.automation.base;

import com.nanda.automation.config.Config;
import com.nanda.automation.driver.DriverManager;
import com.nanda.automation.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        DriverManager.start();
        DriverManager.get().manage().window().maximize();
        DriverManager.get().get(Config.baseUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getMethod().getMethodName();
            LOG.error("UI test failed: {}", testName, result.getThrowable());
            ScreenshotUtil.capture(testName);
        }
        DriverManager.quit();
    }
}
