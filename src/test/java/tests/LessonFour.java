package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonFour extends BaseTest {

    @Test
    public void lessonFourth() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setupCredentials();
        loginPage.login();
    }
}
