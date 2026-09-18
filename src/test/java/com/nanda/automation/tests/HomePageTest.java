package com.nanda.automation.tests;

import com.nanda.automation.base.BaseTest;
import com.nanda.automation.driver.DriverManager;
import com.nanda.automation.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomePageTest extends BaseTest {
    @Test
    void homePageShouldDisplayHeading() {
        HomePage homePage = new HomePage(DriverManager.get());
        Assertions.assertEquals("Example Domain", homePage.headingText());
    }
}
