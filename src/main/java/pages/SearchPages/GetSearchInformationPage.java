package pages.SearchPages;
import core.Constants;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        this.name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/th"));
        this.ID = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[1]"));
        this.Location = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[2]"));
        this.PhoneNumber = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[3]"));
        this.Email = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[4]"));
        this.Company = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[5]"));
        this.StartedWorkingAt = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[6]"));
        this.FinishedWorkingAt = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr/td[7]"));
    }

    public void getSearched() throws InterruptedException {

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
    }
}
