package pages.goToFormaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddWorkerFormat {
    WebElement Create_New_Worker;



    public GoToAddWorkerFormat(WebDriver driver) {
        this.Create_New_Worker = driver.findElement(By.linkText("Create New Wokrer"));


    }

    public void goToAddWorkerFormatMethod() throws InterruptedException {
        this.Create_New_Worker.click();
        Thread.sleep(5000);
    }
}

