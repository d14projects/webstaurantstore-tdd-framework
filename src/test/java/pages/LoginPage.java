package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }

    @FindBy(xpath = "//span[.='Account']")
    private WebElement accountButton;

    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "the_login_button")
    private WebElement loginButton;


    public void login(){
        accountButton.click();
        signInLink.click();
        emailField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB,
                ConfigReader.getProperty("password"), Keys.ENTER);
        SeleniumUtils.waitFor(5);
    }

    public void login(String username, String password){
        accountButton.click();
        signInLink.click();
        emailField.sendKeys(username, Keys.TAB, password, Keys.ENTER);
        SeleniumUtils.waitFor(5);
    }

}



