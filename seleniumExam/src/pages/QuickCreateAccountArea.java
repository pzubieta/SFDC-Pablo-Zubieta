package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo on 8/10/2015.
 */
public class QuickCreateAccountArea {


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "quickCreateField")
    @CacheLookup
    private WebElement createNewView;


    @FindBy(id = "2")
    @CacheLookup
    private WebElement accountNameTxt;

    @FindBy(id = "10")
    @CacheLookup
    private WebElement accountPhoneTxt;

    @FindBy(id = "12")
    @CacheLookup
    private WebElement accountWebTxt;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement accountSaveBtn;

    public QuickCreateAccountArea() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void setAccountName(String accountName) {
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);

    }

    public void setAccountPhone(String accountPhone) {
        accountPhoneTxt.clear();
        accountPhoneTxt.sendKeys(accountPhone);

    }

    public void setAccountWeb(String accountWeb) {
        accountWebTxt.clear();
        accountWebTxt.sendKeys(accountWeb);

    }

    public AccountManagePage clickSaveBtn() {
        accountSaveBtn.click();
        return new AccountManagePage();
    }

    public AccountManagePage quickCreateNewAccount (String accountName, String accountPhone, String accountWeb){
        setAccountName(accountName);
        setAccountPhone(accountPhone);
        setAccountWeb(accountWeb);
        return clickSaveBtn();

    }
}
