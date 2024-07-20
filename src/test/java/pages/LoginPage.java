package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

@Data
public class LoginPage extends HeaderPage{

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

    @FindBy(xpath = "//button[@class='close opacity-100 hover:text-gray-500']")
    private WebElement closeAlertButtonProblem;

    @FindBy(xpath = "//button[@onclick='closeAlert(this)']")
    private WebElement closeAlertButtonEmail;

    public void login(){
        accountButton.click();
        signInLink.click();
        emailField.sendKeys(ConfigReader.getProperty("username"));
        passwordField.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();

       SeleniumUtils.waitFor(2);

        if (closeAlertButtonProblem.isEnabled()){
            SeleniumUtils.jsClick(closeAlertButtonProblem);
            passwordField.sendKeys(ConfigReader.getProperty("password"));
            loginButton.click();
        } else if (closeAlertButtonEmail.isEnabled()){
            SeleniumUtils.jsClick(closeAlertButtonEmail);
            passwordField.sendKeys(ConfigReader.getProperty("password"));
            loginButton.click();
        }
        SeleniumUtils.waitFor(1);
    }

    public void login(String username, String password){
        accountButton.click();
        signInLink.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        SeleniumUtils.waitFor(1);
        if (closeAlertButtonProblem.isEnabled()){
            SeleniumUtils.jsClick(closeAlertButtonProblem);
            passwordField.sendKeys(password);
            loginButton.click();
        } else if (closeAlertButtonEmail.isEnabled()){
            SeleniumUtils.jsClick(closeAlertButtonEmail);
            passwordField.sendKeys(password);
            loginButton.click();
        }
        SeleniumUtils.waitFor(3);
    }

}



