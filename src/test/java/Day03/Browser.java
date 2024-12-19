package Day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Mở website
        driver.get("https://www.saucedemo.com/");

//      Điều hướng trang
//        driver.navigate().to("https://saucelabs.com/request-demo");

        String getURL = driver.getCurrentUrl();
        System.out.println("Đường dẫn web là: " + getURL);



    }
}
