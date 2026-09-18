package com.nanda.automation.tests;

import com.nanda.automation.base.BaseTest;
import com.nanda.automation.driver.DriverManager;
import com.nanda.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test(groups = "smoke")
    public void homePageShouldDisplayHeading() {
        HomePage homePage = new HomePage(DriverManager.get());
        Assert.assertEquals(homePage.headingText(), "Example Domain");
    }
}
