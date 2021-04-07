package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LogInLogOutTestPositive extends BaseTest {

    private String username;
    private String password;

    @DataProvider(name = "credentials")
    private Object[][] credentials() {
        String password = "secret_sauce";
        return new Object[][] {{"standard_user", password}, {"problem_user",password}, {"performance_glitch_user",password}};
    }

    @Test(dataProvider = "credentials")
    public void logInLogOutTestPositive(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        softAssert.assertFalse(isElementExists(loginPage.error), "Error on login page");
        InventoryPage inventoryPage = loginPage.login(username,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User is not log in");
        inventoryPage.openBurgerMenu();
        inventoryPage.logOut();
        Assert.assertTrue(isElementExists(loginPage.loginButton), "User is not logged out");
    }
}
