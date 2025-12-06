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
public class LoginTest extends BaseTest{
    @Test(priority = 1)
    public void testLoginSuccess() {
        // Nhập Username
        driver.findElement(By.name("username")).sendKeys("Admin");
        // Nhập Password
        driver.findElement(By.name("password")).sendKeys("admin123");
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Kiểm tra đã vào Dashboard chưa
        boolean isDashboardDisplayed = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(isDashboardDisplayed, "Đăng nhập thất bại, không thấy URL dashboard!");
        System.out.println("Test Login Success: PASSED");
    }

    @Test(priority = 2)
    public void testLoginInvalid() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.xpath("//p[contains(@class, 'alert-content-text')]"));
        Assert.assertEquals(errorMsg.getText(), "Invalid credentials");
        System.out.println("Test Login Invalid: PASSED");
    }
}
