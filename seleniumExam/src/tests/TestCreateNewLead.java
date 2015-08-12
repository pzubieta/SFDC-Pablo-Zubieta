package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadManagePage;
import pages.LoginPage;
import pages.MainApp;
import pages.TabBar;

/**
 * Created by Pablo on 8/7/2015.
 */
public class TestCreateNewLead {

    private TabBar tabBar;
    private LeadManagePage leadManagerPage;

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage(); //Pregunta: Por que se utiliza notación seguida en el ejemplo de clase.
        loginPage.setEmailTxt("pablo_zo@hotmail.com");
        loginPage.setPasswordTxt("!QA2ws3ed");
        //loginPage.clickLoginBtn();
        MainApp mainApp = loginPage.clickLoginBtn();

        tabBar = mainApp.goToTabBar();
        leadManagerPage = tabBar.clickLeadTab();
    }

    @Test
    public void TestCreateNewLead() {

        leadManagerPage.ClickNewLead();

    }

//    @AfterClass
//    public void tearDown() {
//        DeleteAlert deleteAlert = tabBar.clickDeleteProject(projectName);
//        deleteAlert.clickOkBtn();
//    }
}