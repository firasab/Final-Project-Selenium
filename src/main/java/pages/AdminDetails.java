package pages;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDetails {
    WebElement Name;
    WebElement Email;


    public AdminDetails(WebDriver driver, int adminNumber) {


        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/th"));
        this.Email = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/td[1]"));

    }

}

