package pages.ViewPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ViewCompanyPage {
    WebElement addBtn;
    TakeScreenShot takeScr;

    public ViewCompanyPage(WebDriver driver, int companyNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + companyNumber + "]/td[4]/a[2]"));
        takeScr = new TakeScreenShot(driver);
    }

    public void viewCompanyMethod() throws InterruptedException, IOException {
        this.addBtn.click();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"newWorkerProfile.png");
    }
}

