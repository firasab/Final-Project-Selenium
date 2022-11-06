package pages.ViewPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewJobPage {
    WebElement addBtn;

    public ViewJobPage(WebDriver driver, int jobNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + jobNumber + "]/td[5]/a[2]"));
    }

    public void viewJobMethod(){
        this.addBtn.click();
    }
}

