package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pablo Zubieta on 11/08/2015.
 */
public class AccountDetailsPage extends DeletorMain {

    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountName;

    public AccountDetailsPage () {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

}
