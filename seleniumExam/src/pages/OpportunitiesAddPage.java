package pages;

import framework.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Pablo on 8/10/2015.
 */
public class OpportunitiesAddPage extends MainContainer{

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityNameInput;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement opportunityStageSel;

    @FindBy(className = "lookupIcon")
    @CacheLookup
    private WebElement lookupIcon;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement opportunityCloseDate;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;
    private String opportunityNameStr;

    public OpportunitiesAddPage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    private void setOpportunityName(String opportunityName) {
        opportunityNameInput.clear();
        opportunityNameInput.sendKeys(opportunityName);
    }

    private void setOpportunityCloseDate(String opportunityCloseDateStr)
    {
        opportunityCloseDate.clear();
        opportunityCloseDate.sendKeys(opportunityCloseDateStr);
    }

    private void setOpportunityStage(String OpportunityStage)
    {
        wait.until(ExpectedConditions.elementToBeClickable(opportunityStageSel));
        Select SelectopportunityStage = new Select(opportunityStageSel);
        SelectopportunityStage.selectByVisibleText(OpportunityStage);
    }
    public OpportunitiesDetailsPage addNewOpportunity (String oppAccount, String oppName, String oppCloseDate, String oppStage){
        SelectAccountPage selectAccountPage = new SelectAccountPage();
        setOpportunityStage(oppStage);
        setOpportunityCloseDate(oppCloseDate);
        setOpportunityName(oppName);

        lookupIcon.click();

        lookupSelector(oppAccount, selectAccountPage);
        return new OpportunitiesDetailsPage();

    }

    private void lookupSelector(String oppAccount, SelectAccountPage selectAccountPage) {
        try {

            Set<String> setWindows = driver.getWindowHandles();
            LinkedList<String> listWindows = new LinkedList<>(setWindows);//Switching to the account selection page.
            driver.switchTo().window(listWindows.getLast());
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("searchFrame"))));

            WebElement searchFrame = driver.findElement(By.id("searchFrame"));

            driver.switchTo().frame(searchFrame);

            selectAccountPage.searchAccount(oppAccount);

          //Switching to the last page again since it cannot switch to the results frame from the searchFrame.
            driver.switchTo().window(listWindows.getLast());
            driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
            selectAccountPage.ClickAccount(oppAccount);

          //Returning again to the first page
            driver.switchTo().window(listWindows.getFirst());

            saveBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
