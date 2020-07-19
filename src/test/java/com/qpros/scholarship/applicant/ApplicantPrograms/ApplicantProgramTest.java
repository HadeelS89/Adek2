package com.qpros.scholarship.applicant.ApplicantPrograms;


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

public class ApplicantProgramTest extends Base {
    private ApplyForProgremPage applyForProgremPage;
    private LoginPage loginPage;
    private MyApplicationsPage myApplicationsPage;

    @Test(description = "Submit Application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
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

    @Test(description = "Submit Application",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void submitProgram() throws Exception {
        loginPage = new LoginPage( driver );
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile(
                "applicantCredentials1"
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


}
