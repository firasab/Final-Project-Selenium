package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyToJobFormatPage {

    WebElement name;
    WebElement jobName;
    WebElement id;
    WebElement phone;
    WebElement address;
    WebElement email;
    WebElement description;

    WebElement addBtn;


    public ApplyToJobFormatPage(WebDriver driver) {

        this.name = driver.findElement(By.id("name"));
        this.jobName = driver.findElement(By.id("jobName"));
        this.id = driver.findElement(By.id("id"));
        this.phone = driver.findElement(By.id("phone"));
        this.address = driver.findElement(By.id("address"));
        this.email = driver.findElement(By.id("email"));
        this.description = driver.findElement(By.id("description"));
        //this.image = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/div[9]/input"));
        this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));



    }

    public void applyToJobFormatPageMethod(String name, String jobName, String id, String phone, String address, String email, String description) throws InterruptedException {

        this.name.sendKeys(name);
        this.jobName.sendKeys(jobName);
        this.id.sendKeys(id);
        this.phone.sendKeys(phone);
        this.address.sendKeys(address);
        this.email.sendKeys(email);
        this.description.sendKeys(description);

        //this.image.sendKeys(path);
        Thread.sleep(5000);
        this.addBtn.click();

    }
}

