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
public class RecruitmentPage {
private WebDriver driver;
    private WebDriverWait wait;

    // --- LOCATORS ---
    private By addButton = By.xpath("//button[text()=' Add ']");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By emailInput = By.xpath("//label[text()='Email']/../following-sibling::div//input");
    private By saveButton = By.xpath("//button[@type='submit']");
    
    // Locator quan trọng: Thông báo thành công màu xanh lá (Toast Message)
    private By successMessage = By.xpath("//div[contains(@class, 'oxd-toast-container')]");

    // --- CONSTRUCTOR ---
    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Time-out 10s
    }

    // --- ACTIONS ---

    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void fillCandidateInfo(String first, String last, String email) {
        // Chờ ô input xuất hiện rồi mới điền
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(first);
        driver.findElement(lastNameInput).sendKeys(last);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    
    /**
     * Hàm verify thông minh:
     * Thay vì check text ngay lập tức, hàm này sẽ CHỜ tối đa 10s để thấy thông báo Success.
     * @return true nếu thông báo hiện ra, false nếu chờ mãi không thấy.
     */
    public boolean verifyAddSuccess() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
