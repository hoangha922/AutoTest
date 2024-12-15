package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DoubleClick {
    private WebDriver driver;

    public DoubleClick(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions actions = new Actions(driver);

//        Thực hiện double click vào button
        actions.doubleClick(button).perform();

//      Xử lý cảnh báo xuất hiện sau double click
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after double click: " + alertText);

//       Đăng alert
        driver.switchTo().alert().accept();


    }
}
