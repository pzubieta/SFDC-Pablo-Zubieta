package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo Zubieta on 11/08/2015.
 */
public abstract class MainContainer {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "new")
     protected WebElement newElementBtn;

}
