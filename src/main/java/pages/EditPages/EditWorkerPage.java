package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditWorkerPage {

    WebElement addBtn;


    public EditWorkerPage(WebDriver driver, int workerNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[8]/a[1]"));
    }

    public void editWorkerMethod(){
        this.addBtn.click();
    }
}

