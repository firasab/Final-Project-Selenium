package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class AddCompanyPage {
    WebElement companyName;
    WebElement companyField;
    WebElement companyNumberOfWorker;
    WebElement companyAddress;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;


    public AddCompanyPage(WebDriver driver) {
        this.companyName = driver.findElement(By.id("companyName"));
        this.companyField = driver.findElement(By.id("field"));
        this.companyNumberOfWorker = driver.findElement(By.id("numberOfWorker"));
        this.companyAddress = driver.findElement(By.id("address"));
        this.image = driver.findElement(By.xpath(Constants.ADD_COMPANY_XPATH_IMG));
        this.addBtn = driver.findElement(By.xpath(Constants.ADD_COMPANY_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void addNewCompanyMethod(String companyName, String companyField, String companyNumberOfWorker, String companyAddress, String path) throws InterruptedException, IOException {
        this.companyName.sendKeys(companyName);
        this.companyField.sendKeys(companyField);
        this.companyNumberOfWorker.sendKeys(companyNumberOfWorker);
        this.companyAddress.sendKeys(companyAddress);
        File file = new File(path);
        this.image.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"companyInformation.png");
        this.addBtn.click();
    }
}

