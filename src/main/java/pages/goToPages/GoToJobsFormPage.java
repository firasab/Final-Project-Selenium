package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToJobsFormPage {
    WebElement JobsFormPage;



    public GoToJobsFormPage(WebDriver driver) {
        this.JobsFormPage = driver.findElement(By.linkText("Check Jobs Forms"));


    }

    public void goToJobsFormPageMethod() throws InterruptedException {
        this.JobsFormPage.click();
        Thread.sleep(5000);
    }
}

