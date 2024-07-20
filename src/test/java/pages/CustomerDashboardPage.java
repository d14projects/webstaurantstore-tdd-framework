package pages;

import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class CustomerDashboardPage {

    public CustomerDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
