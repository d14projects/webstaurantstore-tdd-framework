package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.List;

public class LoginTests extends TestBase {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
@Test (groups = "smoke")
public void testValidCredentials() {

    logger.info("Navigate to homepage");
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    logger.info("Enter valid credentials and click login");
    new LoginPage().login();

    logger.info("Verify login to Account Dashboard Page");
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Dashboard"));
}

    @Test (groups = "smoke")
    public void testInvalidCredentials() {

    logger.info("Navigate to homepage");
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    logger.info("Enter invalid credentials and click login");
    new LoginPage().login("invalid@email.com", "invalid");

    logger.info("Verify unsuccessful login by page title \"Sign In or Create an Account!\"");
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Sign In or Create an Account!"));
}

    @Test (groups = "smoke")
    public void testInvalidCredentialsNoUsername() {

    logger.info("Navigate to homepage");
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    logger.info("Enter credentials (empty username field, valid password) and click login");
    new LoginPage().login("", ConfigReader.getProperty("password"));

    logger.info("Verify unsuccessful login by page title \"Sign In or Create an Account!\"");
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Sign In or Create an Account!"));
 }

    @Test
    public void testInvalidCredentialsNoPassword() {

    logger.info("Navigate to homepage");
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    logger.info("Enter credentials (valid username, empty password field) and click login");
    new LoginPage().login(ConfigReader.getProperty("username"), "");

    logger.info("Verify unsuccessful login by page title \"Sign In or Create an Account!\"");
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Sign In or Create an Account!"));
}

    @Test
    public void testInvalidCredentialsNoCredentials() {

    logger.info("Navigate to homepage");
    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

    logger.info("Enter credentials (empty username and password fields) and click login");
    new LoginPage().login("", "");

    logger.info("Verify unsuccessful login by page title \"Sign In or Create an Account!\"");
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Sign In or Create an Account!"));
}

}
