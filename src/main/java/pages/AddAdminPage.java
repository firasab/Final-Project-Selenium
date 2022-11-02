package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAdminPage {

    WebElement adminName;
    WebElement adminEmail;
    WebElement adminID;
    WebElement adminFirstPassWord;
    WebElement adminSecPassWord;
    WebElement addBtn;


    public AddAdminPage(WebDriver driver) {

        this.adminName = driver.findElement(By.id("name"));
        this.adminEmail = driver.findElement(By.id("email"));
        this.adminID = driver.findElement(By.id("id"));
        this.adminFirstPassWord = driver.findElement(By.id("password1"));
        this.adminSecPassWord = driver.findElement(By.id("password2"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/form/div/div[2]/div/div[3]/button"));



    }

    public void addAdminMethod(String adminName, String adminEmail, String adminID, String adminFirstPassWord, String adminSecPassWord) throws InterruptedException {

        this.adminName.sendKeys(adminName);
        this.adminEmail.sendKeys(adminEmail);
        this.adminID.sendKeys(adminID);
        this.adminFirstPassWord.sendKeys(adminFirstPassWord);
        this.adminSecPassWord.sendKeys(adminSecPassWord);
        Thread.sleep(5000);
        this.addBtn.click();

    }
}

