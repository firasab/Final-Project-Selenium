package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteJobApplicationPage {
    WebElement addBtn;

    public DeleteJobApplicationPage(WebDriver driver, int jobApplicationNumber) {
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr["+jobApplicationNumber+"]/td[8]/button"));
    }

    public void deleteJobApplicationMethod(){
        this.addBtn.click();
    }
}

