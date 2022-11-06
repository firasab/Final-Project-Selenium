package pages.SearchPages;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebElement search;




    public SearchPage(WebDriver driver) {
        this.search = driver.findElement(By.xpath(Constants.SEARCH_FIELD_XPATH));
    }

    public void searchMethod(String searchText)  {
        this.search.sendKeys(searchText);

    }
}

