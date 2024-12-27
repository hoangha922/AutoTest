package Day07;

import UI.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ModuleDrivenTest {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPageUI loginPageUI;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://saucedemo.com");
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
    public void inputValid() {
        inputData("standard_user", "secret_sauce");
        clickLogin();

    }

    @Test
    public void invalidPass() {
        inputData("standard_user", "secret_sauce1");
        clickLogin();
        WebElement error = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@data-test='error']")));
        String actualMessage = error.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void invalidUser() {
        inputData("standard_use1r", "secret_sauce");
        clickLogin();
        WebElement error = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@data-test='error']")));
        String actualMessage = error.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void invalidUserAndPass() {
        inputData("standard_use1r", "secret_sauce1");
        clickLogin();
        WebElement error = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@data-test='error']")));
        String actualMessage = error.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
