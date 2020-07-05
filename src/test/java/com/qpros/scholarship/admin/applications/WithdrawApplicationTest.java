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
public class WithdrawApplicationTest extends Base {
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

    @Test(description = "withdraw Application after submitting the program ,test case id [2692 and 2694]" , retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 2)
    public void withdrawApplication() throws Exception {
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.withdrawApplication(ReadWriteHelper.getCreatedProgram());

        Assert.assertTrue(!myApplicationsPage.withdrawResults );


    }
}
