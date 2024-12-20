package Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Success {

        private WebDriver driver;

    public Success(WebDriver driver) {
            this.driver = driver;
        }

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://saucelabs.com/request-demo");
        Success success = new Success(driver);

        WebElement inputEmail = driver.findElement(By.id("Email"));
        inputEmail.sendKeys("hoangha922@gmail.com.vn");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        inputFirstName.sendKeys("Hoàng Thái");

        WebElement inputLastName = driver.findElement(By.id("LastName"));
        inputLastName.sendKeys("Hà");

        WebElement inputCompany = driver.findElement(By.id("Company"));
        inputCompany.sendKeys("BFD.JSC");

        WebElement inputPhoneNumber = driver.findElement(By.id("Phone"));
        inputPhoneNumber.sendKeys("0904590444");

        WebElement countryDropdownList = driver.findElement(By.id("Country"));
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

        System.out.println("Request success");

//        driver.quit();

    }

}
//public class Success {
//    private WebDriver driver;
//
//    public Success(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void fillEmail(String email) {
//        WebElement inputEmail = driver.findElement(By.id("Email"));
//        inputEmail.sendKeys(email);
//    }
//
//    public void fillFirstName(String firstName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
//        inputFirstName.sendKeys(firstName);
//    }
//
//    public void fillLastName(String lastName) {
//        WebElement inputLastName = driver.findElement(By.id("LastName"));
//        inputLastName.sendKeys(lastName);
//    }
//
//    public void fillCompanyName(String companyName) {
//        WebElement inputCompany = driver.findElement(By.id("Company"));
//        inputCompany.sendKeys(companyName);
//    }
//
//    public void fillPhoneNumber(String phoneNumber) {
//        WebElement inputPhoneNumber = driver.findElement(By.id("Phone"));
//        inputPhoneNumber.sendKeys(phoneNumber);
//    }
//
//    public void selectCountry(String country) {
//        WebElement countryDropdownList = driver.findElement(By.id("Country"));
//        Select selectCountry = new Select(countryDropdownList);
//        selectCountry.selectByVisibleText(country);
//    }
//
//    public void selectInterest(String interestValue) {
//        WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
//        Select selectInterest = new Select(interestDropdownList);
//        selectInterest.selectByValue(interestValue);
//    }
//
//    public void fillComments(String comments) {
//        WebElement inputComments = driver.findElement(By.id("Sales_Contact_Comments__c"));
//        inputComments.sendKeys(comments);
//    }
//
//    public void agreeToTerms() {
//        WebElement checkbox = driver.findElement(By.id("LblmktoCheckbox_44280_0"));
//        checkbox.click();
//    }
//
//    public void submitForm() {
//        WebElement buttonLetsTalk = driver.findElement(By.xpath("//button[@type='submit']"));
//        buttonLetsTalk.click();
//    }
//
//    public static void main(String[] args) {
//        WebDriver driver = null;
//        try {
//            // Khởi tạo WebDriver
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://saucelabs.com/request-demo");
//
//            // Tạo đối tượng Success và điền thông tin
//            Success success = new Success(driver);
//            success.fillEmail("hoangha922@gmail.com.vn");
//            success.fillFirstName("Hoàng Thái");
//            success.fillLastName("Hà");
//            success.fillCompanyName("BFD.JSC");
//            success.fillPhoneNumber("0904590444");
//            success.selectCountry("Vietnam");
//            success.selectInterest("Mobile Application Testing");
//            success.fillComments("comment comment");
//            success.agreeToTerms();
//            success.submitForm();
//        }
//    }
//}
