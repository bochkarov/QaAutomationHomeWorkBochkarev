package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LoginTestNegative extends BaseTest {

    @Test
    public void loginTestNegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(generateString(),generateString());
        InventoryPage inventoryPage = new InventoryPage(driver);
    }

    private String generateString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        System.out.println(generatedString);
        return generatedString;
    }
}
