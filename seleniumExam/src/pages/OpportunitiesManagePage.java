package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo on 8/10/2015.
 */
public class OpportunitiesManagePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newOpportunityBtn;

    public OpportunitiesManagePage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public OpportunitiesAddPage ClickNewOpportunity(){
        wait.until(ExpectedConditions.elementToBeClickable(newOpportunityBtn));
        newOpportunityBtn.click();
        return new OpportunitiesAddPage();
    }
}
