/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
/**
 *
 * @author Nhật Long
 */
public class AdminTest extends BaseTest {
    @Test
    public void testAccessAdminPage() {
        // Đăng nhập thủ công hoặc gọi hàm login chung
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Click menu Admin
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        
        // Lấy text header để verity
        String headerText = driver.findElement(By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")).getText();
        if(headerText.equals("Admin")) {
             System.out.println("Test Admin Page: Đã truy cập thành công");
        }
    }
}
