package pages;

import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Pablo on 8/7/2015.
 */
public class MainApp extends MainContainer{

    public MainApp(WebDriver driver) {
        this.driver = driver;
        wait = WebDriverManager.getInstance().getWait();

    }

    public TabBar goToTabBar() {
        return new TabBar(driver);
    }

}

