package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

@Data
public class HeaderPage {
    public HeaderPage() {PageFactory.initElements(Driver.getDriver(), this); }


    @FindBy(xpath = "//a[@class='hidden lt:block w-full xxl:w-auto']")
    private WebElement headLogo;
    public void clickHeadLogo(){
    headLogo.click();
    }

    @FindBy(xpath= "//nav[@data-testid='flyout-nav']//div[@data-testid='nav-full-data-items']//a[@aria-haspopup='true'][4]")
    private WebElement foodAndBeverage;

}
