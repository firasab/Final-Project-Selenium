package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class EditCompanyFormatPage {

    WebElement companyName;
    WebElement field;
    WebElement numberOfWorker;
    WebElement address;

    WebElement image;
    WebElement addBtn;


    WebDriver driver;
    public EditCompanyFormatPage(WebDriver driver) {
        this.driver = driver;

        companyName = driver.findElement(By.id("companyName"));
        field = driver.findElement(By.id("field"));
        numberOfWorker = driver.findElement(By.id("numberOfWorker"));
        address = driver.findElement(By.id("address"));
        image = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/div[5]/input"));
        addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/button"));
    }

    public void ClearCompanyField(WebElement worker) {
        Actions actions = new Actions(driver);
        worker.click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
    }

    public void editCompanyMethod(String companyName, String field, String numberOfWorker, String address, String path) throws InterruptedException {


            ClearCompanyField(this.companyName);
            this.companyName.sendKeys(companyName);

            ClearCompanyField(this.field);
            this.field.sendKeys(field);

            ClearCompanyField(this.numberOfWorker);
            this.numberOfWorker.sendKeys(numberOfWorker);

            ClearCompanyField(this.address);
            this.address.sendKeys(address);

            File file = new File(path);
            image.sendKeys(file.getAbsolutePath());

            Thread.sleep(5000);
            addBtn.click();

    }
}

