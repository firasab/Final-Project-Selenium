package pages;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class getJobInformationPage {

    WebElement jobInformation;


    public getJobInformationPage(WebDriver driver, int jobNumber) {

        this.jobInformation = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table"));

    }

    public void getJobsPage() throws InterruptedException {

        Thread.sleep(5000);

        String[] headers = new String[1];
        headers[0] = "Jobs Information";

        String[] website_data = new String[1];
        website_data[0] = jobInformation.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine("jobsInfo.csv", data, headers);
    }
}
