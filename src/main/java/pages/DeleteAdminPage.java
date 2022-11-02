package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteAdminPage {

    WebElement addBtn;


    public DeleteAdminPage(WebDriver driver, int adminNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/td[2]/button"));


    }

    public void deleteAdminMethod(){
        this.addBtn.click();
    }
}

