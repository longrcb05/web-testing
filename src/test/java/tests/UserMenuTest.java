/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserMenuPage;
/**
 *
 * @author Nhật Long
 */
public class UserMenuTest extends BaseTest {
   @Test(priority = 1)
    public void testAboutPopupDetails() {
        // 1. Đăng nhập
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // 2. Mở menu -> About
        UserMenuPage userMenu = new UserMenuPage(driver);
        userMenu.openMenu();
        userMenu.clickAbout();

        // 3. [TEST SÂU] Verify chi tiết nội dung trong Popup
        // Verify Company Name
        String actualCompany = userMenu.getCompanyName();
        Assert.assertEquals(actualCompany, "OrangeHRM", "Tên công ty trong About sai!");

        // Verify Version (Ví dụ trong ảnh bạn gửi là OrangeHRM OS 5.7)
        String actualVersion = userMenu.getVersion();
        System.out.println("Phiên bản hiện tại: " + actualVersion);
        Assert.assertTrue(actualVersion.contains("OrangeHRM"), "Thông tin phiên bản không chứa OrangeHRM!");

        // 4. Đóng popup
        userMenu.closeAboutPopup();
        System.out.println("Test About Details: PASSED");
    }

    @Test(priority = 2)
    public void testChangePasswordFormInteraction() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        UserMenuPage userMenu = new UserMenuPage(driver);
        userMenu.openMenu();
        
        // Click Change Password
        userMenu.clickChangePassword();

        // Verify đã vào đúng trang
        Assert.assertTrue(userMenu.isUpdatePasswordPageDisplayed(), "Chưa vào được trang Update Password!");

        // [TEST SÂU] Thử tương tác với Form (Nhập liệu)
        // Nhập thử dữ liệu vào 3 ô (như trong ảnh image_922102.png)
        // Lưu ý: Mình nhập xong ấn Cancel để không đổi pass thật, tránh hỏng acc test.
        userMenu.fillChangePasswordForm("admin123", "NewPass123!", "NewPass123!");
        
        System.out.println("Đã điền form thành công, chuẩn bị Cancel...");
        
        // Ấn Cancel để quay lại Dashboard (Verify nút Cancel hoạt động)
        userMenu.clickCancel();
        
        // Kiểm tra xem sau khi Cancel có quay lại Dashboard không
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Nút Cancel không hoạt động!");

        System.out.println("Test Change Password Form: PASSED");
    }

    @Test(priority = 3)
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        UserMenuPage userMenu = new UserMenuPage(driver);
        userMenu.openMenu();
        userMenu.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Đăng xuất thất bại!");
        System.out.println("Test Logout: PASSED");
    }
}
