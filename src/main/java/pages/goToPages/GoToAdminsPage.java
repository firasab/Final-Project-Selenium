package pages.goToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAdminsPage {
    WebElement AdminsPage;



    public GoToAdminsPage(WebDriver driver) {
        this.AdminsPage = driver.findElement(By.linkText("Admins"));


    }

    public void goToAdminsPageMethod() throws InterruptedException {
        this.AdminsPage.click();
        Thread.sleep(5000);
    }
}

