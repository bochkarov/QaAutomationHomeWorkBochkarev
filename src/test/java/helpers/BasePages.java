package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePages {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass());

    protected BasePages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
