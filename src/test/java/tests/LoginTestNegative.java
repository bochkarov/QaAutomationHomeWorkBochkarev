package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InventoryPage;
import pages.LoginPage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LoginTestNegative extends BaseTest {

    @Test
    public void loginTestNegative() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(isElementExists(loginPage.error),"Error on the page");


        loginPage.loginButton.click();

        Assert.assertTrue(isElementHasText(loginPage.error),"The error has no text");
        softAssert.assertEquals(getTextOrEmpty(loginPage.error), "Epic sadface: Username is required", "Without credits login: Wrong error message!");

        loginPage.login("", generateString());
        Assert.assertTrue(isElementHasText(loginPage.error),"The error has no text");
        softAssert.assertEquals(loginPage.error.getText(),"Epic sadface: Username is required", "Without username login: Error message is incorrect");

        loginPage.login(generateString(), "");
        Assert.assertTrue(isElementHasText(loginPage.error),"The error has no text");
        softAssert.assertEquals(loginPage.error.getText(),"Epic sadface: Password is required", "Without password login: Error message is incorrect");

        loginPage.login(generateString(),generateString());
        Assert.assertTrue(isElementHasText(loginPage.error),"The error has no text");
        softAssert.assertEquals(loginPage.error.getText(),"Epic sadface: Username and password do not match any user in this service", "Invalid credits login: Error message wrong!");
    }

    private String generateString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        System.out.println(generatedString);
        return generatedString;
    }
}
