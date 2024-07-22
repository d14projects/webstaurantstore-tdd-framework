package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDashboardPage {

    public CustomerDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='dashboard__summary-list']")
    private List<WebElement> accountElements;

    public List<String> getDashboardText() {
        List<String> result = new ArrayList<>();
        for (WebElement title : accountElements){
            result.add(title.getText());
            }
        return result;
        }

    public String getEmail() {
        String email = "";
        for (int i = 0; i < accountElements.size(); i++ ){
            if (accountElements.get(i).getText().contains("@"));
            email = accountElements.get(i).getText();
            break;
        }
        return email;
    }

    public String getName() {
        String email = "";
        for (int i = 0; i < accountElements.size(); i++){
            if (accountElements.get(i).getText().contains(ConfigReader.getProperty("name"))){
                email = accountElements.get(i).getText();
                break;
            };
        }
        return email;
    }
}
