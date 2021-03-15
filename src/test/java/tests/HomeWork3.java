package tests;

import helpers.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeWork3 extends BaseTest {

//    WebDriver driver;
    @Test
    public void lessonThree() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setupCredentials();

        loginPage.login("3", "3");
        loginPage.login("","");
        loginPage.login("", "12334444444445566");
    }

//    @AfterMethod
//    public void closeBrowser() {
//        driver.quit();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com");
//    }
}
