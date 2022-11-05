package pages.AddPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class AddCompanyPage {

    WebElement companyName;
    WebElement companyField;
    WebElement companyNumberOfWorker;
    WebElement companyAddress;

    WebElement image;
    WebElement addBtn;


    public AddCompanyPage(WebDriver driver) {

        this.companyName = driver.findElement(By.id("companyName"));
        this.companyField = driver.findElement(By.id("field"));
        this.companyNumberOfWorker = driver.findElement(By.id("numberOfWorker"));
        this.companyAddress = driver.findElement(By.id("address"));
        this.image = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/div[5]/input"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));



    }

    public void addNewCompanyMethod(String companyName, String companyField, String companyNumberOfWorker, String companyAddress, String path) throws InterruptedException {

        this.companyName.sendKeys(companyName);
        this.companyField.sendKeys(companyField);
        this.companyNumberOfWorker.sendKeys(companyNumberOfWorker);
        this.companyAddress.sendKeys(companyAddress);
        File file = new File(path);
        this.image.sendKeys(file.getAbsolutePath());
        Thread.sleep(5000);
        this.addBtn.click();

    }
}

