package com.qpros.scholarship.applicant.activeScholarships;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.sholarship_applicant_pages.ActiveScholarshipsPage;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.qpros.pages.ApplicantLoginPage;

public class ActiveScholarshipTest extends Base {
    private ActiveScholarshipsPage activeScholarshipsPage;
    private ApplyForProgremPage applyForProgremPage;
    private LoginPage loginPage;
    private MyApplicationsPage myApplicationsPage;

    @Test(description = "Add new Enrollment from applicant side ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void addNewEnrollment() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials4"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials4", "password" ) );
        //Apply for a program
        activeScholarshipsPage = new ActiveScholarshipsPage( driver );
        activeScholarshipsPage.addNewEnrollment(  );
        Assert.assertTrue( activeScholarshipsPage.getSuccessMsg().isDisplayed() );

    }

    @Test(description = "Add new Transcript from applicant side ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void addNewTranscript() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials4"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials4", "password" ) );
        //Apply for a program
        activeScholarshipsPage = new ActiveScholarshipsPage( driver );
        activeScholarshipsPage.addNewTranscript(  );
       Assert.assertTrue( activeScholarshipsPage.getSuccessMsg().isDisplayed() );


    }
}
