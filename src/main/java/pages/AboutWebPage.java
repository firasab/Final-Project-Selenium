package pages;

import core.TakeScreenShot;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class AboutWebPage {
    WebElement aboutUs;
    WebElement informationParagraph;


    public AboutWebPage(WebDriver driver) {
        this.aboutUs = driver.findElement(By.linkText("About Us"));
        this.informationParagraph = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]"));
    }

    public void getAboutUsPage() throws InterruptedException {
        this.aboutUs.click();
        Thread.sleep(5000);


        String[] headers = new String[1];
        headers[0] = "Website Information";

        String[] website_data = new String[1];
        website_data[0] = informationParagraph.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine("webInfo.csv", data, headers);
    }
}
