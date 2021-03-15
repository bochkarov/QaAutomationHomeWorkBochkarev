package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class HomeWork2 {

    private final static String LOGIN_CREDENTIALS_CLASS = "login_credentials";
    private final static String PASSWORD_CREDENTIALS_CLASS = "login_password";
    private final static int CORRECT_INDEX_FOR_LOGIN_AND_PASSWORD = 1;
    private final static int WRONG_USERNAME = 2;
    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private String correctLogin;
    private String correctPassword;
    private String wrongLogin;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void loginTest() {

// Finding available inputs
        usernameField = driver.findElement(By.name("user-name"));
        passwordField = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.id("login-button"));

// Getting input data
        correctLogin = getValueFromPage(LOGIN_CREDENTIALS_CLASS, CORRECT_INDEX_FOR_LOGIN_AND_PASSWORD);
        wrongLogin = getValueFromPage(LOGIN_CREDENTIALS_CLASS, WRONG_USERNAME);
        correctPassword = getValueFromPage(PASSWORD_CREDENTIALS_CLASS, CORRECT_INDEX_FOR_LOGIN_AND_PASSWORD);

// Login button click
        loginButton.click();
        String error = driver.findElement(By.xpath("//h3")).getText();

        while (!driver.getCurrentUrl().contains("inventory"))
            errorAnalysis();

// sorting items on the second page
        WebElement sorting = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sorting);
        select.selectByValue("za");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    private String getValueFromPage(String place, int index) {
        WebElement valuesElement = driver.findElement(By.className(place));
        String[] values = valuesElement.getText().split("\n");
        return values[index];
    }

    private void errorAnalysis() {
        String error = driver.findElement(By.xpath("//h3")).getText();
        if (error.equals("Epic sadface: Username is required")) {
            usernameField.sendKeys(wrongLogin);
            System.out.println("1");
        } else if (error.contains("Password is required")) {
            passwordField.sendKeys(correctPassword);
            System.out.println("2");
        } else if (error.equals("Epic sadface: Sorry, this user has been locked out.")) {
            usernameField.clear();
            usernameField.sendKeys(correctLogin);
            System.out.println("3");
        }
        loginButton.click();
    }
}
