package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    private WebDriver driver;

    public RightClick(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);

        actions.contextClick(button).perform();

        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
        edit.click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after right click: " + alertText);

        driver.switchTo().alert().accept();

    }
}
