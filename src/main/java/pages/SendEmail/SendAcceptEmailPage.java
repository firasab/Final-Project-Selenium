package pages.SendEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendAcceptEmailPage {
    WebElement addBtn;

    public SendAcceptEmailPage(WebDriver driver, int jobApplicationNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[8]/a[1]"));
    }

    public void sendAcceptEmailPageMethod(){
        this.addBtn.click();
    }
}

