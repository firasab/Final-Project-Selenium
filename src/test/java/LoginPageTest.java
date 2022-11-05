import core.Constants;
import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LogIn.LoginPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class LoginPageTest {


    @Test
    public void loginTest() throws InterruptedException, IOException {
        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");

        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.loginMethod(Email, Password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();


    }


}


