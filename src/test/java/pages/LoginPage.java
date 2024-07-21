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
import java.util.Random;

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

    private int maxRetry;
    private int attempt;
    private boolean loginSuccesful;

    public void login() {
        accountButton.click();
        SeleniumUtils.waitFor(1);
        signInLink.click();
        SeleniumUtils.waitFor(1);
        emailField.sendKeys(ConfigReader.getProperty("username"));
        SeleniumUtils.waitFor(new Random().nextInt(4)+4);
        passwordField.sendKeys(ConfigReader.getProperty("password"));
        SeleniumUtils.waitFor(new Random().nextInt(4)+2);
        loginButton.click();

        SeleniumUtils.waitFor(1);

        maxRetry = 8;
        attempt = 1;
        loginSuccesful = false;

        if (Driver.getDriver().getCurrentUrl().contains("https://www.webstaurantstore.com/login")) {
            do {
                attempt++;
                try {
                    accountButton.click();
                    SeleniumUtils.waitFor(1);
                    signInLink.click();
                    SeleniumUtils.waitFor(1);
                    emailField.sendKeys(ConfigReader.getProperty("username"));
                    SeleniumUtils.waitFor(new Random().nextInt(4)+3);
                    passwordField.sendKeys(ConfigReader.getProperty("password"));
                    SeleniumUtils.waitFor(new Random().nextInt(4)+4);
                    loginButton.click();
                    SeleniumUtils.waitFor(1);

                    if (Driver.getDriver().getTitle().contains("Dashboard")) {
                        loginSuccesful = true;
                        System.out.println("Successful login at " + attempt + " attempt");
                        break;
                    }
                    if (attempt == maxRetry) {
                        System.out.println("Failed to login after " + maxRetry + " attempts");
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } while (Driver.getDriver().getCurrentUrl().contains("login"));
        }
    }

    public void login(String username, String password){
        accountButton.click();
        SeleniumUtils.waitFor(1);
        signInLink.click();
        SeleniumUtils.waitFor(1);
        emailField.sendKeys(username);
        SeleniumUtils.waitFor(new Random().nextInt(4)+8);
        passwordField.sendKeys(password);
        SeleniumUtils.waitFor(new Random().nextInt(4)+8);
        loginButton.click();
        SeleniumUtils.waitFor(1);
    }

}



