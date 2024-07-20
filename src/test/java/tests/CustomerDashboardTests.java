package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerDashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

public class CustomerDashboardTests extends TestBase {

    @Test
    public void VerifyDashBoardCustomerInfo(){
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Verify login to Account Dashboard Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Dashboard"));

        logger.info("Verify Account Dashboard contains customer email " + ConfigReader.getProperty("username"));
        Assert.assertTrue(new CustomerDashboardPage().getEmail().contains(ConfigReader.getProperty("username")));

        logger.info("Verify Account Dashboard contains customer full name " + ConfigReader.getProperty("name"));
        Assert.assertTrue(new CustomerDashboardPage().getEmail().contains(ConfigReader.getProperty("name")));
    }

}
