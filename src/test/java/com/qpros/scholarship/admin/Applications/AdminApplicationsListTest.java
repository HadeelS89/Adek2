package com.qpros.scholarship.admin.Applications;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import com.qpros.pages.authorization_pages.AdminExternalLoginPage;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.scholarship.applicant.MyApplications.ApplicantActionsTest;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AdminApplicationsListTest  extends Base{
    AdminExternalLoginPage adminExternalLoginPage;
    private AdminApplicationsListPage adminApplicationsListPage;
    private LoginPage loginPage;
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

    @Test(description = "Approves a new application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveNewApplication() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ) );

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.clearFilters();
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram() );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.StartReview );
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.ApplicationReviewCompleted );
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.ApplicationDocumentsVerified );
    }
    @Test(description = "Approves a new application with Acknowledgement",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void approveNewApplicationWithAck() throws Exception {
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




    @Test(description = "Rejects a new application test case id [2658 , 2658 and 2841]",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void rejectNewApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ));

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.findProgram(ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.StartReview);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.RejectApplication);
    }

    @Test(description = "Schedule interview from recruiter",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void scheduleInterview() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile
                        ( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile
                        ( "recruiterCredentials3", "password" ) );

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram() );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.ScheduleInterview );
        ActionsHelper.waitForExistance(adminApplicationsListPage.getWorkflowArea(),60);
        WebElement scheduleIntervButton = null;
        try {
            scheduleIntervButton = ActionsHelper.getElementFromList( adminApplicationsListPage.getApplicationButtons(),
                    "Schedule Interview" );
        } catch (Exception e) {

        }

        Assert.assertTrue( scheduleIntervButton == null );
    }

    @Test(description = "Mark Application as Present from admin")
    public void markApplicationAsPresent() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage
                .ButtonsList.ApplicantPresent);
        ActionsHelper.waitForExistance(adminApplicationsListPage.getWorkflowArea(),60);

        WebElement presentButton = null;
        try {
            presentButton = ActionsHelper.getElementFromList( adminApplicationsListPage.getApplicationButtons(),
                    "Applicant Present" );
        } catch (Exception e) {

        }
        Assert.assertTrue(presentButton == null);

    }
    @Test(description = "Mark Application as Absence from admin")
    public void markApplicationAsAbsence() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.getCreatedProgram());
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage
                .ButtonsList.ApplicantAbsent);
        adminApplicationsListPage.clickApplicationButton(AdminApplicationsListPage.ButtonsList.RejectApplication);
        ActionsHelper.waitForExistance(adminApplicationsListPage.getWorkflowArea(),60);
        WebElement absenceButton = null;
        try {
            ActionsHelper.getElementFromList( adminApplicationsListPage.getApplicationButtons(),
                    "Reject Application" );
        } catch (Exception e) {

        }

        Assert.assertTrue(absenceButton == null);
    }


    @Test(description = "Request change from recruiter",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void requestForChange() throws Exception {
        //Request for change reviewed application
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile
                        ( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile
                        ( "recruiterCredentials3", "password" ) );

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram() );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.RequestForChange);
        ActionsHelper.waitForExistance(adminApplicationsListPage.getWorkflowArea(),60);
        WebElement changeButton = null;
        try {
            changeButton = ActionsHelper.getElementFromList( adminApplicationsListPage.getApplicationButtons(),
                    "Request For Change" );
        } catch (Exception e) {

        }
        Assert.assertTrue(changeButton == null);
    }


    @Test(description = "Activate Form ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void activationForm() throws Exception {

        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));

        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ReadWriteHelper.getCreatedProgram());

        adminApplicationsListPage.activationForm();
        Assert.assertTrue(adminApplicationsListPage.getSucessLabel().get(0).isDisplayed());
        // adminApplicationsListPage.getBtnOK().click();

    }
}
