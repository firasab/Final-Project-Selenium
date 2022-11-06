package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCompanyPage {
    WebElement addBtn;

    public EditCompanyPage(WebDriver driver, int companyNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+companyNumber+"]/td[4]/a[1]"));
    }

    public void editCompanyMethod(){
        this.addBtn.click();
    }
}

