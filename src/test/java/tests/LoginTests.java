package tests;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;
import utilities.FrameworkConstants;

public class LoginTests extends TestBase {

    @Test
    public void testValidCredentials(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();

        Assert.assertTrue(new LoginPage().getProfileIcon().isDisplayed());
    }

    @Test
    public void testInVvalidCredentials(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login("invalidEmail@gmail.com", "invalidPassowrd");

        Assert.assertFalse(new LoginPage().getProfileIcon().isDisplayed());
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Log in"));
    }

}
