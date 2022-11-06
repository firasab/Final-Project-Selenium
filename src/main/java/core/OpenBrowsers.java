package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowsers {
    public static WebDriver openBrowser(String browser) {

        WebDriver driver;
        if(browser.equals("firefox")) {
            //Setting webdriver.gecko.driver property
            System.setProperty(Constants.FIRE_FOX_DRIVER, Constants.FIRE_FOX_DRIVER_PATH);
            //Instantiating driver object and launching browser
            driver = new FirefoxDriver();
        }else if(browser.equals("chrome")) {
            System.setProperty( Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_PATH);
            //Instantiating driver object
            driver = new ChromeDriver();
        }else if(browser.equals("edge")) {
            System.setProperty( Constants.EDGE_DRIVER, Constants.EDGE_DRIVER_PATH);
            // Instantiate a ChromeDriver class.
            driver = new EdgeDriver();
        }else {
            driver = null;
        }

        return driver;
    }
}