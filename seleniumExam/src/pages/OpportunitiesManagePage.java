package pages;

import framework.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Pablo on 8/10/2015.
 */
public class OpportunitiesManagePage extends MainContainer{

    public OpportunitiesManagePage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public OpportunitiesAddPage ClickNewOpportunity(){
        wait.until(ExpectedConditions.elementToBeClickable(newElementBtn));
        newElementBtn.click();
        return new OpportunitiesAddPage();
    }
}
