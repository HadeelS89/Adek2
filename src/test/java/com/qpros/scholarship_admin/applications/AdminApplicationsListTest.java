package com.qpros.scholarship_admin.applications;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import com.qpros.pages.authorization_pages.AdminExternalLoginPage;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.scholarship_applicant.applications.ApplicantActionsTest;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AdminApplicationsListTest  extends Base{
    AdminExternalLoginPage adminExternalLoginPage;
    AdminApplicationsListPage adminApplicationsListPage;
    LoginPage loginPage;
    ApplicantActionsTest applicantActionsTest;

    @Test(description = "Search Applications by Applicant Code, Valid keyword"

            ,retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByKeyword_ValidResult() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.searchByKeyWord_ApplicantCode("PS20074");
        Assert.assertTrue( ActionsHelper.waitVisibility( adminApplicationsListPage.getLblFirstResultCode(), 20 ) );
        System.out.println(adminApplicationsListPage.getResultsCodes().size());
        Assert.assertEquals(adminApplicationsListPage.getResultsCodes().get(0).getText(), "PS20074");
    }

    @Test(description = "Search Applications by Status: [New] ")
           // ,retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsByStatusDDL() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        Thread.sleep(20000);
        System.out.println(adminApplicationsListPage.getResultsCodes().size());
        Assert.assertEquals(adminApplicationsListPage.getResultsCodes().get(0).getText(), "PS20043");
        adminApplicationsListPage.getResultsCodes().get(0).click();
        Assert.assertTrue(adminApplicationsListPage.getBtnStartReviews().get(0).isDisplayed());

    }

    @Test(description = "Search Applications by Applicant Code, Valid keyword",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void searchApplicationsAndProcessThem() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram() );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.goNextStepProgram(2);
    }

    @Test(description = "Start review a new application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void startReviewNewApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.clearFilters();
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.StartReview);
    }


    @Test(description = "Approves a new application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void approveNewApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.clearFilters();
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.StartReview);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.ApplicationReviewCompleted);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.ApplicationDocumentsVerified);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.ApproveAndProceedToAcknowledgement);
    }

    @Test(description = "Rejects a new application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void rejectNewApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "interviewer1", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.clearFilters();
        adminApplicationsListPage.findProgram( "Automation Test 51221" );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.StartReview);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.RejectApplication);
    }

    @Test(description = "Mark Application as Present from admin")
    public void markApplicationAsPresent() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials2", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.readApplicationsXMLFile(
                "applicationId3", "title"));
        adminApplicationsListPage.searchByStatus(
                ReadWriteHelper.readProgramStatusXMLFile("applicationStatus3",
                        "status"), true);
        adminApplicationsListPage.applicantPresent();
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
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("adminCredentials1", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials2", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.readApplicationsXMLFile(
                "applicationId2", "title"));
        adminApplicationsListPage.searchByStatus
                (ReadWriteHelper.readProgramStatusXMLFile("applicationStatus3",
                        "status"), true);
        adminApplicationsListPage.applicantAbsent();
        WebElement absenceButton = null;
        try {
            absenceButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[@name='button'][2]");
        } catch (Exception e) {

        }

        Assert.assertTrue(absenceButton == null);
    }

    @Test(description = "Schedule interview from recruiter")
    public void scheduleInterview() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.readApplicationsXMLFile(
                "applicationIName1","title"));
        adminApplicationsListPage.searchByStatus(
                ReadWriteHelper.readProgramStatusXMLFile("applicationStatus2",
                        "status"), true);
        adminApplicationsListPage.scheduleInterview();
        WebElement scheduleIntervButton = null;
        try {
            scheduleIntervButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[@name='button'][3]");
        } catch (Exception e) {

        }

        Assert.assertTrue(scheduleIntervButton == null);
    }

    @Test(description = "Request change from recruiter")
    public void requestForChange() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.searchByStatus(
                ReadWriteHelper.readProgramStatusXMLFile("applicationStatus4",
                        "status"), true);
        adminApplicationsListPage.requestForChange();
        WebElement changeButton = null;
        boolean isVisable = false;
        try {
            changeButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[@name='button'][3]");
            isVisable = ActionsHelper.waitForExistance(changeButton, 10);

        } catch (Exception e) {

        }
        Assert.assertTrue(isVisable == false);

    }

    @Test(description = "Activate Form ")
    public void activationForm() throws Exception {

        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile
                        ("interviewer1", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("interviewer1", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram("Automation Test 51221");
        adminApplicationsListPage.searchByStatus(
                ReadWriteHelper.readProgramStatusXMLFile("applicationStatus5",
                        "status"), true);
        adminApplicationsListPage.activationForm();
        Assert.assertTrue(adminApplicationsListPage.getSuccess().isDisplayed());
       // adminApplicationsListPage.getBtnOK().click();

    }
}
