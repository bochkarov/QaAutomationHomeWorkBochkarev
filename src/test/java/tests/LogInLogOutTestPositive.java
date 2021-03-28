package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LogInLogOutTestPositive extends BaseTest {

    private String username;
    private String password;

    @Test

    public void logInLogOutTestPositive() {
        LoginPage loginPage = new LoginPage(driver);
        username = loginPage.getValuesFromCredentialsElements("login_credentials", 1);
        password = loginPage.getValuesFromCredentialsElements("login_password", 1);
        softAssert.assertFalse(isElementExists(loginPage.error), "Error on login page");
        InventoryPage inventoryPage = loginPage.login(username,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User is not log in");
        inventoryPage.openBurgerMenu();
        inventoryPage.logOut();
        Assert.assertTrue(isElementExists(loginPage.loginButton), "User is not logged out");
    }
}
