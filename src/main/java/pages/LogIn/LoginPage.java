package pages.LogIn;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebElement email;
    WebElement password;
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.email = driver.findElement(By.name("email"));
        this.password = driver.findElement(By.name("password"));
        this.loginBtn = driver.findElement(By.xpath(Constants.LOGIN_XPATH_BTN));
    }

    public void loginMethod(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }
}

