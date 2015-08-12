package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by Pablo on 8/7/2015.
 */
public class NewLeadPage{

    private WebDriver driver;
    private WebDriverWait wait;

    public NewLeadPage (WebDriver driver) {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
}
