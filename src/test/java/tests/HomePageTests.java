package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocatingTabletop;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePageTests extends TestBase {

    @Test
    public void verifyHomePageUrl(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),FrameworkConstants.HOMEPAGE_URL);
    }

    @Test
    public void clickingOnLogoFromTabletopPage(){

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        logger.info("Sign in to user's account");
        new LocatingTabletop().elementClick();
        logger.info("Click on Tabletop tab");
        new HomePage().clickOnLogo();
        logger.info("Click on the Logo to get to Homepage");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl() ,ConfigReader.getProperty("url"));
    }
@Test(groups="smoke")
public void verifyUrlWhenClickingOnLogo(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new HomePage().clickOnLogo();
        SeleniumUtils.waitFor(3);
        Assert.assertEquals(FrameworkConstants.HOMEPAGE_URL, "https://www.webstaurantstore.com/");
}

@Test
public void verifyNumberOfCategories(){

    Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
    List<WebElement> listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));

    List<String> categoriesTitles = new ArrayList<>();
    for (WebElement categories : listOfFeaturedCategories){
        categoriesTitles.add(categories.getText());

    }
    System.out.println(categoriesTitles);
    Assert.assertEquals(categoriesTitles.size(),18);
}

    @Test
    public void clickOnEachCategoryLink() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        List<WebElement> listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));
        List<String> categoriesTitles = new ArrayList<>();

        for (int i = 0; i < listOfFeaturedCategories.size(); i++) {
            listOfFeaturedCategories.get(i).click();
            categoriesTitles.add(Driver.getDriver().getTitle());
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().refresh();
            listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));
        }
        Driver.getDriver().navigate().refresh();
        System.out.println("Print all titles:" + categoriesTitles.toString());
        List<String> expectedTitles = new HomePage().getTitlesOfFeaturedCategories();
        Assert.assertFalse(categoriesTitles.containsAll(expectedTitles));
    }

    @Test
    public void viewBestSellingProducts(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        SeleniumUtils.waitForUrlContains("https://www.webstaurantstore.com/");
//        SeleniumUtils.scrollToElement(new HomePage().getBestSellingNextButton());
        SeleniumUtils.waitFor(5);
        HomePage homePage = new HomePage();
        homePage.clickOnButtons(homePage.getBestSellingNextButton());
        SeleniumUtils.waitFor(5);
        homePage.clickOnButtons(homePage.getBestSellingNextButton());

    }
}

