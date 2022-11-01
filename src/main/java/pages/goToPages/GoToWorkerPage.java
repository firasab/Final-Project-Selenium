package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToWorkerPage {
    WebElement Workers;



    public GoToWorkerPage(WebDriver driver) {
        this.Workers = driver.findElement(By.linkText("Workers"));


    }

    public void gotoWorkerPageMethod() throws InterruptedException {
        this.Workers.click();
        Thread.sleep(5000);
    }
}

