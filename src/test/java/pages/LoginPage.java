package pages;

import helpers.BasePages;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePages {
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private String correctUsername;
    private String wrongUsername;
    private String password;

    public LoginPage(WebDriver driver) {
        super(driver);
        usernameField = driver.findElement(By.name("user-name"));
        passwordField = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.id("login-button"));
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        if (username.isEmpty())
            usernameField.clear();

        if (password.isEmpty())
            passwordField.clear();

        loginButton.click();
    }

    public void login() {
        usernameField.sendKeys(correctUsername);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void setupCredentials() {
        final String loginCredentialsClass = "login_credentials";
        final String passwordCredentialsClass = "login_password";
        final int correctLoginAndPasswordIndex = 1;
        final int wrongLoginIndex = 2;

        correctUsername = getValuesFromCredentialsElements(loginCredentialsClass, correctLoginAndPasswordIndex);
        wrongUsername = getValuesFromCredentialsElements(loginCredentialsClass, wrongLoginIndex);
        password = getValuesFromCredentialsElements(passwordCredentialsClass, correctLoginAndPasswordIndex);
    }

    public String getValuesFromCredentialsElements(String className, int index) {
        WebElement valuesElement = driver.findElement(By.className(className));
        String[] values = valuesElement.getText().split("\n");
        return values[index];
    }
}
