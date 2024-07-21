package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerDashboardPage;
import pages.EquipmentBarPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerDashboardTests extends TestBase {

    @Test (groups = "smoke")
    public void VerifyCustomerEmail(){
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Verify login to Account Dashboard Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Dashboard"));

        logger.info("Verify Account Dashboard contains customer email " + ConfigReader.getProperty("username"));
        Assert.assertTrue(new CustomerDashboardPage().getEmail().contains(ConfigReader.getProperty("username")));
    }

    @Test (groups = "smoke")
    public void VerifyCustomerName(){
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Verify login to Account Dashboard Page");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Dashboard"));

        logger.info("Verify Account Dashboard contains customer full name " + ConfigReader.getProperty("name"));
        Assert.assertTrue(new CustomerDashboardPage().getEmail().contains(ConfigReader.getProperty("name")));
    }

    @Test
    public void verifyMainEquipmentBarOptions(){

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);

        logger.info("Restaurant Equipment is displayed on Page Title");
        Assert.assertTrue(Driver.getDriver().getTitle().contains(FrameworkConstants.EQUIPMENT_FAMILY));
    }


    @Test
    public void verifyProducts() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);

        logger.info("Click on Product: " + FrameworkConstants.PRODUCT_NAME);
        new ProductsPage().clickOnProduct(FrameworkConstants.PRODUCT_NAME);
        SeleniumUtils.waitFor(1);

        logger.info("Verify page title contains: " + FrameworkConstants.PRODUCT_NAME);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(FrameworkConstants.PRODUCT_NAME));
    }


    @Test (groups = "smoke")
    public void verifyPriceFilterLowToHigh() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);

        logger.info("Click on Product: " + FrameworkConstants.PRODUCT_NAME);
        new ProductsPage().clickOnProduct(FrameworkConstants.PRODUCT_NAME);
        SeleniumUtils.waitFor(1);

        logger.info("Select Price: Low to High Filter from the Dropdown Menu");
        Select priceDropdown = new Select(new ProductsPage().getDropdownMenu());
        priceDropdown.selectByVisibleText("Price: Low to High");
        SeleniumUtils.waitFor(1);

        logger.info("Get the list of Actual Prices after Filter Applied");
        List<Double> actualPrices = new ProductsPage().getRegularPrices();

        System.out.println(new ProductsPage().getRegularPrices());

        logger.info("Sort the Expected Prices list in Natural Order");
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.naturalOrder());

        System.out.println(expectedPrices);

        logger.info("Verify Actual Prices equals Expected Prices"); //bug
        Assert.assertEquals(actualPrices, expectedPrices);
    }

    @Test //bug
    public void verifyPriceFilterHighToLow() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Enter valid credentials and click login");
        new LoginPage().login();

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);

        logger.info("Click on Product: " + FrameworkConstants.PRODUCT_NAME);
        new ProductsPage().clickOnProduct(FrameworkConstants.PRODUCT_NAME);
        SeleniumUtils.waitFor(1);

        logger.info("Select Price: High to Low Filter from the Dropdown Menu");
        Select priceDropdown = new Select(new ProductsPage().getDropdownMenu());
        priceDropdown.selectByVisibleText("Price: High to Low");
        SeleniumUtils.waitFor(1);

        logger.info("Get the list of Actual Prices after Filter Applied");
        List<Double> actualPrices = new ProductsPage().getRegularPrices();

        System.out.println(new ProductsPage().getRegularPrices());

        logger.info("Sort the Expected Prices list in Natural Order");
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.reverseOrder());

        System.out.println(expectedPrices);

        logger.info("Verify Actual Prices equals Expected Prices"); //bug
        Assert.assertEquals(actualPrices, expectedPrices);
    }



}
