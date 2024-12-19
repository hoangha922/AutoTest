package Day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import untils.ExcelUntils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BookYourDemoHere {
    public static void main(String[] args) {

//        Đường dẫn file excel
        String excelFilePath = "book.xlsx";
        String sheetName = "Sheet1"; //Hoặc thay bằng tên sheet bất kỳ trong file

//        Đọc dữ liệu từ file excel
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo/");

        try {
//            Duyệt qua từng bản ghi trong dữ liệu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Dữ liệu hàng: " + rowData);
                String businessEmail = rowData.get("Business Email"); //Lấy giá trị cột Business Email
                String firstName = rowData.get("First Name");
                String lastName = rowData.get("Last Name");
                String company = rowData.get("Company");
                String phoneNumber = rowData.get("Phone Number");
                String country = rowData.get("Country");
                String interest = rowData.get("Interest");
                String comments = rowData.get("Comments");

                WebElement inputEmail = driver.findElement(By.id("Email"));
                inputEmail.sendKeys(businessEmail);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
                inputFirstName.sendKeys(firstName);

                WebElement inputLastName = driver.findElement(By.id("LastName"));
                inputLastName.sendKeys(lastName);

                WebElement inputCompany = driver.findElement(By.id("Company"));
                inputCompany.sendKeys(company);

                WebElement inputPhoneNumber = driver.findElement(By.id("Phone"));
                inputPhoneNumber.sendKeys(phoneNumber);

                WebElement countryDropdownList = driver.findElement(By.id("Country"));
                Select selectCountry = new Select(countryDropdownList);
                selectCountry.selectByVisibleText(country);

                WebElement interestDropdownList = driver.findElement(By.id("Solution_Interest__c"));
                Select selectInterest = new Select(interestDropdownList);
                selectInterest.selectByVisibleText(interest);

                WebElement inputComments = driver.findElement(By.id("Sales_Contact_Comments__c"));
                inputComments.sendKeys(comments);

                WebElement checkbox = driver.findElement(By.id("LblmktoCheckbox_44280_0"));
                checkbox.click();

                WebElement buttonLetsTalk = driver.findElement(By.xpath("//button[@type='submit']"));
                buttonLetsTalk.click();

                System.out.println("Request success");
            }

        } finally {
            driver.quit();

        }
    }

}
