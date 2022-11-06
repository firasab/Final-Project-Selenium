package pages.EditPages;

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

    public void ClearJobField(WebElement worker) {
        Actions actions = new Actions(driver);
        worker.click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
    }

    public void editJobMethod(String jobName, String discription, String position, String payPerHour, String address, String path) throws InterruptedException {
            ClearJobField(this.jobName);
            this.jobName.sendKeys(jobName);

            ClearJobField(this.discription);
            this.discription.sendKeys(discription);

            ClearJobField(this.position);
            this.position.sendKeys(position);

            ClearJobField(this.payPerHour);
            this.payPerHour.sendKeys(payPerHour);

            ClearJobField(this.address);
            this.address.sendKeys(address);

            File file = new File(path);
            image.sendKeys(file.getAbsolutePath());

            Thread.sleep(5000);
            addBtn.click();
    }
}

