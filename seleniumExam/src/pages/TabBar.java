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
 * Created by Pablo on 8/7/2015.
 */
public class TabBar {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Leads")
    @CacheLookup
    private WebElement leadTab;

    @FindBy(linkText = "Accounts")
    private WebElement accountTab;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

    public TabBar(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public LeadManagePage clickLeadTab() {
        wait.until(ExpectedConditions.elementToBeClickable(leadTab));
        leadTab.click();
        return new LeadManagePage(driver);

    }

    public AccountManagePage clickAccountTab() {
        wait.until(ExpectedConditions.elementToBeClickable(accountTab));
        accountTab.click();
        return new AccountManagePage();
    }

    public OpportunitiesManagePage clickOpportunitiesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesTab));
        opportunitiesTab.click();
        return new OpportunitiesManagePage();

    }
}

