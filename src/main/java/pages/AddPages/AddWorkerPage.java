package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class AddWorkerPage {
    WebElement workerName;
    WebElement workerID;
    WebElement workerAddress;
    WebElement workerPhoneNumber;
    WebElement workerEmail;
    WebElement workerCompany;
    WebElement dateOfStartingJob;
    WebElement dateOfFinishingJob;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;

    public AddWorkerPage(WebDriver driver) {
        this.workerName = driver.findElement(By.id("name"));
        this.workerID = driver.findElement(By.id("id"));
        this.workerAddress = driver.findElement(By.id("location"));
        this.workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        this.workerEmail = driver.findElement(By.id("email"));
        this.workerCompany = driver.findElement(By.id("companyName"));
        this.dateOfStartingJob = driver.findElement(By.id("mui-5"));
        this.dateOfFinishingJob = driver.findElement(By.id("mui-6"));
        this.image = driver.findElement(By.xpath(Constants.ADD_WORKER_XPATH_IMG));
        this.addBtn = driver.findElement(By.xpath(Constants.ADD_WORKER_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void addNewWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfStartingJob, String dateOfFinishingJob,String path) throws InterruptedException, IOException {
        this.workerName.sendKeys(name);
        this.workerID.sendKeys(id);
        this.workerAddress.sendKeys(address);
        this.workerPhoneNumber.sendKeys(phoneNumber);
        this.workerEmail.sendKeys(email);
        this.workerCompany.sendKeys(company);
        this.dateOfStartingJob.sendKeys(dateOfStartingJob);
        this.dateOfFinishingJob.sendKeys(dateOfFinishingJob);
        File file = new File(path);
        this.image.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"workerInformation.png");
        this.addBtn.click();
    }
}

