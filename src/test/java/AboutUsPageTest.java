import core.Constants;
import core.OpenBrowsers;
import core.TakeScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AboutWebPage.AboutWebPage;

import java.io.IOException;


public class AboutUsPageTest {
    WebDriver driver;
    TakeScreenShot takeScr;
    int imageNumber =0;

    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void getAboutUsTest() throws InterruptedException, IOException {
            AboutWebPage aboutUs = new AboutWebPage(driver);
            aboutUs.getAboutUsPage();
            Thread.sleep(5000);
            takeScr.takeScreenShot(Constants.PicturesFolderPath+"AboutUS"+imageNumber+".png");
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(Constants.LOGIN_URL);
    }
}