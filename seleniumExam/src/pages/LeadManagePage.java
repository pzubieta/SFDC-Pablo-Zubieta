package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Pablo on 8/7/2015.
 */
public class LeadManagePage extends MainContainer{

    @FindBy(linkText = "Create New View")
    private WebElement createNewView;

    public LeadManagePage(WebDriver driver) {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public LeadManagePage ClickNewLead(){
        wait.until(ExpectedConditions.elementToBeClickable(newElementBtn));
        super.newElementBtn.click();
        return new LeadManagePage(driver);
    }


}
