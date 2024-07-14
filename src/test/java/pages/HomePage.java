package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//a[@class='hidden lt:block w-full xxl:w-auto']")
private WebElement logo;

public void clickOnLogo(){
    logo.click();
}
   // private WebElement RestaurantEquipment;

}
