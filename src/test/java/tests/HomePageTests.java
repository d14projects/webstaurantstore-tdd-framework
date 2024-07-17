package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocatingTabletop;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePageTests extends TestBase {

    @Test
    public void clickingOnLogoFromTabletopPage(){

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LocatingTabletop().elementClick();
        new HomePage().clickOnLogo();
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

}
