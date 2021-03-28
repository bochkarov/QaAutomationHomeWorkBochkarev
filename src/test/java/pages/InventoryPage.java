package pages;

import helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePages {
    private final String LOGOUT_BUTTON_ID = "logout_sidebar_link";

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerButton;

    @FindBy(id = LOGOUT_BUTTON_ID)
    private WebElement logoutButton;

    private WebDriverWait wait = new WebDriverWait(driver,5);

    public InventoryPage(WebDriver driver) {
        super(driver);
        burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
    }

    public void openBurgerMenu() {
        burgerButton.click();
    }

    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(LOGOUT_BUTTON_ID)));
        logoutButton.click();
    }
}
