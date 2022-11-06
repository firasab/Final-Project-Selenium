package pages.GetInformation;
import core.Constants;
import core.WriteCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class getJobInformationPage { //getJobInformationPage
    WebElement company;
    WebElement Discription;
    WebElement Position;
    WebElement PayPerHour;
    WebElement Address;

    public getJobInformationPage(WebDriver driver, int jobNumber) {
        this.company = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/td[1]"));
        this.Discription = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/td[2]"));
        this.Position = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/td[3]"));
        this.PayPerHour = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/td[4]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header["+jobNumber+"]/div/table/td[5]"));
    }

    public void getJobsPage() throws InterruptedException {
        Thread.sleep(5000);
        String[] headers = new String[5];
        headers[0] = "company";
        headers[1] = "Discription";
        headers[2] = "Position";
        headers[3] = "PayPerHour";
        headers[4] = "Address";

        String[] website_data = new String[5];
        website_data[4] = company.getText();
        website_data[3] = Discription.getText();
        website_data[2] = Position.getText();
        website_data[1] = PayPerHour.getText();
        website_data[0] = Address.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath+"jobsInfo.csv", data, headers);
    }
}
