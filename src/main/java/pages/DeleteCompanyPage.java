package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCompanyPage {

    WebElement addBtn;


    public DeleteCompanyPage(WebDriver driver, int companyNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+companyNumber+"]/td[4]/button"));


    }

    public void deleteCompanyMethod(){
        this.addBtn.click();
    }
}

