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
public class MaintenancePage {
  private WebDriver driver;
    
    // --- KHU VỰC 1: LOCATORS ---
    
    // Ô nhập mật khẩu (Administrator Password)
    private By passwordInput = By.name("password");
    
    // Nút xác nhận (Confirm)
    private By confirmButton = By.xpath("//button[@type='submit']");
    
    // Tiêu đề "Purge Records". Đây là phần tử CHỈ xuất hiện sau khi đã nhập đúng mật khẩu.
    // Dùng để verify xem đã vượt qua màn hình bảo mật thành công chưa.
    private By purgeRecordsLabel = By.xpath("//h6[text()='Purge Records']"); 

    // --- KHU VỰC 2: CONSTRUCTOR ---
    public MaintenancePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- KHU VỰC 3: ACTIONS ---

    /**
     * Hành động: Xác nhận mật khẩu quản trị viên.
     * Bước này bắt buộc phải làm để truy cập vào các tính năng bên trong Maintenance.
     * @param password Mật khẩu của tài khoản đang đăng nhập (thường là 'admin123')
     */
    public void confirmPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password); // Nhập pass
        driver.findElement(confirmButton).click();            // Click Confirm
    }

    /**
     * Kiểm tra xem đã truy cập thành công vào khu vực Maintenance chưa.
     * <p>
     * Logic:
     * - Nếu tìm thấy chữ "Purge Records" -> Đã login thành công (Return true).
     * - Nếu không tìm thấy (gặp lỗi NoSuchElementException) -> Vẫn kẹt ở màn hình nhập pass -> Return false.
     * * @return true nếu truy cập thành công.
     */
    public boolean isAccessGranted() {
        try {
            return driver.findElement(purgeRecordsLabel).isDisplayed();
        } catch (Exception e) {
            // Rơi vào đây nghĩa là không tìm thấy element 'purgeRecordsLabel'
            // Có thể do nhập sai pass hoặc trang chưa load kịp
            return false;
        }
    }
}
