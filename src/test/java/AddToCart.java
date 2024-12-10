import UI.InventoryPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

    private WebDriver driver;
    private InventoryPageUI inventoryPageUI;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.inventoryPageUI = new InventoryPageUI(driver);
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        AddToCart addToCart = new AddToCart(driver);

        addToCart.inventoryPageUI.inputUsername().sendKeys("standard_user");
        addToCart.inventoryPageUI.inputPassword().sendKeys("secret_sauce");
        addToCart.inventoryPageUI.inputButton().click();

//        addToCart.inventoryPageUI.buttonAdd1().click();
//        addToCart.inventoryPageUI.buttonAdd2().click();

        driver.quit();

    }
}