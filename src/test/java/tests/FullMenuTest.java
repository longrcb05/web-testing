/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
/**
 *
 * @author Nhật Long
 */
public class FullMenuTest extends BaseTest {
    @Test(priority = 1)
    public void testTimeModule() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToModule("Time");

        TimePage timePage = new TimePage(driver);
        Assert.assertTrue(timePage.isEmployeeInputDisplayed(), "Trang Time không hiển thị ô nhập tên!");
        System.out.println("Test Time: Passed");
    }

    @Test(priority = 2)
    public void testPerformanceModule() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToModule("Performance");

        PerformancePage perfPage = new PerformancePage(driver);
        Assert.assertEquals(perfPage.getPageTitle(), "Performance");
        System.out.println("Test Performance: Passed");
    }

    @Test(priority = 3)
    public void testClaimModule() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToModule("Claim");

        ClaimPage claimPage = new ClaimPage(driver);
        Assert.assertTrue(claimPage.isAssignClaimButtonDisplayed(), "Nút Assign Claim không hiển thị!");
        System.out.println("Test Claim: Passed");
    }

    @Test(priority = 4)
    public void testBuzzModule() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToModule("Buzz");

        BuzzPage buzzPage = new BuzzPage(driver);
        Assert.assertTrue(buzzPage.isPostInputDisplayed(), "Không thấy ô đăng bài viết Buzz!");
        
        // Thử đăng một status (Optional)
        buzzPage.createPost("Hello from Automation Test!");
        System.out.println("Test Buzz: Passed");
    }

    @Test(priority = 5)
    public void testMaintenanceModule() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateToModule("Maintenance");

        // Module này yêu cầu nhập lại password
        MaintenancePage mainPage = new MaintenancePage(driver);
        mainPage.confirmPassword("admin123");
        
        Assert.assertTrue(mainPage.isAccessGranted(), "Không thể truy cập Maintenance sau khi nhập pass!");
        System.out.println("Test Maintenance: Passed");
    }
}
