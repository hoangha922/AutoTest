package Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstNameRequired {
    private WebDriver driver;

    public FirstNameRequired(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        FirstNameRequired firstNameRequired = new FirstNameRequired(driver);

        WebElement inputEmail = driver.findElement(By.id("Email"));
        inputEmail.sendKeys("hoangha922@gmail.com.vn");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement inputLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        inputLastName.sendKeys("Hà");

        WebElement inputCompany = driver.findElement(By.id("Company"));
        inputCompany.sendKeys("BFD.JSC");

        WebElement inputPhoneNumber = driver.findElement(By.id("Phone"));
        inputPhoneNumber.sendKeys("0904590444");

        WebElement countryDropdownList = driver.findElement(By.id("Country"));
//        countryDropdownList.click();
//        WebElement selectCountry = driver.findElement(By.xpath("//option[@value='Albania']"));
//        selectCountry.click();
        Select selectCountry = new Select(countryDropdownList);
        selectCountry.selectByVisibleText("Vietnam");

        WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
        Select selectInterest = new Select(interestDropdownList);
        selectInterest.selectByValue("Mobile Application Testing");

        WebElement inputComments = driver.findElement(By.id("Sales_Contact_Comments__c"));
        inputComments.sendKeys("comment comment");

        WebElement checkbox = driver.findElement(By.id("LblmktoCheckbox_44280_0"));
        checkbox.click();

        WebElement buttonLetsTalk = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonLetsTalk.click();

        WebElement alertFirstNameRequired = driver.findElement(By.xpath("//div[@id='ValidMsgFirstName']"));
        System.out.println("Thông báo lỗi: " + alertFirstNameRequired.getText());

        driver.quit();

    }

}
