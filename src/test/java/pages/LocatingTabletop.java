package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

@Data
public class LocatingTabletop {
    public LocatingTabletop() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(linkText = "Tabletop")
    private WebElement tabletopButton;
    @FindBy(xpath = "//input[@data-action='addToCart']")
    private List<WebElement> addToCartElements;
    @FindBy(xpath = "//a[@data-label='5515139']")
    private WebElement myElement;
    @FindBy(xpath = "//a[@href='/acopa-16-oz-customizable-mixing-glass-pint-glass-case/5515139.html']")
    private WebElement displayedElement;

    public void elementClick() {
        tabletopButton.click();

    }

    public void assertElementIsDisplayed() {
        Assert.assertTrue(tabletopButton.isDisplayed());
    }

    public void addToCartElementsDisplayed() {
        for (WebElement element : addToCartElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void clickFirstAddToCartElement() {
        if (!addToCartElements.isEmpty()) {
            addToCartElements.get(0).click();
        } else {
            throw new RuntimeException("No Add to Cart elements found");
        }
    }

    public void printFirstElementText() {
        String elementText = myElement.getText();
        System.out.println("First element: " + elementText);
    }

    public String getDisplayedElementText() {
        return displayedElement.getText();
    }

    public void compareElements() {
        String myElementText = myElement.getText();
        String displayedElementText = displayedElement.getText();
        Assert.assertEquals(myElementText, displayedElementText, "The texts of the elements do not match.");
        System.out.println("Both elements have the same text: " + myElementText);
    }
}



