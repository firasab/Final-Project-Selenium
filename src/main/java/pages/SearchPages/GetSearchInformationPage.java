package pages.SearchPages;
import core.Constants;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetSearchInformationPage {
    WebElement name;
    WebElement ID;
    WebElement Location;
    WebElement PhoneNumber;
    WebElement Email;
    WebElement Company;
    WebElement StartedWorkingAt;
    WebElement FinishedWorkingAt;

    public GetSearchInformationPage(WebDriver driver) {
        this.name = driver.findElement(By.xpath(Constants.SEARCHED_NAME_XPATH));
        this.ID = driver.findElement(By.xpath(Constants.SEARCHED_ID_XPATH));
        this.Location = driver.findElement(By.xpath(Constants.SEARCHED_LOCATION_XPATH));
        this.PhoneNumber = driver.findElement(By.xpath(Constants.SEARCHED_PHONE_NUMBER_XPATH));
        this.Email = driver.findElement(By.xpath(Constants.SEARCHED_EMAIL_XPATH));
        this.Company = driver.findElement(By.xpath(Constants.SEARCHED_COMPANY_XPATH));
        this.StartedWorkingAt = driver.findElement(By.xpath(Constants.SEARCHED_START_WORK_DATE_XPATH));
        this.FinishedWorkingAt = driver.findElement(By.xpath(Constants.SEARCHED_FINISH_WORK_DATE_XPATH));
    }

    public void getSearched() throws InterruptedException, IOException {

        Thread.sleep(5000);
        String[] headers = new String[8];
        headers[0] = "Name";
        headers[1] = "ID";
        headers[2] = "Location";
        headers[3] = "Phone Number";
        headers[4] = "Email";
        headers[5] = "Company";
        headers[6] = "Started working at";
        headers[7] = "Finished working at";

        String[] website_data = new String[8];
        website_data[0] = name.getText();
        website_data[1] = ID.getText();
        website_data[2] = Location.getText();
        website_data[3] = PhoneNumber.getText();
        website_data[4] = Email.getText();
        website_data[5] = Company.getText();
        website_data[6] = StartedWorkingAt.getText();
        website_data[7] = FinishedWorkingAt.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath+"SearchInfo.csv", data, headers);
        WriteCsvFile.attachCsv(Constants.WriteFolderPath+"SearchInfo.csv","SearchInfo.csv");
    }
}
