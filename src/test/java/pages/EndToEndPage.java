package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

@Data
public class EndToEndPage {
    public EndToEndPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='tabpanel0']")
    private WebElement dispensersReceptacles;

    @FindBy(id="sort_options")
    private  WebElement sortOptionsDropdown;


   @FindBy(linkText = "$50 and below")
   private WebElement priceFilter;

    @FindBy(xpath = "//input[@data-action='addToCart']")
    private List<WebElement> addToCartElements;

    @FindBy(id="cartItemCountSpan")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@class='standardCheckoutButton btn btn-checkout btn-checkout-continue btn-jumbo btn-large btn-checkout__disabled-state']")
    private WebElement checkout;




    public void clickOnDispensers(){
        By locator= By.xpath("//div[@id='tabpanel0']");
        SeleniumUtils.fluentWait(dispensersReceptacles,12,2);
        dispensersReceptacles.click();
        }

    public void selectSortOption(String visibleText) {
        Select dropdown = new Select(sortOptionsDropdown);
        dropdown.selectByVisibleText(visibleText);
    }

    public void priceFilterClick()  {
        SeleniumUtils.scroll(0,400);
       //SeleniumUtils.waitForVisibility(priceFilter, 15);
        priceFilter.click();
    }
    public void lastAddToCartElement() {
        if (!addToCartElements.isEmpty()) {
            addToCartElements.get(addToCartElements.size()-1).click();
        } else {
            throw new RuntimeException("No Add to Cart elements found");
        }
    }
    public void addToCartClick(){
        addToCart.click();
    }

    public void checkoutButton(){
        checkout.click();
    }


    }




