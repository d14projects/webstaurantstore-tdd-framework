package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EquipmentBarPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductsTests extends TestBase{

    @Test (groups = "smoke")
    public void verifyPriceFilterLowToHigh() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Click on a link on a Equipment Bar: " + ConfigReader.getProperty("equipmentFamily"));
        new EquipmentBarPage().clickOnLink(ConfigReader.getProperty("equipmentFamily"));
        SeleniumUtils.waitFor(2);

        logger.info("Enter Card Title: " + ConfigReader.getProperty("equipmentCard") + " and Click");
        String expectedTitle = ConfigReader.getProperty("equipmentCard");
        new EquipmentBarPage().clickOnCard(expectedTitle);

        logger.info("Click on Product: " + ConfigReader.getProperty("productName"));
        new ProductsPage().clickOnProduct(ConfigReader.getProperty("productName"));

        logger.info("Select Price: Low to High Filter from the Dropdown Menu");
        Select priceDropdown = new Select(new ProductsPage().getDropdownMenu());
        priceDropdown.selectByVisibleText("Price: Low to High");
        SeleniumUtils.waitFor(1);

        logger.info("Get the list of Actual Prices after Filter Applied");
        List<Double> actualPrices = new ProductsPage().getRegularPrices();

        logger.info("Sort the Expected Prices list in Natural Order");
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.naturalOrder());

        logger.info("Verify Actual Prices equals Expected Prices");
        Assert.assertEquals(actualPrices, expectedPrices);

        System.out.println("Filter Applied - Actual Prices: " + actualPrices);
        System.out.println("Sorted Natural - Expect Prices: " + expectedPrices);
    }

    @Test
    public void verifyPriceFilterHighToLow() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Click on a link on a Equipment Bar: " + ConfigReader.getProperty("equipmentFamily"));
        new EquipmentBarPage().clickOnLink(ConfigReader.getProperty("equipmentFamily"));
        SeleniumUtils.waitFor(2);

        logger.info("Enter Card Title: " + ConfigReader.getProperty("equipmentCard") + " and Click");
        String expectedTitle = ConfigReader.getProperty("equipmentCard");
        new EquipmentBarPage().clickOnCard(expectedTitle);

        logger.info("Click on Product: " + ConfigReader.getProperty("productName"));
        new ProductsPage().clickOnProduct(ConfigReader.getProperty("productName"));

        logger.info("Select Price: High to Low Filter from the Dropdown Menu");
        Select priceDropdown = new Select(new ProductsPage().getDropdownMenu());
        priceDropdown.selectByVisibleText("Price: High to Low");
        SeleniumUtils.waitFor(1);

        logger.info("Get the list of Actual Prices after Filter Applied");
        List<Double> actualPrices = new ProductsPage().getRegularPrices();

        logger.info("Sort the Expected Prices list in Reverse Order");
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.reverseOrder());

        logger.info("Verify Actual Prices equals Expected Prices");
        Assert.assertEquals(actualPrices, expectedPrices);

        System.out.println("Filter Applied - Actual Prices: " + actualPrices);
        System.out.println("Sorted Natural - Expect Prices: " + expectedPrices);

    }

    @Test (groups = "smoke")
    public void verifyProductsOnDiscount() {

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Click on a link on a Equipment Bar: " + ConfigReader.getProperty("equipmentFamily"));
        new EquipmentBarPage().clickOnLink(ConfigReader.getProperty("equipmentFamily"));
        SeleniumUtils.waitFor(2);

        logger.info("Enter Card Title: " + ConfigReader.getProperty("equipmentCard") + " and Click");
        String expectedTitle = ConfigReader.getProperty("equipmentCard");
        new EquipmentBarPage().clickOnCard(expectedTitle);

        logger.info("Click on Product: " + ConfigReader.getProperty("productName"));
        new ProductsPage().clickOnProduct(ConfigReader.getProperty("productName"));

        logger.info("Verify products on sale contain word: \"Sale\"");
        new ProductsPage().verifyContainsText(new ProductsPage().getProductsOnSale(), "Sale");
    }

    }
