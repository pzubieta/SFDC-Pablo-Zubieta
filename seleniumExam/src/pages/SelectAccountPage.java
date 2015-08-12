package pages;

import framework.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo on 8/10/2015.
 */
public class SelectAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement accountSelector;

    private WebElement goBtn;
    private WebElement accoutSrchInput;


    public SelectAccountPage() {
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public void ClickAccount(String accountTxt){
        accountSelector = driver.findElement(By.xpath("//a[contains(.,'" + accountTxt + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable(accountSelector));
        accountSelector.click();
    }

    public void searchAccount(String accountTxt){
        String title = driver.getTitle();
        System.out.println(title);

        goBtn = driver.findElement(By.name("go"));
        accoutSrchInput = driver.findElement(By.id("lksrch"));

        accoutSrchInput.clear();
        accoutSrchInput.sendKeys(accountTxt);

        goBtn.click();

    }
}
