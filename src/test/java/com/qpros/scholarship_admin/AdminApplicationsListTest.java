package com.qpros.scholarship_admin;

import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.AdminApplicationsListPage;
import com.qpros.pages.AdminExternalLoginPage;
import com.qpros.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AdminApplicationsListTest  extends Base{
    AdminExternalLoginPage adminExternalLoginPage;
    AdminApplicationsListPage adminApplicationsListPage;
    LoginPage loginPage;

    @Test(description = "Search Applications by Applicant Code, Valid keyword",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByKeyword_ValidResult() throws InterruptedException {
        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee("test.user3@adek.gov.ae", "Adek@12345");
        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.searchByKeyWord_ApplicantCode("PS20074");
        Assert.assertTrue( ActionsHelper.waitVisibility( adminApplicationsListPage.getLblFirstResultCode(), 20 ) );
        System.out.println(adminApplicationsListPage.getResultsCodes().size());
        Assert.assertEquals(adminApplicationsListPage.getResultsCodes().get(0).getText(), "PS20074");
    }

    @Test(description = "Search Applications by Status: [New] ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByStatusDDL() throws InterruptedException {
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee("test.user3@adek.gov.ae", "Adek@12345");

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.searchByStatus("New");
        Thread.sleep(20000);
    }
}
