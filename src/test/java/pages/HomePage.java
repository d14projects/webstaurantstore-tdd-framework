package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

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

@FindBy ( xpath= "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Restaurant Equipment')]")
private WebElement RestaurantEquipment;

@FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Commercial Refrigeration')]")
private WebElement CommercialRefrigeration;

    public WebElement getSmallwares() {
        return Smallwares;
    }

    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Smallwares')]")
    private WebElement Smallwares;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Storage & Transport')]")
    private WebElement StorageAndTransport;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Dinnerware & Tabletop')]")
    private WebElement DinnerwareAndTabletop;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Disposables')]")
    private WebElement Disposables;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Furniture')]")
    private WebElement Furniture;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Industrial Supplies')]")
    private WebElement IndustrialSupplies;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Food & Beverage')]")
    private WebElement FoodAndBeverage;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Janitorial Supplies')]")
    private WebElement JanitorialSupplies;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Parts & Accessories')]")
    private WebElement PartsAndAccessories;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Event Furniture')]")
    private WebElement EventFurniture;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Coffee and Espresso')]")
    private WebElement CoffeeAndEspresso;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Cooking Utensils')]")
    private WebElement CookingUtensils;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Plastic Cups and Lids')]")
    private WebElement PlasticCupsAndLids;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Retail Shelving')]")
    private WebElement RetailShelving;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'Business Type')]")
    private WebElement BusinessType;
    @FindBy (xpath = "//p[@class='text-sm leading-none text-gray-900 group-hover:text-green-500 group-hover:underline mb-0 p-1 transition-all duration-75 ease-in-out mt-2 lt:mt-5' and contains(text(), 'New Items')]")
    private WebElement NewItems;

    @FindBy(xpath="//li[@class='text-center mb-8 group lt:mb-4']")
    private List<WebElement> groupListOfFeaturedCategories;

    public List<String> getTitlesOfFeaturedCategories(){

        List<String> categoriesTitles = new ArrayList<>();
        for (WebElement categories : groupListOfFeaturedCategories){
            categoriesTitles.add(categories.getText());

        }


         return  categoriesTitles;
    }


}
