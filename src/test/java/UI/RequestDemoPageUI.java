package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestDemoPageUI {

    private final WebDriver driver;

    public RequestDemoPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findLabelBook() {
        return driver.findElement(By.xpath("//span[contains(text(),'Book')]"));
    }

    public WebElement findLabelBusinessEmail() {
        return driver.findElement(By.xpath("//label[contains(@for,'Email')]"));
    }

    public WebElement inputBusinessEmail() {
        return driver.findElement(By.xpath("//input[contains(@type,'email')]"));
    }

    public static final String findLabelFirstName = "//label[@id='LblFirstName']";

    public WebElement inputFirstName() {
        return driver.findElement(By.xpath("//input[contains(@id,'First')]"));
    }

    public WebElement findLabelLastName() {
        return driver.findElement(By.xpath("//label[contains(@for,'Last')]"));
    }

    public WebElement inputLastName() {
        return driver.findElement(By.xpath("//input[contains(@id,'Last')]"));
    }

    public WebElement findLabelCompany() {
        return driver.findElement(By.xpath("//label[contains(@for,'Company')]"));
    }

    public WebElement inputCompany() {
        return driver.findElement(By.xpath("//input[contains(@id,'Company')]"));
    }

    public WebElement findLabelPhoneNumber() {
        return driver.findElement(By.xpath("//label[contains(@for,'Phone')]"));
    }

    public WebElement inputPhoneNumber() {
        return driver.findElement(By.xpath("//input[contains(@id,'Phone')]"));
    }

    public WebElement findLabelCountry() {
        return driver.findElement(By.xpath("//label[contains(@for,'Country')]"));
    }

    public static final String selectCountry = "//select[contains(@id,'Country')]";

    public WebElement findLabelInterest() {
        return driver.findElement(By.xpath("//label[contains(@for,'Solu')]"));
    }

    public static final String selectInterest = "//select[contains(@id,'Solu')]";

    public WebElement findLabelComments() {
        return driver.findElement(By.xpath("//label[contains(@for,'Sale')]"));
    }

    public WebElement inputComments() {
        return driver.findElement(By.xpath("//textarea[contains(@name,'Sale')]"));
    }

    public WebElement checkbox() {
        return driver.findElement(By.xpath("//label[contains(@for,'Checkbox')]"));
    }

    public WebElement buttonLetsTalk() {
        return driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
    }

}
