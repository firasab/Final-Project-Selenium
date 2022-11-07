package core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClearField {
    public void ClearCompanyField(WebElement worker ,  WebDriver driver ) {
        Actions actions = new Actions(driver);
        worker.click();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
    }
}
