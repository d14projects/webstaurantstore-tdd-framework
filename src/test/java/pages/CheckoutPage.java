package pages;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.security.Key;
import java.util.concurrent.ScheduledExecutorService;

@Data
public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "BillingAddress.Name")
    private WebElement addressName;

    @FindBy(id = "BillingAddress.Company")
    private WebElement addressCompany;

    @FindBy(id = "BillingAddress.AddressLine1")
    private WebElement addressline1;

    @FindBy(id = "BillingAddress.AddressLine2")
    private WebElement addressline2;

    @FindBy(id = "BillingAddress.CountryCode")
    private WebElement addressCountry;

    @FindBy(id = "BillingAddress.PostalCode")
    private WebElement addressPostal;

    @FindBy(id = "BillingAddress.CityStateFromZipe")
    private WebElement addressCity;

    @FindBy(id = "continue_to_payment")
    private WebElement payment;




    public void checkout() {
        email.sendKeys(ConfigReader.getProperty("email"), Keys.TAB, Keys.TAB,ConfigReader.getProperty("name"), Keys.TAB,
                ConfigReader.getProperty("company"), Keys.TAB, ConfigReader.getProperty("address"), Keys.TAB,
                ConfigReader.getProperty("address2"),Keys.TAB,Keys.TAB, ConfigReader.getProperty("zip"),Keys.TAB,
        ConfigReader.getProperty("phone"));
        SeleniumUtils.waitFor(2);
        payment.click();
        SeleniumUtils.waitFor(2);
    }
}
