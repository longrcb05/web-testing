/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @author Nhật Long
 */
public class LeaveTest extends BaseTest{
    // Hàm login nhanh (tái sử dụng)
    public void login() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testAccessLeaveList() {
        login(); // Đăng nhập

        // 1. Click menu 'Leave'
        driver.findElement(By.xpath("//span[text()='Leave']")).click();

        // 2. Verify header trang là 'Leave'
        WebElement header = driver.findElement(By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]"));
        Assert.assertEquals(header.getText(), "Leave");

        // 3. Test chức năng Search (Click nút Search mà không nhập gì để load all)
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        System.out.println("Test Leave: Đã truy cập và search danh sách nghỉ phép thành công.");
    }
}
