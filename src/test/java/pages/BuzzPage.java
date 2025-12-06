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
public class BuzzPage {
    private WebDriver driver;
    // Ô nhập status
    private By postInput = By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
    private By postButton = By.xpath("//button[@type='submit']");

    public BuzzPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createPost(String content) {
        driver.findElement(postInput).sendKeys(content);
        driver.findElement(postButton).click();
    }
    
    public boolean isPostInputDisplayed() {
         return driver.findElement(postInput).isDisplayed();
    }
}
