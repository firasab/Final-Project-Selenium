package pages.EditPages;

import core.ClearField;
import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

public class EditJobFormatPage {
    WebElement jobName;
    WebElement discription;
    WebElement position;
    WebElement payPerHour;
    WebElement address;
    WebElement image;
    WebElement addBtn;
    WebDriver driver;

    public EditJobFormatPage(WebDriver driver) {
        this.driver = driver;
        jobName = driver.findElement(By.id("jobName"));
        discription = driver.findElement(By.id("discription"));
        position = driver.findElement(By.id("position"));
        payPerHour = driver.findElement(By.id("payPerHour"));
        address = driver.findElement(By.id("address"));
        image = driver.findElement(By.xpath(Constants.EDIT_JOB_XPATH_IMG));
        addBtn = driver.findElement(By.xpath(Constants.EDIT_JOB_XPATH_BTN));
    }

    public void editJobMethod(String jobName, String discription, String position, String payPerHour, String address, String path) throws InterruptedException {
        ClearField clear = new ClearField();
        clear.ClearCompanyField(this.jobName, driver);
        this.jobName.sendKeys(jobName);

        clear.ClearCompanyField(this.discription, driver);
        this.discription.sendKeys(discription);

        clear.ClearCompanyField(this.position, driver);
        this.position.sendKeys(position);

        clear.ClearCompanyField(this.payPerHour, driver);
        this.payPerHour.sendKeys(payPerHour);

        clear.ClearCompanyField(this.address, driver);
        this.address.sendKeys(address);

        File file = new File(path);
        image.sendKeys(file.getAbsolutePath());

        Thread.sleep(5000);
        addBtn.click();
    }
}

