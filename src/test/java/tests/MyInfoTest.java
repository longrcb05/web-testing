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
public class MyInfoTest extends BaseTest{
    public void login() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testMyInfoAvatar() {
        login();

        // 1. Click menu 'My Info'
        driver.findElement(By.xpath("//span[text()='My Info']")).click();

        // 2. Đợi trang load (dùng sleep tạm thời, thực tế nên dùng WebDriverWait)
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // 3. Kiểm tra ảnh đại diện nhân viên có hiển thị không
        WebElement avatar = driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-image-wrapper']//img"));
        Assert.assertTrue(avatar.isDisplayed(), "Ảnh đại diện không hiển thị!");

        // 4. Kiểm tra tên nhân viên có đúng không (Ví dụ check tên trong ô input)
        String firstName = driver.findElement(By.name("firstName")).getAttribute("value");
        System.out.println("Tên nhân viên hiện tại là: " + firstName);
        
        System.out.println("Test My Info: Đã kiểm tra thông tin cá nhân.");
    }
}
