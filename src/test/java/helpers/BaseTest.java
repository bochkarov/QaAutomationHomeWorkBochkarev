package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    private Logger log = Logger.getLogger(this.getClass());

    @BeforeMethod
    protected void setUp() {
        PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
        WebDriverManager.chromedriver().setup();
        log.info("Chrome driver already done");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }

    protected boolean isElementExists(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    protected String getTextOrEmpty(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException ignore) {
            return "";
        }
    }

    public boolean isElementHasText(WebElement element) {
        try {
            return element.getText().length() > 0;
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }
}
