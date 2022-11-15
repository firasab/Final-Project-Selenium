package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AddAdminPage {
    WebElement adminName;
    WebElement adminEmail;
    WebElement adminID;
    WebElement adminFirstPassWord;
    WebElement adminSecPassWord;
    WebElement addBtn;
    TakeScreenShot takeScr;

    public AddAdminPage(WebDriver driver) {

        adminName = driver.findElement(By.id("name"));
        adminEmail = driver.findElement(By.id("email"));
        adminID = driver.findElement(By.id("id"));
        adminFirstPassWord = driver.findElement(By.id("password1"));
        adminSecPassWord = driver.findElement(By.id("password2"));
        addBtn = driver.findElement(By.xpath(Constants.ADD_ADMIN_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void addAdminMethod(String adminName, String adminEmail, String adminID, String adminFirstPassWord, String adminSecPassWord) throws InterruptedException, IOException {
        this.adminName.sendKeys(adminName);
        this.adminEmail.sendKeys(adminEmail);
        this.adminID.sendKeys(adminID);
        this.adminFirstPassWord.sendKeys(adminFirstPassWord);
        this.adminSecPassWord.sendKeys(adminSecPassWord);
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"adminInformation.png");
        this.addBtn.click();
    }
}

