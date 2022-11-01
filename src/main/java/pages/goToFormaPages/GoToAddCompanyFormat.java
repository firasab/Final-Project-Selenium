package pages.goToFormaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddCompanyFormat {
    WebElement Create_New_Company;



    public GoToAddCompanyFormat(WebDriver driver) {
        this.Create_New_Company = driver.findElement(By.linkText("Create New Copmany"));


    }

    public void goToAddCompanyFormatMethod() throws InterruptedException {
        this.Create_New_Company.click();
        Thread.sleep(5000);
    }
}

