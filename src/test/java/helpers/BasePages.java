package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePages {
    protected WebDriver driver;
    protected BasePages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
