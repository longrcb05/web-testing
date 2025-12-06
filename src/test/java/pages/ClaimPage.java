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
public class ClaimPage {
    private WebDriver driver;
    // Nút tạo yêu cầu thanh toán
    private By submitClaimButton = By.xpath("//a[text()='Submit Claim']"); // Có thể là button hoặc a tùy phiên bản
    // Fallback locator nếu thẻ a không hoạt động
    private By assignClaimButton = By.xpath("//button[text()=' Assign Claim ']");

    public ClaimPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAssignClaimButtonDisplayed() {
        return driver.findElement(assignClaimButton).isDisplayed();
    }
}
