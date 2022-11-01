package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToCreateSchedulePage {
    WebElement CreateSchedule;



    public GoToCreateSchedulePage(WebDriver driver) {
        this.CreateSchedule = driver.findElement(By.linkText("Create Weekly Schedule"));


    }

    public void gotoCreateSchedulePageMethod() throws InterruptedException {
        this.CreateSchedule.click();
        Thread.sleep(5000);
    }
}

