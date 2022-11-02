package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToFeaturePage {
    WebElement Feature;



    public GoToFeaturePage(WebDriver driver , String pagePath) {
        this.Feature = driver.findElement(By.linkText(pagePath));


    }

    public void gotoFeaturePageMethod() throws InterruptedException {
        this.Feature.click();
        Thread.sleep(5000);
    }
}

