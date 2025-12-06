/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
/**
 *
 * @author Nhật Long
 */

// FILE CHỨA CẤU HÌNH - KHÔNG ẤN TEST
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // OrangeHRM load hơi chậm nên để wait lâu một chút (15s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        // Mở trang OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt sau khi test xong
        }
    }
}
