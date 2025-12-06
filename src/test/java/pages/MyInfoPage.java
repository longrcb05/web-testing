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
public class MyInfoPage {
// Biến driver để điều khiển trình duyệt
    private WebDriver driver;

    // --- KHU VỰC 1: LOCATORS (ĐỊNH VỊ PHẦN TỬ) ---
    
    // Ảnh đại diện (Avatar) của nhân viên
    private By avatarImage = By.xpath("//div[@class='orangehrm-edit-employee-image-wrapper']//img");
    
    // Ô input chứa tên (First Name)
    private By firstNameInput = By.name("firstName");

    // --- KHU VỰC 2: CONSTRUCTOR ---
    /**
     * Khởi tạo Page Object với WebDriver.
     * @param driver trình duyệt đang chạy test.
     */
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- KHU VỰC 3: ACTIONS (HÀNH ĐỘNG & KIỂM TRA) ---

    /**
     * Kiểm tra xem ảnh đại diện có hiển thị trên giao diện không.
     * @return true nếu ảnh tồn tại và hiển thị, ngược lại false.
     */
    public boolean isAvatarDisplayed() {
        return driver.findElement(avatarImage).isDisplayed();
    }

    /**
     * Lấy giá trị tên đang hiển thị trong ô input.
     * <p>
     * Lưu ý quan trọng:
     * - Đối với thẻ <input>, ta KHÔNG dùng .getText() vì nó rỗng.
     * - Ta phải dùng .getAttribute("value") để lấy nội dung người dùng nhập vào.
     * * @return Chuỗi String chứa tên nhân viên (Ví dụ: "Admin").
     */
    public String getFirstNameValue() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }
}
