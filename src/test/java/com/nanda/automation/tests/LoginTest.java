package com.nanda.automation.tests;

import com.nanda.automation.base.BaseTest;
import com.nanda.automation.config.Config;
import com.nanda.automation.driver.DriverManager;
import com.nanda.automation.pages.HomePage;
import com.nanda.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "login"})
    public void validUserShouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(DriverManager.get());
        HomePage homePage = loginPage.login(Config.username(), Config.password());

        Assert.assertTrue(
                homePage.isDashboardDisplayed(),
                "Dashboard should be displayed after successful login"
        );
    }
}
