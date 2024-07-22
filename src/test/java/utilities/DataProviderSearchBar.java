package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderSearchBar {
    @DataProvider(name="searchData")
    public static Object[][]searchData(){
        return new Object[][] {
                { "forks", "fork" },
                { "cups", "cup" },
                { "plates", "plate" }
        };
    }
}



