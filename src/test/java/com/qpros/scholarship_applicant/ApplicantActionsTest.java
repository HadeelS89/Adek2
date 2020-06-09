package com.qpros.scholarship_applicant;


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
        String programTitle = "New Scholarships for Distinguished Students SDS";
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.saveAsDrat(programTitle);
        Assert.assertTrue(ApplyForProgremPage.programTilteLabel.equalsIgnoreCase(programTitle));

    }

    @Test(description = "Apply for one program")// one programe
    public void applyForOne() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.applyForProgram("Scholarships for Distinguished Students");
        Assert.assertEquals(applyForProgremPage.getStep1().getText(),
                "Step 1");
    }

    @Test(description = "Submit Application")// one programe
    public void submitProgram() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.submitProgram("Scholarships for Distinguished Students");
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
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        ActionsHelper.waitForExistance(myApplicationsPage.getMyApplication(), 100);
        myApplicationsPage.acknowledgeApplicantion("Q-PROS INTERVIEW1");
        Assert.assertTrue(myApplicationsPage.result);
    }

    @Test(description = "check validation message when click decline by leaving " +
            "the message area empty ")
    public void declineApplicationEmptyMessage() throws Exception {
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
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
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.declineApplicationWithMessage("Automation Test 52232");
        Assert.assertTrue(myApplicationsPage.result);
    }

    @Test(description = "Accept application using acknowledgement ")
    public void acceptApplication() throws Exception {
        driver.navigate().to(ReadWriteHelper.ReadData("ApplicantURL"));
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("applicantCredentials2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password"));
        myApplicationsPage = new MyApplicationsPage(driver);
        myApplicationsPage.acceptApplication("AUTOMATION TEST 49024");
        Assert.assertTrue(myApplicationsPage.result);
    }
}
