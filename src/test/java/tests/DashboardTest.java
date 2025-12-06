/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.DirectoryPage;
import pages.LoginPage;
/**
 *
 * @author Nhật Long
 */
public class DashboardTest extends BaseTest{
    @Test(priority = 1)
    public void testDashboardWidgets() {
        // 1. Đăng nhập
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // 2. Khởi tạo Dashboard Page
        DashboardPage dashboardPage = new DashboardPage(driver);

        // 3. Kiểm tra tiêu đề có phải Dashboard không
        Assert.assertEquals(dashboardPage.getHeaderTitle(), "Dashboard", "Tiêu đề trang không đúng!");

        // 4. Kiểm tra Widget "Time at Work"
        boolean isWidgetPresent = dashboardPage.isTimeAtWorkDisplayed();
        Assert.assertTrue(isWidgetPresent, "Widget 'Time at Work' không hiển thị trên Dashboard!");

        System.out.println("Test Dashboard Widgets: PASSED");
    }

    @Test(priority = 2)
    public void testDirectorySearch() {
        // 1. Đăng nhập
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // 2. Từ Dashboard chuyển hướng sang Directory
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToModule("Directory");

        // 3. Khởi tạo Directory Page để verify
        DirectoryPage directoryPage = new DirectoryPage(driver);
        
        // 4. Kiểm tra nút Search có hiển thị không
        Assert.assertTrue(directoryPage.isSearchButtonDisplayed(), "Không tìm thấy nút Search ở trang Directory!");

        System.out.println("Test Directory Access: PASSED");
    }
}
