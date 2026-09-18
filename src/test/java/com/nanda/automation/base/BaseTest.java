package com.nanda.automation.base;

import com.nanda.automation.config.Config;
import com.nanda.automation.driver.DriverManager;
import com.nanda.automation.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    void setUp() {
        DriverManager.start();
        DriverManager.get().manage().window().maximize();
        DriverManager.get().get(Config.baseUrl());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        if (DriverManager.get() != null) DriverManager.quit();
    }

    protected void captureFailure(TestInfo testInfo, Throwable failure) {
        LOG.error("Test failed: {}", testInfo.getDisplayName(), failure);
        ScreenshotUtil.capture(testInfo.getDisplayName().replaceAll("[^a-zA-Z0-9-_]", "_"));
    }
}
