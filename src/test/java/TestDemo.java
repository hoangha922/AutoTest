import UI.RequestDemoPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestDemo {

    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;

    public TestDemo(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        // Tạo instance của TestDemo
        TestDemo testDemo = new TestDemo(driver);

        // Sử dụng requestDemoPageUI

        testDemo.requestDemoPageUI.inputBusinessEmail().sendKeys("hoangha922@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.XPATH_INPUT_FIRSTNAME)));
        inputFirstName.sendKeys("Hoàng Thái");

        testDemo.requestDemoPageUI.inputLastName().sendKeys("Hà");

        testDemo.requestDemoPageUI.inputCompany().sendKeys("BFD.JSC");

        testDemo.requestDemoPageUI.inputPhoneNumber().sendKeys("0904590444");

        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.XPATH_SELECT_COUNTRY)));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("Vietnam");

        WebElement interestDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.XPATH_SELECT_INTEREST)));
        Select selectInterest = new Select(interestDropdown);
        selectInterest.selectByVisibleText("Visual Testing");

        testDemo.requestDemoPageUI.inputComments().sendKeys("comment comment");

        testDemo.requestDemoPageUI.checkbox().click();

        testDemo.requestDemoPageUI.buttonLetsTalk().click();

        driver.quit();
    }
}
