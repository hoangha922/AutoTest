package Day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelUtils;

import java.util.*;

public class LoginTest {

    public static void main(String[] args) {

//        Đường dẫn file excel
        String excelFilePath = "login.xlsx";
        String sheetName = "Sheet1"; //Hoặc thay bằng tên sheet bất kỳ trong file

//        Đọc dữ liệu từ file excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
//            Duyệt qua từng bản ghi trong dữ liệu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Dữ liệu hàng: " + rowData);
                String user = rowData.get("Username"); //Lấy giá trị cột user
                String pass = rowData.get("Password"); //Lấy giá trị cột pass
                driver.get("https://www.saucedemo.com/");

                WebElement inputUsername = driver.findElement(By.id("user-name"));
                inputUsername.sendKeys(user);

                WebElement inputPassword = driver.findElement(By.id("password"));
                inputPassword.sendKeys(pass);

            }

        } finally {
            driver.quit();
        }

    }

}
