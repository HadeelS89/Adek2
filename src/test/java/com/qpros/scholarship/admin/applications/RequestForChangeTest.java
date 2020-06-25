package com.qpros.scholarship.admin.applications;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestForChangeTest extends Base {

    private LoginPage loginPage;
    private ProgramsPage programsPage;
    private ApplyForProgremPage applyForProgremPage;
    private AdminApplicationsListPage adminApplicationsListPage;

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
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 1)// one programe
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
        adminApplicationsListPage.searchByStatus(
                ReadWriteHelper.readProgramStatusXMLFile( "applicationStatus4",
                        "status" ), true );
        adminApplicationsListPage.requestForChange();
        WebElement changeButton = null;
        boolean isVisable = false;
        try {
            changeButton = ActionsHelper.getElement( driver, "xpath",
                    "//button[@name='button'][3]" );
            isVisable = ActionsHelper.waitForExistance( changeButton, 10 );

        } catch (NullPointerException e) {
        }
        Assert.assertTrue( !isVisable );

    }


}
