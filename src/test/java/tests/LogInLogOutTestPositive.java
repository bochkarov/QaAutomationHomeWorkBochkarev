package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LogInLogOutTestPositive extends BaseTest {

    @Test

    public void logInLogOutTestPositive() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setupCredentials();
        loginPage.login();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logOut();
    }


}
