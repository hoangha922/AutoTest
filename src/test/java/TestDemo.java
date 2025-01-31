import UI.RequestDemoPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestDemo {

    private WebDriver driver;
    private RequestDemoPageUI requestDemoPageUI;

    public TestDemo(WebDriver driver) {
        this.driver = driver;
        this.requestDemoPageUI = new RequestDemoPageUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");

        String filePath = "C:/Users/Sunset Glow/downloads/keymap.txt";

        WebElement uploadFile = driver.findElement(By.id("uploadfile_0"));
        uploadFile.sendKeys(filePath);

        WebElement termsCheckbox = driver.findElement(By.id("terms"));
        termsCheckbox.click();

        WebElement uploadButton = driver.findElement(By.id("submitbutton"));
        uploadButton.click();

        WebElement resultMessege = driver.findElement(By.id("res"));
        System.out.println("Kết quả tải lên: " + resultMessege.getText());



//        driver.navigate().to("https://www.saucedemo.com/");

//        String getURL = driver.getCurrentUrl();
//        System.out.println("Đường dẫn là " + getURL);

//        WebElement element = driver.findElement(By.partialLinkText("Try"));
//        element.click();

//        WebElement header = driver.findElement(By.tagName("h1"));
//        System.out.println("Header text: " + header.getText());

//        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
//        System.out.println("\nParagraph");
//        for (WebElement paragraph : paragraphs) {
//            System.out.println(paragraph.getText());
//        }

//        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
//        System.out.println("\nButton");
//        for (WebElement button : buttons) {
//            System.out.println(button.getText());
//        }
//
//        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
//        emailInput.sendKeys("hoangha922@gmail.com");


        // Tạo instance của TestDemo
//        TestDemo testDemo = new TestDemo(driver);
//
//        // Sử dụng requestDemoPageUI
//
//        testDemo.requestDemoPageUI.findLabelBook().click();
//
//        testDemo.requestDemoPageUI.findLabelBusinessEmail().click();
//        testDemo.requestDemoPageUI.inputBusinessEmail().sendKeys("hoangha922@gmail.com");
//
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement labelFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.findLabelFirstName)));
//        labelFirstName.click();
//
//        testDemo.requestDemoPageUI.inputFirstName().sendKeys("Hoàng Thái");
//
//        testDemo.requestDemoPageUI.findLabelLastName().click();
//        testDemo.requestDemoPageUI.inputLastName().sendKeys("Hà");
//
//        testDemo.requestDemoPageUI.findLabelCompany().click();
//        testDemo.requestDemoPageUI.inputCompany().sendKeys("BFD.JSC");
//
//        testDemo.requestDemoPageUI.findLabelPhoneNumber().click();
//        testDemo.requestDemoPageUI.inputPhoneNumber().sendKeys("0904590444");
//
//        testDemo.requestDemoPageUI.findLabelCountry().click();
//
//        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.selectCountry)));
//        Select selectCountry = new Select(countryDropdown);
//        selectCountry.selectByVisibleText("Vietnam");
//
//        testDemo.requestDemoPageUI.findLabelInterest().click();
//
//        WebElement interestDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestDemoPageUI.selectInterest)));
//        Select selectInterest = new Select(interestDropdown);
//        selectInterest.selectByVisibleText("Visual Testing");
//
//        testDemo.requestDemoPageUI.findLabelComments().click();
//        testDemo.requestDemoPageUI.inputComments().sendKeys("comment comment");
//
//        testDemo.requestDemoPageUI.checkbox().click();
//
//        testDemo.requestDemoPageUI.buttonLetsTalk().click();

//        driver.quit();

    }

}
