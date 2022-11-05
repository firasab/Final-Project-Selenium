package pages.ViewPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewCompanyPage {

    WebElement addBtn;


    public ViewCompanyPage(WebDriver driver, int companyNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + companyNumber + "]/td[4]/a[2]"));


    }

    public void viewCompanyMethod(){
        this.addBtn.click();
    }
}

