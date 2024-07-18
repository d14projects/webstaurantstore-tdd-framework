package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.Driver;
import utilities.FrameworkConstants;

public class LoggedInUserPurchase extends TestBase {

    @Test
    public void searchOnEquipmentBar(){

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        new LoginPage().login();


        System.out.println(Driver.getDriver().getTitle());


    }
}
