package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import pages.*;

/**
 * Created by Pablo on 8/10/2015.
 */
public class TestCreateAnOpportunity {
    private TabBar tabBar;
    private AccountDetailsPage accountDetailsPage;
    private AccountManagePage accountManagePage;
    private OpportunitiesManagePage opportunitiesManagePage;
    private OpportunitiesAddPage opportunitiesAddPage;
    private OpportunitiesDetailsPage opportunitiesDetailsPage;

    private final String accountName = "pzTestAccount01";
    private final String accountPhone = "76543210";
    private final String accountWeb = "www.pzTestWeb.com";

    private final String opportunityName = "pzTestOpportunity05";
    private final String opportunityCloseDate = "8/15/2015";
    private final String opportunityStage = "Prospecting";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.setEmailTxt("pablo_zo@hotmail.com");
        loginPage.setPasswordTxt("!QA2ws3ed");
        MainApp mainApp = loginPage.clickLoginBtn();

        tabBar = mainApp.goToTabBar();
        accountManagePage = tabBar.clickAccountTab();
        QuickCreateAccountArea quickCreateAccountArea = new QuickCreateAccountArea();
        quickCreateAccountArea.quickCreateNewAccount(accountName,accountPhone,accountWeb);

    }

    @Test
    public void TestCreateAnOpportunity() {
        opportunitiesManagePage = tabBar.clickOpportunitiesTab();
        opportunitiesAddPage = opportunitiesManagePage.ClickNewOpportunity();
        opportunitiesDetailsPage = opportunitiesAddPage.addNewOpportunity(accountName,opportunityName, opportunityCloseDate, opportunityStage);

        Assert.assertEquals(opportunitiesDetailsPage.getOpportunityAccount(), accountName);
        Assert.assertEquals(opportunitiesDetailsPage.getOpportunityName(), opportunityName);
        Assert.assertEquals(opportunitiesDetailsPage.getOpportunityCloseDate(), opportunityCloseDate);
        Assert.assertEquals(opportunitiesDetailsPage.getOpportunityStage(), opportunityStage);
    }

    @AfterClass
    public void tearDown() {

        opportunitiesDetailsPage.deleteElement();
        accountManagePage = tabBar.clickAccountTab();
        accountDetailsPage = accountManagePage.goToAccountDetailsPage(accountName);
        accountDetailsPage.deleteElement();

    }
}
