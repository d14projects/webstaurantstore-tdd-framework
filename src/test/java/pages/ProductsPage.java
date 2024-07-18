package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tests.ProductsTests;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='block text-sm leading-none mt-2 hover:underline']")
    private List<WebElement> productLinks;

    public void clickOnProduct(String cardTitle) {
        String link = "";
        for (WebElement el : productLinks) {
            if (el.getText().contains(cardTitle)) {
                link = el.getAttribute("href");
            }
        }
        Driver.getDriver().get(link);
    }

    @FindBy(xpath ="//div[@data-testid='price']")
    private List<WebElement> prices;

//    public List<Double> getRegularPrices() {
//        List<Double> actualPrices = new ArrayList<>();
//
//        for (WebElement price : prices) {
//            if (!price.getText().contains("Sale")) {
//                String each = price.getText().replaceAll("[^0-9.]", "");
//                String[] numbers = each.split("(?<=\\d{1,5}\\.\\d{2})(?=\\d)");
//                for (String number : numbers) {
//                    actualPrices.add(Double.parseDouble(number));
//                }
//            }
//        }
//        return actualPrices;
//    }

    @FindBy(id = "sort_options")
    private WebElement dropdownMenu;

    @FindBy(xpath ="//p[@data-testid='itemSale']")
    private List<WebElement> productsOnSale;

public void verifyContainsText(List<WebElement> list, String keyword){
    for (WebElement el : list){
        Assert.assertTrue(el.getText().contains(keyword));
    }
}


    public List<Double> getRegularPrices() {
        List<Double> actualPrices = new ArrayList<>();

           for (WebElement price : prices) {
            String[] lines = price.getText().split("\n");

            for (String line : lines) {
                if (line.startsWith("$")) {
                    int dollarIndex = line.indexOf('$') + 1;
                    int slashIndex = line.indexOf('/');

                    if (slashIndex != -1) {
                        String result = line.substring(dollarIndex, slashIndex);
                        result = result.replace(",", "");
                        actualPrices.add(Double.parseDouble(result));
                    }
                }
            }
        }
           return actualPrices;
    }


}

