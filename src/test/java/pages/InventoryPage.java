package pages;

import helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryPage extends BasePages {
    private WebElement burger;
    private WebDriverWait wait = new WebDriverWait(driver,5);

    public InventoryPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User is not log in");
        burger = driver.findElement(By.id("react-burger-menu-btn"));
    }

    public void logOut() {
        burger.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        logOutButton.click();
    }
}
