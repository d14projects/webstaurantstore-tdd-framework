package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
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

}
