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
public class LoginPage {
// Biến driver để điều khiển trình duyệt
    private WebDriver driver;

    // --- KHU VỰC 1: LOCATORS (ĐỊNH VỊ PHẦN TỬ) ---
    // Các biến By đại diện cho vị trí của các phần tử trên trang web.
    
    // Ô nhập tên đăng nhập (Username field)
    private By txtUsername = By.name("username");
    
    // Ô nhập mật khẩu (Password field)
    private By txtPassword = By.name("password");
    
    // Nút đăng nhập (Login button). 
    // Sử dụng CSS Selector để tìm thẻ <button> có thuộc tính type='submit'.
    private By btnLogin = By.cssSelector("button[type='submit']");

    // --- KHU VỰC 2: CONSTRUCTOR ---
    /**
     * Khởi tạo LoginPage.
     * @param driver WebDriver được truyền từ Test Class (BaseTest) sang để thao tác.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- KHU VỰC 3: ACTIONS (HÀNH ĐỘNG NGƯỜI DÙNG) ---

    /**
     * Hành động: Thực hiện quy trình đăng nhập hoàn chỉnh.
     * <p>
     * Hàm này đóng gói 3 bước nhỏ (Nhập User -> Nhập Pass -> Click) thành 1 hành động nghiệp vụ duy nhất.
     * Giúp code trong Test Class gọn gàng hơn (chỉ cần gọi login() thay vì viết lại 3 dòng).
     * * @param user Tên đăng nhập (Ví dụ: "Admin")
     * @param pass Mật khẩu (Ví dụ: "admin123")
     */
    public void login(String user, String pass) {
        // Bước 1: Tìm ô Username và nhập dữ liệu
        driver.findElement(txtUsername).sendKeys(user);
        
        // Bước 2: Tìm ô Password và nhập dữ liệu
        driver.findElement(txtPassword).sendKeys(pass);
        
        // Bước 3: Tìm nút Login và click
        driver.findElement(btnLogin).click();
    }
}
