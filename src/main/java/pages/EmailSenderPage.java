package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailSenderPage {

    WebElement addBtn;


    public EmailSenderPage(WebDriver driver) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/form/button"));


    }

    public void emailSenderPageMethod(){
        this.addBtn.click();
    }
}

