package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LocatingTabletop;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class HomePageTests extends TestBase {

    @Test
    public void verifyHomePageUrl() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), FrameworkConstants.HOMEPAGE_URL);
    }

    @Test
    public void clickingOnLogoFromTabletopPage() {

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        logger.info("Sign in to user's account");
        new LocatingTabletop().elementClick();
        logger.info("Click on Tabletop tab");
        new HomePage().clickOnLogo();
        logger.info("Click on the Logo to get to Homepage");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("url"));
    }

    @Test(groups = "smoke")
    public void verifyUrlWhenClickingOnLogo() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new HomePage().clickOnLogo();
        SeleniumUtils.waitFor(3);
        Assert.assertEquals(FrameworkConstants.HOMEPAGE_URL, "https://www.webstaurantstore.com/");
    }

    @Test
    public void verifyNumberOfCategories() {

        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        List<WebElement> listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));

        List<String> categoriesTitles = new ArrayList<>();
        for (WebElement categories : listOfFeaturedCategories) {
            categoriesTitles.add(categories.getText());

        }
        System.out.println(categoriesTitles);
        Assert.assertEquals(categoriesTitles.size(), 18);
    }

    @Test
    public void clickOnEachCategoryLink() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);

        List<WebElement> listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));
        List<String> categoriesTitles = new ArrayList<>();

        for (int i = 0; i < listOfFeaturedCategories.size(); i++) {
            listOfFeaturedCategories.get(i).click();
            categoriesTitles.add(Driver.getDriver().getTitle());
            Driver.getDriver().navigate().back();
            Driver.getDriver().navigate().refresh();
            listOfFeaturedCategories = Driver.getDriver().findElements(By.xpath("//li[@class='text-center mb-8 group lt:mb-4']"));
        }
        Driver.getDriver().navigate().refresh();
        System.out.println("Print all titles:" + categoriesTitles.toString());
        List<String> expectedTitles = new HomePage().getTitlesOfFeaturedCategories();
        Assert.assertFalse(categoriesTitles.containsAll(expectedTitles));
    }

    @Test
    public void viewBestSellingProducts() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        SeleniumUtils.waitForUrlContains("https://www.webstaurantstore.com/");
//        SeleniumUtils.scrollToElement(new HomePage().getBestSellingNextButton());
        SeleniumUtils.waitFor(5);
        HomePage homePage = new HomePage();
        homePage.clickOnButtons(homePage.getBestSellingNextButton());
        SeleniumUtils.waitFor(5);
        homePage.clickOnButtons(homePage.getBestSellingNextButton());

    }


    @Test
    public void clickOnHeaderLogo() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        LoginPage login = new LoginPage();
        login.login();
        SeleniumUtils.waitFor(1);
        login.getHeadLogo().click();
        System.out.println(Driver.getDriver().getCurrentUrl());
    }
    @Test
    public void hoverNavigationBarElement(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        SeleniumUtils.hover(new HeaderPage().getFoodAndBeverage());
        SeleniumUtils.waitFor(3);
    }

    @Test
    public void addToCartLowestBestSellingItem() {
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        LoginPage login = new LoginPage();
        login.login();
        logger.info("Sign in to account with valid credentials");
        SeleniumUtils.waitFor(1);
        login.clickHeadLogo();
        logger.info("Navigate to Main Page clicking on the HeadLogo");
        SeleniumUtils.waitForUrlContains("https://www.webstaurantstore.com/");

        HomePage myTest = new HomePage();
        boolean hasProducts = true;
        Map<Double, WebElement> priceToElementMap = new HashMap<>();
        List<String> pricesOfBestSellingProducts = new ArrayList<>();
        while (hasProducts) {
            for (WebElement product : myTest.getBestSellingProducts()) {
                if (product.isDisplayed()) {
                    pricesOfBestSellingProducts.add(product.getText());
                }
            }

            if (myTest.getBestSellingNextButton().isDisplayed()) {
                myTest.getBestSellingNextButton().click();
                SeleniumUtils.waitFor(2);
            } else {
                hasProducts = false;

            }
        }
        System.out.println(pricesOfBestSellingProducts.size() + "," + pricesOfBestSellingProducts);
        logger.info("Collected prices to the String list");
        List<String> prices = new ArrayList<>();
        for (String price : pricesOfBestSellingProducts) {
            prices.add(price.replace("$", "").replace(",", "").replace("\\s ", "").split("/")[0]);
        }
        System.out.println(prices);
        logger.info("Removed '$' and ',' , '\\s' ");
        List<Double> doublePrices = prices.stream()
                .filter(price -> !price.trim().isEmpty()) // Filter out empty strings
                .map(price -> {
                    try {
                        return Double.parseDouble(price); // Convert to Double
                    } catch (NumberFormatException e) {
                        return null; // Return null for invalid numbers
                    }
                })
                .filter(price -> price != null) // Filter out null values
                .collect(Collectors.toList()); // Collect to List<Double>
        logger.info("Converted String to Double");


        Collections.sort(doublePrices);
        System.out.println("Sorted prices ascending order:  "+ doublePrices);
        logger.info("Sorted prices ascending order:  " + prices);
        System.out.println("The Lowest cost is : $" + doublePrices.get(0));
        Double lowestPrice = doublePrices.get(0);
    }

        }




