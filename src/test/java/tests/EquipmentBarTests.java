package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EquipmentBarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

public class EquipmentBarTests extends TestBase {

    @Test (groups = "smoke")
    public void verifyMainEquipmentBarLinks(){

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);

        logger.info("Restaurant Equipment is displayed on Page Title");
        Assert.assertTrue(Driver.getDriver().getTitle().contains(FrameworkConstants.EQUIPMENT_FAMILY));
        }

    @Test
    public void verifySpecificEquipmentCards(){

        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Click on a Feature link: Restaurant Equipment");
        new EquipmentBarPage().clickOnLink(FrameworkConstants.EQUIPMENT_FAMILY);
        SeleniumUtils.waitFor(2);

        logger.info("Enter Card Title: Cooking Equipment and Click");
        String expectedTitle = FrameworkConstants.EQUIPMENT_CARD;
        new EquipmentBarPage().clickOnCard(expectedTitle);

        logger.info("Entered Card title: Cooking Equipment is displayed on Page Title");
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }



}
