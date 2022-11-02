package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddFeatureFormat {
    WebElement Create_New_Feature;



    public GoToAddFeatureFormat(WebDriver driver, String linkTextPath) {
        //this.Create_New_Company = driver.findElement(By.linkText("Create New Copmany"));
        this.Create_New_Feature = driver.findElement(By.linkText(linkTextPath));


    }

    public void goToAddFeatureFormatMethod() throws InterruptedException {
        this.Create_New_Feature.click();
        Thread.sleep(5000);
    }
}

