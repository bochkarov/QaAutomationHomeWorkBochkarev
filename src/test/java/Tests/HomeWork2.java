package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    private WebDriver driver;
    private WebElement loginTextField;
    private WebElement passwordTextField;
    private WebElement loginButton;
    String[] loginsArray;
    String[] passwordArray;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void loginTest() {

// Opening the website
        driver.get("https://www.saucedemo.com");

// Finding available inputs
        loginTextField = driver.findElement(By.name("user-name"));
        passwordTextField = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.id("login-button"));

// Getting input data
        String loginsArea = driver.findElement(By.id("login_credentials")).getText();
        loginsArray = loginsArea.split("\\r?\\n");
        String passwordArea = driver.findElement(By.className("login_password")).getText();
        passwordArray = passwordArea.split("\\r?\\n");

// Login button click
        loginButton.click();

// Getting login error
        String error = driver.findElement(By.xpath("//h3")).getText();
        errorAnalysis(error);
        loginButton.click();

        error = driver.findElement(By.xpath("//h3")).getText();
        errorAnalysis(error);
        loginButton.click();

        error = driver.findElement(By.xpath("//h3")).getText();
        errorAnalysis(error);
        loginButton.click();

// sorting items on the second page
        WebElement sorting = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sorting);
        select.selectByValue("za");
    }

    private void errorAnalysis(String error) {
        if (error.equals("Epic sadface: Username is required")) {
            loginTextField.clear();
            loginTextField.sendKeys(loginsArray[2]);
                System.out.println("1");
        } else if (error.equals("Epic sadface: Password is required")) {
            passwordTextField.clear();
            passwordTextField.sendKeys(passwordArray[1]);
                System.out.println("2");
        } else if (error.equals("Epic sadface: Sorry, this user has been locked out.")) {
            loginTextField.clear();
            loginTextField.sendKeys(loginsArray[1]);
                System.out.println("3");
        } else {
            System.out.println("Fail");
        }
    }

    @AfterTest
    public void closeBrowser (){
        driver.quit();
    }

}
