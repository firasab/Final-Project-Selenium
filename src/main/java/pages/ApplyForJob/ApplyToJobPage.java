package pages.ApplyForJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyToJobPage {
    WebElement apply;

    public ApplyToJobPage(WebDriver driver, int jobNumber) {
        this.apply = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/a"));
    }

    public void getApplyJobsPage() {
        this.apply.click();
    }
}
