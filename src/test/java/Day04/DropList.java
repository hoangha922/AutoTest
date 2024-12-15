package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropList {

    private WebDriver driver;

    public DropList(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        WebElement interestDropdown = driver.findElement(By.id("Solution_Interest__c"));
        Select select = new Select(interestDropdown);
        select.selectByVisibleText("Accessibility Testing");

        System.out.println("Interest selected successfully.");


    }
}
