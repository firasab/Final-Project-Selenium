package pages.SendEmail;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailSenderPage {
    WebElement addBtn;


    public EmailSenderPage(WebDriver driver) {
        this.addBtn = driver.findElement(By.xpath(Constants.SEND_EMAIL_XPATH_BTN));
    }

    public void emailSenderPageMethod(){
        this.addBtn.click();
    }
}

