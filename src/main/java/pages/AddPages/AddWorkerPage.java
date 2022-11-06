package pages.AddPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;

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

    public AddWorkerPage(WebDriver driver) {
        this.workerName = driver.findElement(By.id("name"));
        this.workerID = driver.findElement(By.id("id"));
        this.workerAddress = driver.findElement(By.id("location"));
        this.workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        this.workerEmail = driver.findElement(By.id("email"));
        this.workerCompany = driver.findElement(By.id("companyName"));
        this.dateOfStartingJob = driver.findElement(By.id("mui-5"));
        this.dateOfFinishingJob = driver.findElement(By.id("mui-6"));
        this.image = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/div[9]/input"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));
    }

    public void addNewWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfStartingJob, String dateOfFinishingJob,String path) throws InterruptedException {
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
        this.addBtn.click();
    }
}

