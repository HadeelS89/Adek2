package com.qpros.scholarship.admin.applications;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.admin.AdminApplicationsListPage;
import com.qpros.pages.scholarship.admin.ProgramsPage;
import com.qpros.pages.scholarship.applicant.ApplyForProgremPage;
import com.qpros.pages.scholarship.applicant.MyApplicationsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class SubmitChangedDetailsTest extends Base {

    LoginPage loginPage;
    ProgramsPage programsPage;
    ApplyForProgremPage applyForProgremPage;
    AdminApplicationsListPage adminApplicationsListPage;
    MyApplicationsPage myApplicationsPage;

    @Test(description = "Create new Program",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createProgram() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ) );

        //Create program and set configurations and team
        programsPage = new ProgramsPage( driver );
        programsPage.createFullProgram();

    }

    @Test(description = "Submit Application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 1)// one program
    public void submitProgram() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        //Apply for a program
        applyForProgremPage = new ApplyForProgremPage( driver );
        applyForProgremPage.submitProgram( ReadWriteHelper.getCreatedProgram() );
        Thread.sleep( 5000 );
        //verify the final results ; submit button is not displayed
        WebElement submitButton = null;
        try {
            submitButton = ActionsHelper.getElement( driver, "xpath",
                    "//button[contains(.,'Submit Application')]" );
        } catch (Exception e) {
            Assert.assertTrue( !submitButton.isDisplayed() );
        }

    }

   @Test(description = "Start review a new application",
           retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 2)
    public void startReviewNewApplication() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ) );

        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.clearFilters();
        adminApplicationsListPage.findProgram( ReadWriteHelper.getCreatedProgram() );
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.clickApplicationButton( AdminApplicationsListPage.ButtonsList.StartReview );
    }

    @Test(description = "Request change from recruiter",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 3)
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

    @Test(description = "Submit Application after request for change ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 4)
    public void reSubmitApplicationAfterChange() throws Exception {

        loginPage = new LoginPage(driver);
        // same applicant credentials used on submit program should be used
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.applicationSubmitionAfterChanges(ReadWriteHelper.getCreatedProgram());
        ActionsHelper.waitVisibility(myApplicationsPage.getReSubmitMsg(),50);
        Assert.assertTrue(myApplicationsPage.getReSubmitMsg().isDisplayed());


    }

}
