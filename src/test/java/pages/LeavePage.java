/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author Nhật Long
 */
public class LeavePage {
  // Biến driver để điều khiển trình duyệt
    private WebDriver driver;

    // --- KHU VỰC 1: LOCATORS (ĐỊNH VỊ PHẦN TỬ) ---
    
    // Tiêu đề trang nằm trên thanh header (Breadcrumb).
    // Dùng để kiểm tra xem đã chuyển đúng sang trang Leave chưa.
    private By headerTitle = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");
    
    // Nút "Search" (Tìm kiếm) trong bộ lọc danh sách nghỉ phép.
    private By searchButton = By.xpath("//button[@type='submit']");

    // --- KHU VỰC 2: CONSTRUCTOR ---
    /**
     * Khởi tạo Page Object với WebDriver.
     * @param driver trình duyệt đang chạy test.
     */
    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- KHU VỰC 3: ACTIONS (HÀNH ĐỘNG) ---

    /**
     * Hành động: Lấy nội dung text của tiêu đề trang.
     * * @return Chuỗi text hiển thị trên header (Ví dụ: "Leave").
     */
    public String getHeaderText() {
        return driver.findElement(headerTitle).getText();
    }

    /**
     * Hành động: Click vào nút Search.
     * Thường dùng sau khi điền các điều kiện lọc (hoặc để mặc định) để tải danh sách.
     */
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
