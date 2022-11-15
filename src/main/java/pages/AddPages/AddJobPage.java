package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class AddJobPage {
    WebElement jobName;
    WebElement jobDiscription;
    WebElement jobPosition;
    WebElement jobPayPerHour;
    WebElement jobAddress;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;


    public AddJobPage(WebDriver driver) {
        this.jobName = driver.findElement(By.id("jobName"));
        this.jobDiscription = driver.findElement(By.id("discription"));
        this.jobPosition = driver.findElement(By.id("position"));
        this.jobPayPerHour = driver.findElement(By.id("payPerHour"));
        this.jobAddress = driver.findElement(By.id("address"));
        this.image = driver.findElement(By.xpath(Constants.ADD_JOB_XPATH_IMG));
        this.addBtn = driver.findElement(By.xpath(Constants.ADD_JOB_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void addNewJobMethod(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour, String jobAddress, String path) throws InterruptedException, IOException {
        this.jobName.sendKeys(jobName);
        this.jobDiscription.sendKeys(jobDiscription);
        this.jobPosition.sendKeys(jobPosition);
        this.jobPayPerHour.sendKeys(jobPayPerHour);
        this.jobAddress.sendKeys(jobAddress);
        File file = new File(path);
        this.image.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobInformation.png");
        this.addBtn.click();
    }
}

