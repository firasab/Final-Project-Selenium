package pages.SendEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendRejectEmailPage {

    WebElement addBtn;


    public SendRejectEmailPage(WebDriver driver, int jobApplicationNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[8]/a[2]"));


    }

    public void SendRejectEmailPageMethod(){
        this.addBtn.click();
    }
}

