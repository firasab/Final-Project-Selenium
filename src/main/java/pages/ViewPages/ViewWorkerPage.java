package pages.ViewPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ViewWorkerPage {
    WebElement addBtn;
    TakeScreenShot takeScr;

    public ViewWorkerPage(WebDriver driver, int workerNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[8]/a[2]"));
        takeScr = new TakeScreenShot(driver);

    }

    public void viewWorkerMethod() throws IOException, InterruptedException {
        this.addBtn.click();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"newWorkerProfile.png");
    }
}

