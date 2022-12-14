package pages.ApplyForJob;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class ApplyToJobFormatPage {
    WebElement name;
    WebElement jobName;
    WebElement id;
    WebElement phone;
    WebElement address;
    WebElement email;
    WebElement description;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;


    public ApplyToJobFormatPage(WebDriver driver) {
        this.name = driver.findElement(By.id("name"));
        this.jobName = driver.findElement(By.id("jobName"));
        this.id = driver.findElement(By.id("id"));
        this.phone = driver.findElement(By.id("phone"));
        this.address = driver.findElement(By.id("address"));
        this.email = driver.findElement(By.id("email"));
        this.description = driver.findElement(By.id("description"));
        this.image = driver.findElement(By.xpath(Constants.APPLY_TO_JOB_XPATH_IMG));
        this.addBtn = driver.findElement(By.xpath(Constants.APPLY_TO_JOB_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void applyToJobFormatPageMethod(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException, IOException {
        this.name.sendKeys(name);
        this.jobName.sendKeys(jobName);
        this.id.sendKeys(id);
        this.phone.sendKeys(phone);
        this.address.sendKeys(address);
        this.email.sendKeys(email);
        this.description.sendKeys(description);
        File file = new File(path);
        this.image.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobApplyingInformation.png");
        this.addBtn.click();
    }
}

