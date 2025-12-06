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
public class UserMenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // --- LOCATORS MENU ---
    private By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By aboutLink = By.xpath("//a[text()='About']");
    private By changePasswordLink = By.xpath("//a[text()='Change Password']");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    // --- LOCATORS POPUP ABOUT ---
    private By aboutPopupHeader = By.xpath("//h6[text()='About']");
    
    // Tìm tên công ty
    private By companyName = By.xpath("//p[normalize-space()='OrangeHRM']");
    
    // [FIX LỖI FINAL]: 
    // 1. //div[contains(@class, 'oxd-dialog')] -> Chỉ tìm trong khung popup
    // 2. normalize-space() -> Bỏ qua các dấu cách lạ gây lỗi
    // 3. 'OS 5' -> Tìm từ khóa đặc trưng nhất
    private By version = By.xpath("//div[contains(@class, 'oxd-dialog')]//*[contains(normalize-space(), 'OS 5')]");
    
    private By closeAboutButton = By.xpath("//button[contains(@class, 'oxd-dialog-close-button')]");

    // --- LOCATORS UPDATE PASSWORD ---
    private By updatePasswordHeader = By.xpath("//h6[normalize-space()='Update Password']");
    private By currentPassInput = By.xpath("//label[text()='Current Password']/../following-sibling::div//input");
    private By newPassInput = By.xpath("//label[text()='Password']/../following-sibling::div//input");
    private By confirmPassInput = By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By cancelButton = By.xpath("//button[normalize-space()='Cancel']");

    // --- CONSTRUCTOR ---
    public UserMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- ACTIONS ---
    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public void clickAbout() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink)).click();
    }

    public String getCompanyName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companyName)).getText();
    }

    public String getVersion() {
        // Robot sẽ kiên nhẫn đợi dòng version hiện ra
        return wait.until(ExpectedConditions.visibilityOfElementLocated(version)).getText();
    }

    public void closeAboutPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(closeAboutButton)).click();
    }

    public void clickChangePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink)).click();
    }

    public boolean isUpdatePasswordPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(updatePasswordHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillChangePasswordForm(String current, String newPass, String confirmPass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentPassInput)).sendKeys(current);
        driver.findElement(newPassInput).sendKeys(newPass);
        driver.findElement(confirmPassInput).sendKeys(confirmPass);
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
}