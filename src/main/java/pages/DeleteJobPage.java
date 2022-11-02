package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteJobPage {

    WebElement addBtn;


    public DeleteJobPage(WebDriver driver, int jobNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[5]/button"));


    }

    public void deleteJobMethod(){
        this.addBtn.click();
    }
}

