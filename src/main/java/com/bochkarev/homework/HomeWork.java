package com.bochkarev.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//Opening the website
        driver.get("https://www.saucedemo.com");

//Finding login credits
        String loginsArea = driver.findElement(By.id("login_credentials")).getText();
        String[] loginsArray = loginsArea.split("\\r?\\n");
        List<String> fixedLoginList = Arrays.asList(loginsArray);
        ArrayList<String> listOfLogins = new ArrayList<String>(fixedLoginList);
        String login = listOfLogins.get(1);

//Finding password credits
        String passwordArea = driver.findElement(By.className("login_password")).getText();
        String[] passwordArray = passwordArea.split("\\r?\\n");
        List<String> fixedPasswordList = Arrays.asList(passwordArray);
        ArrayList<String> listOfPasswords = new ArrayList<String>(fixedPasswordList);
        String password = listOfPasswords.get(1);

//login
        WebElement loginTextField = driver.findElement(By.name("user-name"));
        WebElement passwordTextField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();

//Adding the second item to the Cart
        List<WebElement> list = driver.findElements(By.xpath("//button"));
        WebElement addToCart = list.get(3);
        addToCart.click();

//Sorting products in reverse order
        WebElement sorting = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sorting);
        select.selectByValue("za");

//Adding the third item to the Cart
        List<WebElement> sortedList = driver.findElements(By.xpath("//button"));
        addToCart = sortedList.get(4);
        addToCart.click();
//logout
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        logOutButton.click();

//Closing the browser
        driver.quit();
    }
}
