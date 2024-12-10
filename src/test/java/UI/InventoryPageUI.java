package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPageUI {

    private final WebDriver driver;

    public InventoryPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement inputUsername() {
        return driver.findElement(By.xpath("//input[contains(@id,'user-name')]"));
    }

    public WebElement inputPassword() {
        return driver.findElement(By.xpath("//input[contains(@id,'password')]"));
    }

    public WebElement inputButton() {
        return driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
    }

    public WebElement buttonAdd1() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    }

    public WebElement buttonAdd2() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    }
}
