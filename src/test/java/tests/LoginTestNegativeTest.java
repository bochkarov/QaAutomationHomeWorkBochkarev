package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InventoryPage;
import pages.LoginPage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LoginTestNegativeTest extends BaseTest {

    @DataProvider(name = "credentials")
    private Object[][] credentials(){
        return new Object[][] {
                {"", "", "Epic sadface: Username is required"},
                {"", generateString(), "Epic sadface: Username is required"},
                {generateString(),"", "Epic sadface: Password is required"},
                {generateString(), generateString(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "credentials")
    public void loginTestNegative(String username, String password, String error) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(isElementExists(loginPage.error),"Error on the page");

        loginPage.login(username,password);
        Assert.assertTrue(isElementHasText(loginPage.error),"The error has no text");
        softAssert.assertEquals(getTextOrEmpty(loginPage.error), error, "Without credits login: Wrong error message!");
    }

    private String generateString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        System.out.println(generatedString);
        return generatedString;
    }
}
