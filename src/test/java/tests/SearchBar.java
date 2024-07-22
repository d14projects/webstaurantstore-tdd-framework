package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchBarPage;
import utilities.DataProviderSearchBar;
import utilities.Driver;
import utilities.FrameworkConstants;

import java.util.List;

public class SearchBar extends TestBase {

    @Test
    public void searchBar() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new SearchBarPage().searchForItem("fork");
    }

    @Test(groups = "smoke")
    public void results() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new SearchBarPage().searchForItem("forks");
        new SearchBarPage().assertSearchResultsContain("forks");
    }

    @Test(groups = "smoke")
    public void dropDownButton() throws InterruptedException {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new SearchBarPage().searchForItem("forks");
        Select makeDropdown = new Select(Driver.getDriver().findElement(By.id("sort_options")));
        makeDropdown.selectByVisibleText("Price: Low to High");
        Thread.sleep(5000);
    }

    @Test
    public void results2() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new SearchBarPage().searchForItem("table");
        new SearchBarPage().assertSearchResultsContain("table");
    }
    @Test(dataProvider = "searchData", dataProviderClass = DataProviderSearchBar.class)
    public void searchBar2(String searchTerm, String expectedKeyword){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new SearchBarPage().searchForItem(searchTerm);
        new SearchBarPage().assertSearchResultsContain(expectedKeyword);

    }
}




