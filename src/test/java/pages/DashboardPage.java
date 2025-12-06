/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Nhật Long
 */
public class DashboardPage {
private WebDriver driver;

    // 1. Locators
    private By timeAtWorkWidget = By.xpath("//p[text()='Time at Work']");
    private By myActionsWidget = By.xpath("//p[text()='My Actions']");
    private By headerTitle = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");

    // 2. Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    // Hàm chuyển hướng menu (đã có từ trước)
    public void navigateToModule(String moduleName) {
        driver.findElement(By.xpath("//span[text()='" + moduleName + "']")).click();
    }

    // Hàm kiểm tra Widget 'Time at Work' có hiển thị không
    public boolean isTimeAtWorkDisplayed() {
        try {
            return driver.findElement(timeAtWorkWidget).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    // Hàm lấy tiêu đề trang (để verify xem đã vào đúng trang chưa)
    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
