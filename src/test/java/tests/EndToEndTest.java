package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.EndToEndPage;
import pages.SearchBarPage;
import utilities.Driver;
import utilities.FrameworkConstants;

public class EndToEndTest extends TestBase {

    @Test
    public void dispensers() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
    }

    @Test
    public void dropDownSort() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");

    }

    @Test
    public void priceFilter() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");
        new EndToEndPage().priceFilterClick();
    }

    @Test
    public void addToCart() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");
        new EndToEndPage().priceFilterClick();
        new EndToEndPage().lastAddToCartElement();
    }

    @Test
    public void navigatingAddToCart() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");
        new EndToEndPage().priceFilterClick();
        new EndToEndPage().lastAddToCartElement();
        new EndToEndPage().addToCartClick();
    }


    @Test
    public void checkoutTest() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");
        new EndToEndPage().priceFilterClick();
        new EndToEndPage().lastAddToCartElement();
        new EndToEndPage().addToCartClick();
        new EndToEndPage().checkoutButton();
    }

    @Test
    public void checkout(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new EndToEndPage().clickOnDispensers();
        new EndToEndPage().selectSortOption("Rating: Low to High");
        new EndToEndPage().priceFilterClick();
        new EndToEndPage().lastAddToCartElement();
        new EndToEndPage().addToCartClick();
        new EndToEndPage().checkoutButton();
        new CheckoutPage().checkout();

    }
}
