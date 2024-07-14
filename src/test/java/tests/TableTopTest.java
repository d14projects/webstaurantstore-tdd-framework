package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocatingTabletop;
import utilities.Driver;
import utilities.FrameworkConstants;

import java.util.List;

public class TableTopTest extends TestBase {
    @Test (groups = "smoke")
    public void clickButtonTest() {
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LocatingTabletop().elementClick();
    }

    @Test
    public void verifyText() {
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Clicking on the Table Top Button");
        new LocatingTabletop().elementClick();

        logger.info("Verify if Table top word is displayed");
        new LocatingTabletop().assertElementIsDisplayed();
    }

    @Test
    public void verifyAddToCart() {
        logger.info("Navigate to homepage");
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        logger.info("Clicking on the Table Top Button");
        new LocatingTabletop().elementClick();

        logger.info("Verify Add To Cart buttons");
        new LocatingTabletop().addToCartElementsDisplayed();

        }

        @Test
        public void  addToCart() {
            logger.info("Navigate to homepage");
            Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

            logger.info("Clicking on the Table Top Button");
            new LocatingTabletop().elementClick();

            logger.info("First item add to cart");
            new LocatingTabletop().clickFirstAddToCartElement();
        }
            @Test(groups = "smoke")
            public void verifyCart(){
                logger.info("Navigate to homepage");
                Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

                logger.info("Clicking on the Table Top Button");
                new LocatingTabletop().elementClick();

                logger.info("Locating first element and printing the text");
                new LocatingTabletop().printFirstElementText();

                logger.info("First item add to cart");
                new LocatingTabletop().clickFirstAddToCartElement();

                logger.info("Locate and display element text");
                new LocatingTabletop().getDisplayedElementText();

                logger.info("Match elements names");
                new LocatingTabletop().compareElements();
            }
            }







