package com.qpros.scholarship.applicant.MyApplications;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.qpros.pages.ApplicantLoginPage;

public class ApplicantActionsTest extends Base {
    private ApplyForProgremPage applyForProgremPage;
    private LoginPage loginPage;
    private MyApplicationsPage myApplicationsPage;


    @Test(description = "Submit Application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 1)// one programe
    public void saveToDrafts() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        //Apply for a program
        applyForProgremPage = new ApplyForProgremPage( driver );
        applyForProgremPage.saveAsDrat( ReadWriteHelper.getCreatedProgram() );

        //verify the final results ; submit button is not displayed
        WebElement submitButton = null;
        try {
            submitButton = ActionsHelper.getElement( driver, "xpath",
                    "//button[contains(.,'Save As Draft'')]" );
        } catch (Exception e) {
            Assert.assertTrue( !submitButton.isDisplayed() );
        }

    }
    //this method comes after approved application from admin,acknowledge button enabled
    @Test(description = "acknowledge button displaying test for approved applications ")// one programe
    public void acknowledgeApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        ActionsHelper.waitForExistance(myApplicationsPage.getMyApplication(), 100);
        myApplicationsPage.acknowledgeApplicantion(ReadWriteHelper.getCreatedProgram());
        Assert.assertTrue(!myApplicationsPage.acknowledgeresult);
    }
    @Test(description = "Check decline application using acknowledgement test case id 2675",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void declineApplicationWithMessage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.declineApplicationWithMessage(ReadWriteHelper.getCreatedProgram());
        Assert.assertTrue(!myApplicationsPage.declineResults);
    }
    @Test(description = "check validation message when click decline by leaving " +
            "the message area empty ")
    public void declineApplicationEmptyMessage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.declineApplicationEmpty(ReadWriteHelper.getCreatedProgram());
        Assert.assertTrue(myApplicationsPage.getDeclineValidation().isDisplayed());
    }

    @Test(description = "Accept application using acknowledgement test case id 2660  ")
    public void acceptAcknowledgementApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile(
                "applicantCredentials1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.acceptApplication(ReadWriteHelper.getCreatedProgram());
        Assert.assertTrue(!myApplicationsPage.result);
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

        Assert.assertTrue(myApplicationsPage.getConfirmWithdrawMessage().isDisplayed() );


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
    @Test (description = "Book and Confirm interview for applicant ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 5)
    public void bookInterview() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.confirmInterview(ReadWriteHelper.getCreatedProgram());
        ActionsHelper.waitForExistance(myApplicationsPage.getCancelInterview(),60);
        Assert.assertTrue(myApplicationsPage.getCancelInterview().isDisplayed());

    }
}
