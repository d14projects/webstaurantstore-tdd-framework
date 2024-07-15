package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

@Data
public class EquipmentBarPage {

    public EquipmentBarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnLink(String textOfTheLink) {
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }

    @FindBy(xpath = "//a[@class='font-semibold text-sm text-center xs:text-xl xs:mb-1 xs:text-left sm:leading-snug']")
    private List<WebElement> cardElements;

    public void clickOnCard(String cardTitle) {
        String link = "";
        for (WebElement el : cardElements) {
            if (el.getText().contains(cardTitle)) {
                 link = el.getAttribute("href");
            }
        }
        Driver.getDriver().get(link);
    }

}
