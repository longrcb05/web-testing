/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
/**
 *
 * @author Nhật Long
 */
public class PIMPage {
   private WebDriver driver;
    
    // Khai báo WebDriverWait: Dùng để chờ đợi một điều kiện cụ thể (Explicit Wait)
    // Ví dụ: Chờ nút hiển thị, chờ thông báo biến mất...
    private WebDriverWait wait;

    // --- KHU VỰC 1: LOCATORS (ĐỊNH VỊ PHẦN TỬ) ---
    
    // Nút "Add" (Thêm mới nhân viên)
    private By btnAdd = By.xpath("//button[normalize-space()='Add']"); // Xpath chính xác cho nút Add
    
    // Ô nhập First Name (Tên)
    private By txtFirstName = By.name("firstName");
    
    // Ô nhập Last Name (Họ)
    private By txtLastName = By.name("lastName");
    
    // Nút "Save" (Lưu)
    private By btnSave = By.cssSelector("button[type='submit']");
    
    // Thông báo thành công (Toast message xuất hiện góc màn hình)
    private By successMessage = By.xpath("//div[contains(@class, 'oxd-toast-container')]");

    // --- KHU VỰC 2: CONSTRUCTOR ---
    /**
     * Khởi tạo trang PIM.
     * Ngoài driver, ta khởi tạo thêm biến 'wait' với thời gian chờ tối đa 15s.
     * @param driver trình duyệt đang chạy test.
     */
    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // --- KHU VỰC 3: ACTIONS (HÀNH ĐỘNG) ---

    /**
     * Hành động: Thêm một nhân viên mới.
     * <p>
     * Logic xử lý:
     * 1. Chờ nút Add có thể click được -> Click.
     * 2. Chờ ô First Name hiển thị -> Nhập tên.
     * 3. Nhập họ.
     * 4. Click nút Save.
     * * @param first Tên nhân viên
     * @param last Họ nhân viên
     */
    public void addEmployee(String first, String last) {
        // Dùng 'wait.until' để đảm bảo nút Add đã sẵn sàng trước khi click (tránh lỗi ElementNotInteractable)
        wait.until(ExpectedConditions.elementToBeClickable(btnAdd)).click();
        
        // Chờ ô nhập liệu hiển thị rồi mới nhập (tránh lỗi ElementNotVisible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtFirstName)).sendKeys(first);
        
        // Nhập Last Name (Không cần wait vì ô này thường load cùng lúc với First Name)
        driver.findElement(txtLastName).sendKeys(last);
        
        // Click nút Save
        driver.findElement(btnSave).click();
    }

    /**
     * Hành động: Kiểm tra xem việc lưu có thành công không.
     * Dựa vào việc toast message (thông báo xanh lá) có xuất hiện hay không.
     * * @return true nếu thấy thông báo thành công, false nếu chờ mãi không thấy.
     */
    public boolean isSaveSuccess() {
        try {
            // Chờ tối đa 15s (theo biến wait) để thông báo xuất hiện
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            // Nếu quá 15s mà không thấy thông báo -> Test fail hoặc Web lỗi -> Trả về false
            return false;
        }
    }
}
