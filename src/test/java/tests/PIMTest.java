/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @author Nhật Long
 */
public class PIMTest extends BaseTest {
    // Hàm phụ trợ để đăng nhập nhanh (không phải là @Test)
    public void login() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testSearchEmployee() {
        login(); // Phải đăng nhập trước mới vào được PIM
        
        // Click vào menu PIM
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        
        // Nhập tên nhân viên cần tìm (Ví dụ: Alice)
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Alice");
        
        // Click nút Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        System.out.println("Test Search Employee: Đã thực hiện tìm kiếm");
    }
}
