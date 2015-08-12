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
 * Created by Pablo on 8/7/2015.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement emailTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public LoginPage setEmailTxt(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordTxt(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public MainApp clickLoginBtn() {
        loginBtn.click();
        return new MainApp(driver);
    }


}