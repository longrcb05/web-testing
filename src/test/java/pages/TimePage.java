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
public class TimePage {
    private WebDriver driver;
    // Dropdown chọn nhân viên để xem timesheet
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By viewButton = By.xpath("//button[@type='submit']");

    public TimePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEmployeeInputDisplayed() {
        return driver.findElement(employeeNameInput).isDisplayed();
    }
}
