package pages.ViewPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewWorkerPage {
    WebElement addBtn;

    public ViewWorkerPage(WebDriver driver, int workerNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[8]/a[2]"));
    }

    public void viewWorkerMethod(){
        this.addBtn.click();
    }
}

