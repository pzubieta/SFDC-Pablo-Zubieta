package pages;

import framework.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo Zubieta on 11/08/2015.
 */
public abstract class DeletorMain  extends MainContainer{

    private WebElement deleteElementBtn;

    public void deleteElement(){
        deleteElementBtn = driver.findElement(By.xpath("//input[@title='Delete']"));
        deleteElementBtn.click();
        Alert deleteAlert = driver.switchTo().alert();
        deleteAlert.accept();
    }

}
