package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebElement search;




    public SearchPage(WebDriver driver) {
        this.search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div[2]/div/div/input"));
    }

    public void searchMethod(String searchText)  {
        this.search.sendKeys(searchText);

    }
}

