package pages.goToFormaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddJobFormat {
    WebElement Create_New_Job;



    public GoToAddJobFormat(WebDriver driver) {
        this.Create_New_Job = driver.findElement(By.linkText("Create New Job"));


    }

    public void goToAddJobFormatMethod() throws InterruptedException {
        this.Create_New_Job.click();
        Thread.sleep(5000);
    }
}

