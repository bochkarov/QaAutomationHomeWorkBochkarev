package pages;

import helpers.BasePages;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePages {

    @FindBy(name = "user-name")
    public WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage login(String username, String password) {
        clearText(usernameField);
        usernameField.sendKeys(username);
        clearText(passwordField);
        passwordField.sendKeys(password);
        loginButton.click();

        if (driver.getCurrentUrl().contains("/inventory.html"))
            return new InventoryPage(driver);

        return null;
    }



    public String getValuesFromCredentialsElements(String className, int index) {
        WebElement valuesElement = driver.findElement(By.className(className));
        String[] values = valuesElement.getText().split("\n");
        return values[index];
    }

    private void clearText(WebElement element) {
        while (element.getAttribute("value").length() > 0)
            element.sendKeys(Keys.BACK_SPACE);
    }

}
