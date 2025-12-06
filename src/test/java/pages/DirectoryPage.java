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
public class DirectoryPage {
// Biến driver để điều khiển trình duyệt
    private WebDriver driver;

    // --- KHU VỰC 1: LOCATORS (ĐỊNH VỊ PHẦN TỬ) ---
    
    // Nút "Search" chính trên giao diện.
    // Sự xuất hiện của nút này chứng tỏ trang Directory đã load được phần khung tìm kiếm.
    private By searchButton = By.xpath("//button[@type='submit']");
    
    // Dropdown "Job Title".
    // Biến này có thể dùng để verify kỹ hơn hoặc dùng để test chức năng lọc theo chức danh (nếu cần mở rộng sau này).
    private By jobTitleDropdown = By.xpath("//label[text()='Job Title']");

    // --- KHU VỰC 2: CONSTRUCTOR ---
    /**
     * Khởi tạo Page Object với WebDriver.
     * @param driver trình duyệt đang chạy test.
     */
    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- KHU VỰC 3: ACTIONS (HÀNH ĐỘNG & KIỂM TRA) ---

    /**
     * Kiểm tra xem nút Search có hiển thị không.
     * <p>
     * Đây là hàm verify đơn giản nhất để xác nhận người dùng đã truy cập thành công vào trang Directory.
     * * @return true nếu nút Search hiển thị, ngược lại false.
     */
    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButton).isDisplayed();
    }
}
