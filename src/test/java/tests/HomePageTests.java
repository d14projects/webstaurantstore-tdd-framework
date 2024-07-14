package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocatingTabletop;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

public class HomePageTests {

    @Test
    public void clickingOnLogoFromTabletopPage(){

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LocatingTabletop().elementClick();
        new HomePage().clickOnLogo();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl() ,ConfigReader.getProperty("url"));
    }
@Test
public void verifyUrlWhenClickingOnLogo(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new HomePage().clickOnLogo();
        SeleniumUtils.waitFor(3);
        Assert.assertEquals(FrameworkConstants.HOMEPAGE_URL, "https://www.webstaurantstore.com/");
}


}
