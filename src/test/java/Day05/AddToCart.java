package Day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import untils.ExcelUntils;

import java.util.List;
import java.util.Map;

public class AddToCart {

    public static void main(String[] args) {

//        Đường dẫn file excel
        String excelFilePath = "login.xlsx";
        String sheetName = "Sheet2"; //Hoặc thay bằng tên sheet bất kỳ trong file

//        Đọc dữ liệu từ file excel
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        try {
//            Duyệt qua từng bản ghi trong dữ liệu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Dữ liệu hàng: " + rowData);
                String product = rowData.get("Product"); //Lấy giá trị cột product

                WebElement addItemButton = driver.findElement(By.xpath("//div[contains(text(),'"+product+"')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
                addItemButton.click();
            }

        } finally {
            WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
            shoppingCart.click();

            WebElement buttonCheckout = driver.findElement(By.id("checkout"));
            buttonCheckout.click();

            WebElement inputFirstName = driver.findElement(By.id("first-name"));
            inputFirstName.sendKeys("Hoang Thai");

            WebElement inputLastName = driver.findElement(By.id("last-name"));
            inputLastName.sendKeys("Ha");

            WebElement inputZip = driver.findElement(By.id("postal-code"));
            inputZip.sendKeys("123456");

            WebElement buttonContinue = driver.findElement(By.id("continue"));
            buttonContinue.click();

            WebElement buttonFinish = driver.findElement(By.id("finish"));
            buttonFinish.click();

            WebElement messageComplete = driver.findElement(By.xpath("//span[@class='title']"));
            System.out.println("Message: " + messageComplete.getText());

            driver.quit();

        }
    }
}
