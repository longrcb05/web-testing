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
public class PerformancePage {
    private WebDriver driver;
    // Header quản lý KPI
    private By kpiHeader = By.xpath("//h6[text()='Performance']");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(kpiHeader).getText();
    }
}
