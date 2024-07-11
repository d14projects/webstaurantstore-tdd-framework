package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

public class LoginTests extends TestBase {

@Test
public void testValidCredentials() {
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    new LoginPage().login();

    Assert.assertEquals(Driver.getDriver().getTitle(),"Account Dashboard - WebstaurantStore");
}

    @Test
    public void testInvalidCredentialsNoUsername() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        new LoginPage().login("", ConfigReader.getProperty("password"));

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("You entered incorrect login information"));

        Assert.assertNotEquals(Driver.getDriver().getTitle(),"Account Dashboard - WebstaurantStore");
    }

    @Test
    public void testInvalidCredentialsNoPassword() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        new LoginPage().login(ConfigReader.getProperty("username"), "");

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("You entered incorrect login information"));

        Assert.assertNotEquals(Driver.getDriver().getTitle(),"Account Dashboard - WebstaurantStore");
    }



}
