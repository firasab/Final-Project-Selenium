package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditWorkerFormatPage {

    WebElement workerName;
    WebElement workerID;
    WebElement workerAddress;
    WebElement workerPhoneNumber;
    WebElement workerEmail;
    WebElement workerCompany;

    WebElement dateOfFinishingJob;
   // WebElement image;
    WebElement addBtn;


    public EditWorkerFormatPage(WebDriver driver) {

        this.workerName = driver.findElement(By.id("name"));
        this.workerID = driver.findElement(By.id("id"));
        this.workerAddress = driver.findElement(By.id("location"));
        this.workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        this.workerEmail = driver.findElement(By.id("email"));
        this.workerCompany = driver.findElement(By.id("companyName"));
        this.dateOfFinishingJob = driver.findElement(By.id("mui-3"));
        //this.image = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/div[9]/input"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));



    }

    public void editWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfFinishing) throws InterruptedException {
            this.workerName.clear();
            this.workerName.sendKeys(name);

            this.workerID.clear();
            this.workerID.sendKeys(id);

            this.workerAddress.clear();
            this.workerAddress.sendKeys(address);

            this.workerPhoneNumber.clear();
            this.workerPhoneNumber.sendKeys(phoneNumber);

            this.workerEmail.clear();
            this.workerEmail.sendKeys(email);

            this.workerCompany.clear();
            this.workerCompany.sendKeys(company);

            this.dateOfFinishingJob.clear();
            this.dateOfFinishingJob.sendKeys(dateOfFinishing);

            //this.image.sendKeys(path);
            Thread.sleep(5000);
            this.addBtn.click();

    }
}

