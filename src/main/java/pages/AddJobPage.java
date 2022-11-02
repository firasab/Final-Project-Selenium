package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddJobPage {

    WebElement jobName;
    WebElement jobDiscription;
    WebElement jobPosition;
    WebElement jobPayPerHour;
    WebElement jobAddress;

   // WebElement image;
    WebElement addBtn;


    public AddJobPage(WebDriver driver) {

        this.jobName = driver.findElement(By.id("jobName"));
        this.jobDiscription = driver.findElement(By.id("discription"));
        this.jobPosition = driver.findElement(By.id("position"));
        this.jobPayPerHour = driver.findElement(By.id("payPerHour"));
        this.jobAddress = driver.findElement(By.id("address"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));



    }

    public void addNewJobMethod(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour, String jobAddress) throws InterruptedException {

        this.jobName.sendKeys(jobName);
        this.jobDiscription.sendKeys(jobDiscription);
        this.jobPosition.sendKeys(jobPosition);
        this.jobPayPerHour.sendKeys(jobPayPerHour);
        this.jobAddress.sendKeys(jobAddress);
        Thread.sleep(5000);
        this.addBtn.click();

    }
}

