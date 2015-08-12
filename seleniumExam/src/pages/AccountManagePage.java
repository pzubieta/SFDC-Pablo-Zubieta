package pages;

import framework.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo on 8/7/2015.
 */
public class AccountManagePage extends MainContainer{

    private WebElement accountLink;

    @FindBy(linkText = "Create New View")
    private WebElement createNewView;

    public AccountManagePage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public AccountDetailsPage goToAccountDetailsPage (String accountName){
        accountLink = driver.findElement(By.linkText(accountName));
        accountLink.click();
        return new AccountDetailsPage();

    }




}
