package pages;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;
@Data
public class SearchBarPage {


        public SearchBarPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//input[@data-testid='searchval']")
        private WebElement searchInput;

        @FindBy(xpath = "//button[@type='submit']")
        private WebElement searchButton;


        @FindBy(xpath = "//div[contains(text(), 'Forks')]")
        private List<WebElement> searchResults;

        public void searchForItem(String item) {
            searchInput.sendKeys(item);
            searchButton.click();
        }

        public void assertSearchResultsContain(String keyword) {
            for (WebElement result : searchResults) {
                Assert.assertTrue(result.getText().contains(keyword), "Search result does not contain the keyword: " + keyword);
            }
        }
        public Object[][] searchData(){
            return new Object[][]{
                    {"plates"},
                    {"cups"},
                    {"tables"}
            };
        }

        }


