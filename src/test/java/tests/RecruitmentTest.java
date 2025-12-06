/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RecruitmentPage;
/**
 *
 * @author Nhật Long
 */
public class RecruitmentTest extends BaseTest {
   @Test
    public void testAddCandidate() {
        // 1. Đăng nhập (Tái sử dụng code từ LoginPage)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // 2. Điều hướng đến module Recruitment (Tái sử dụng DashboardPage)
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToModule("Recruitment");

        // 3. Thực hiện kịch bản thêm ứng viên
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        
        // Click Add
        recruitmentPage.clickAdd();
        
        // Điền thông tin (Dùng Email ngẫu nhiên để tránh trùng nếu cần)
        recruitmentPage.fillCandidateInfo("Nguyen", "Van Tester", "test" + System.currentTimeMillis() + "@example.com");
        
        // Click Save
        recruitmentPage.clickSave();

        // 4. Verify kết quả (Sử dụng hàm wait thông minh đã viết ở Page)
        boolean isSuccess = recruitmentPage.verifyAddSuccess();
        
        Assert.assertTrue(isSuccess, "Thất bại: Không thấy thông báo Success hiện lên sau khi lưu!");

        System.out.println("Test Recruitment: Đã thêm ứng viên mới thành công (PASSED).");
    }
}
