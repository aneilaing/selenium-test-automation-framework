package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShouldNavigateToInventoryPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "User was not redirected to inventory page");
    }

    @Test
    public void invalidLoginShouldShowErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("locked_out_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error message was not displayed");
    }
}