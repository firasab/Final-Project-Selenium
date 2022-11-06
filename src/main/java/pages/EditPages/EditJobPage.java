package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditJobPage {
    WebElement addBtn;

    public EditJobPage(WebDriver driver, int jobNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[5]/a[1]"));
    }

    public void editJobMethod(){
        this.addBtn.click();
    }
}

