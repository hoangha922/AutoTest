package Day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleRadioButton {
    private WebDriver driver;

    public SingleRadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement radioButton = driver.findElement(By.id("vfb-7-1"));
        radioButton.click();

        String value = radioButton.getAttribute("Value");
        boolean isSelected = radioButton.isSelected();

        System.out.println("Radio Button value seleted" + value);
        System.out.println("Radio Button is selected: " + isSelected);

    }
}
