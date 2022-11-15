package pages.ViewPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ViewJobPage {
    WebElement addBtn;
    TakeScreenShot takeScr;

    public ViewJobPage(WebDriver driver, int jobNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + jobNumber + "]/td[5]/a[2]"));
        takeScr = new TakeScreenShot(driver);
    }

    public void viewJobMethod() throws InterruptedException, IOException {
        this.addBtn.click();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"newWorkerProfile.png");
    }
}

