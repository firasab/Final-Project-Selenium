package pages.LogIn;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage {
    WebElement email;
    WebElement password;
    WebElement loginBtn;
    TakeScreenShot takeScr;

    public LoginPage(WebDriver driver) {
        this.email = driver.findElement(By.name("email"));
        this.password = driver.findElement(By.name("password"));
        this.loginBtn = driver.findElement(By.xpath(Constants.LOGIN_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }

    public void loginMethod(String email, String password) throws InterruptedException, IOException {
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"loginPage.png");
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }
}

