package pages.EditPages;

import core.ClearField;
import core.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

public class EditWorkerFormatPage {
    WebElement workerName;
    WebElement workerID;
    WebElement workerAddress;
    WebElement workerPhoneNumber;
    WebElement workerEmail;
    WebElement workerCompany;
    WebElement dateOfFinishingJob;
    WebElement image;
    WebElement addBtn;
    WebDriver driver;

    public EditWorkerFormatPage(WebDriver driver) {
        this.driver = driver;
        workerName = driver.findElement(By.id("name"));
        workerID = driver.findElement(By.id("id"));
        workerAddress = driver.findElement(By.id("location"));
        workerPhoneNumber = driver.findElement(By.id("phoneNumber"));
        workerEmail = driver.findElement(By.id("email"));
        workerCompany = driver.findElement(By.id("companyName"));
        dateOfFinishingJob = driver.findElement(By.id("mui-3"));
        image = driver.findElement(By.xpath(Constants.EDIT_WORKER_XPATH_IMG));
        addBtn = driver.findElement(By.xpath(Constants.EDIT_WORKER_XPATH_BTN));
    }


    public void editWorkerMethod(String name, String id, String address, String phoneNumber, String email, String company, String dateOfFinishing, String path) throws InterruptedException {
        Thread.sleep(1000);
        ClearField clear = new ClearField();
        clear.ClearCompanyField(this.workerName, driver);
        workerName.sendKeys(name);

        clear.ClearCompanyField(this.workerID, driver);
        workerID.sendKeys(id);

        clear.ClearCompanyField(this.workerAddress, driver);
        workerAddress.sendKeys(address);

        clear.ClearCompanyField(this.workerPhoneNumber, driver);
        workerPhoneNumber.sendKeys(phoneNumber);

        clear.ClearCompanyField(this.workerEmail, driver);
        workerEmail.sendKeys(email);

        clear.ClearCompanyField(this.workerCompany, driver);
        workerCompany.sendKeys(company);

        dateOfFinishingJob.sendKeys(dateOfFinishing);

        File file = new File(path);
        image.sendKeys(file.getAbsolutePath());

        Thread.sleep(5000);
        addBtn.click();
    }
}

