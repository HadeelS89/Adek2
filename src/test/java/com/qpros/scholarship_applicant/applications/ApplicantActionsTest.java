package com.qpros.scholarship_applicant.applications;


import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
//import com.qpros.pages.ApplicantLoginPage;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicantActionsTest extends Base {
    ApplyForProgremPage applyForProgremPage;
    LoginPage loginPage;
    MyApplicationsPage myApplicationsPage;

    @Test(description = "Save one program as draft ")// one programe
    public void saveToDraft() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.saveAsDrat(ReadWriteHelper.getCreatedProgram());
        Assert.assertTrue(ApplyForProgremPage.programTilteLabel.equalsIgnoreCase(ReadWriteHelper.getCreatedProgram()));

    }

    @Test(description = "Apply for one program")// one programe
    public void applyForOne() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.applyForProgram(ReadWriteHelper.getCreatedProgram());
        Assert.assertEquals(applyForProgremPage.getStep1().getText(),
                "Step 1");
    }

    @Test(description = "Submit Application")// one programe
    public void submitProgram() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        //Apply for a program
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.submitProgram(ReadWriteHelper.getCreatedProgram());
        Thread.sleep(5000);
        //verify the final results ; submit button is not displayed
        WebElement submitButton = null;
        try {
            submitButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[contains(.,'Submit Application')]");
        } catch (Exception e) {
            Assert.assertTrue(!submitButton.isDisplayed());
        }

    }

    //this method comes after approved application from admin,acknowledge button enabled
    @Test(description = "acknowledge button displaying test for approved applications ")// one programe
    public void acknowledgeApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        ActionsHelper.waitForExistance(myApplicationsPage.getMyApplication(), 100);
        myApplicationsPage.acknowledgeApplicantion("Q-PROS INTERVIEW1");
        Assert.assertTrue(myApplicationsPage.acknowledgeresult==false);
    }

    @Test(description = "check validation message when click decline by leaving " +
            "the message area empty ")
    public void declineApplicationEmptyMessage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.declineApplicationEmpty("Q-PROS INTERVIEW1");
        Assert.assertTrue(myApplicationsPage.getDeclineValidation().isDisplayed());
    }

    @Test(description = "Check decline application using acknowledgement ")
    public void declineApplicationWithMessage() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.declineApplicationWithMessage("Automation Test 52232");
        Assert.assertTrue(myApplicationsPage.declineResults== false);
    }

    @Test(description = "Accept application using acknowledgement ")
    public void acceptApplication() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.acceptApplication("AUTOMATION TEST 49024");
        Assert.assertTrue(myApplicationsPage.result == false);
    }

    @Test(description = "withdraw Application ")
    public void withdrawApplication() throws Exception {
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.withdrawApplication("AUTOMATION TEST 49024");

            Assert.assertTrue(myApplicationsPage.withdrawResults == false);


    }
    @Test(description = "Submit Application after request for change ")
    public void reSubmitApplicationAfterChange() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));

        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.applicationSubmitionAfterChanges("AUTOMATION TEST 45971");

       Assert.assertTrue(myApplicationsPage.getReSubmitMsg().isDisplayed());


    }
}
