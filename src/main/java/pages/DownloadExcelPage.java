package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadExcelPage {

    WebElement search;




    public DownloadExcelPage(WebDriver driver) {
        this.search = driver.findElement(By.id("test-table-xls-button"));
    }

    public void downloadExcelMethod()  {
        this.search.click();

    }
}

