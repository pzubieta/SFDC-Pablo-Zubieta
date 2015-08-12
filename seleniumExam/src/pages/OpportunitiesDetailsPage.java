package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Pablo Zubieta on 11/08/2015.
 */
public class OpportunitiesDetailsPage extends DeletorMain {

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement opportunityName;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement opportunityAccount;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement opportunityCloseDate;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement opportunityStage;


    public OpportunitiesDetailsPage () {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public String getOpportunityName () {
        return opportunityName.getText();
    }

    public String getOpportunityAccount () {
        return opportunityAccount.getText();
    }

    public String getOpportunityCloseDate () {
        return opportunityCloseDate.getText();
    }

    public String getOpportunityStage () {
        return opportunityStage.getText();
    }



}
