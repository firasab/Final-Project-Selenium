package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToJobsPage {
    WebElement Jobs;



    public GoToJobsPage(WebDriver driver) {
        this.Jobs = driver.findElement(By.linkText("Jobs"));


    }

    public void gotoJobsPageMethod() throws InterruptedException {
        this.Jobs.click();
        Thread.sleep(5000);
    }
}

