package Day07;

import UI.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DataDrivenTest {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPageUI loginPageUI;

    String excelFilePath ="login.xlsx";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.get("https://saucedemo.com");
        loginPageUI = new LoginPageUI(driver);

    }
    public void inputData(String user, String pass) {
        loginPageUI.inputUserName().sendKeys(user);
        loginPageUI.inputPassWord().sendKeys(pass);

    }

    public void clickLogin() {
        loginPageUI.buttonLogin().click();
    }

    @Test
    public void loginSuccessful() {
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
        for (Map<String, String> rowData : excelData) {
            driver.get("https://saucedemo.com");
            inputData(rowData.get("Username"), rowData.get("Password"));
            clickLogin();
            break;
        }
    }

    @Test
    public void loginFailed() {
        int count = 0;
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
        for (Map<String, String> rowData : excelData) {
            if (count > 0) {
                driver.get("https://www.saucedemo.com/");
                inputData(rowData.get("Username"), rowData.get("Password"));
                clickLogin();
            }
            count++;
        }

        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(error.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
