package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

public class CustomerDashboardTests extends TestBase {

    @Test
    public void VerifyDashBoardInfo(){
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Verify login to Account Dashboard Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Dashboard"));

        SeleniumUtils.waitFor(2);


        Driver.getDriver().findElement(By.xpath("//div[@class='account__section-innerdashboard clearfix']")).getText();




    }

}
