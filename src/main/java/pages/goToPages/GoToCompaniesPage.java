package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToCompaniesPage {
    WebElement Companies;



    public GoToCompaniesPage(WebDriver driver) {
        this.Companies = driver.findElement(By.linkText("Companies"));


    }

    public void gotoCompaniesMethod() throws InterruptedException {
        this.Companies.click();
        Thread.sleep(5000);
    }
}

