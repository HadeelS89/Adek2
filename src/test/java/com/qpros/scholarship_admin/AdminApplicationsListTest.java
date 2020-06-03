package com.qpros.scholarship_admin;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import com.qpros.pages.authorization_pages.AdminExternalLoginPage;
import com.qpros.pages.authorization_pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AdminApplicationsListTest extends Base {
    AdminExternalLoginPage adminExternalLoginPage;
    AdminApplicationsListPage adminApplicationsListPage;
    LoginPage loginPage;


    @Test(description = "Search Applications by Applicant Code, Valid keyword",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByKeyword_ValidResult() throws InterruptedException {
        //Navigate to Admin panel
        driver.navigate().to(ReadWriteHelper.ReadData("AdminURL"));

        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "password"));
        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.searchByKeyWord_ApplicantCode("PS20074");
        Assert.assertTrue(ActionsHelper.waitVisibility(
                adminApplicationsListPage.getLblFirstResultCode(), 20));
        System.out.println(adminApplicationsListPage.getResultsCodes().size());
        Assert.assertEquals(adminApplicationsListPage.getResultsCodes()
                .get(0).getText(), "PS20074");
    }

    @Test(description = "Search Applications by Status: [New] ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByStatusDDL() throws InterruptedException {
        driver.navigate().to(ReadWriteHelper.ReadData("AdminURL"));

        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.searchByStatus("New", true);
        Thread.sleep(20000);
        System.out.println(adminApplicationsListPage.getResultsCodes().size());
        Assert.assertEquals(adminApplicationsListPage.getResultsCodes().get(0).getText(), "PS20043");
        adminApplicationsListPage.getResultsCodes().get(0).click();
        Assert.assertTrue(adminApplicationsListPage.getBtnStartReviews().get(0).isDisplayed());

    }

    @Test(description = "Mark Application as Present from admin")
    public void markApplicationAsPresent() throws Exception {
        //Navigate to Admin panel
        driver.navigate().to(ReadWriteHelper.ReadData("AdminURL"));
        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials2", "password"));
        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.applicantPresent(ReadWriteHelper.readApplicationsXMLFile(
                "applicationId3", "title"));
        WebElement presentButton = null;
        try {
            presentButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[@name='button']");
        } catch (Exception e) {

        }
        Assert.assertTrue(presentButton == null);
    }

    @Test(description = "Mark Application as Absence from admin")
    public void markApplicationAsAbsence() throws Exception {
        //Navigate to Admin panel
        driver.navigate().to(ReadWriteHelper.ReadData("AdminURL"));
        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials2", "password"));
        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.applicantAbsent(ReadWriteHelper.readApplicationsXMLFile(
                "applicationId2", "title"));
        WebElement absenceButton = null;
        try {
            absenceButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[@name='button'][2]");
        } catch (Exception e) {

        }

        Assert.assertTrue(absenceButton == null);
    }

}
