package pages.GoToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToFeaturePage {
    WebElement Feature;
    WebDriver driver;

    public GoToFeaturePage(WebDriver driver , String pagePath) {
        this.driver = driver;
        this.Feature = driver.findElement(By.linkText(pagePath));
    }

    public void gotoFeaturePageMethod() throws InterruptedException {
        this.Feature.click();
        Thread.sleep(5000);
    }
}

