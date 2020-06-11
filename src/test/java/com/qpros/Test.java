package com.qpros;

import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test extends Base {
LoginPage loginPage;
ProgramsPage programsPage;
ApplyForProgremPage applyForProgremPage;
AdminApplicationsListPage  adminApplicationsListPage;
MyApplicationsPage myApplication1;

    @org.testng.annotations.Test(description = "Set Program Team",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 0)
    public void setProgramTeam() throws Exception {

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Set program configurations
        programsPage = new ProgramsPage( driver );
        programsPage.setProgramTeam();

    }

    @org.testng.annotations.Test(description = "Submit Application",priority = 1 )// one programe
    public void submitProgram() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.submitProgram(ProgramsPage.randomName);
        Thread.sleep(5000);
        //verify the final results ; submit button is not displayed
        WebElement submitButton = null;
        try{
            submitButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[contains(.,'Submit Application')]");
        }catch(Exception e){
            Assert.assertTrue(!submitButton.isDisplayed());
        }

    }

    @org.testng.annotations.Test(description = "Search Applications by Applicant Code, Valid keyword",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 2)
    public void searchApplicationsAndProcessThem() throws Exception {
        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "password" ));
        adminApplicationsListPage = new AdminApplicationsListPage( driver );
        adminApplicationsListPage.findProgram( ProgramsPage.randomName);
        adminApplicationsListPage.searchByStatus("New", true);
        adminApplicationsListPage.selectFirstResult();
        adminApplicationsListPage.goNextStepProgram(2);
    }

    @org.testng.annotations.Test(description = "Schedule interview from recruiter",priority = 3)
    public void scheduleInterview() throws Exception {
        //Navigate to Admin panel
        driver.navigate().to(ReadWriteHelper.ReadData("AdminURL"));
        loginPage = new LoginPage(driver);

        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "username"),
                ReadWriteHelper.readCredentialsXMLFile
                        ("recruiterCredentials3", "password"));
        adminApplicationsListPage = new AdminApplicationsListPage(driver);
        adminApplicationsListPage.findProgram(ProgramsPage.randomName);
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

        Assert.assertTrue(!ActionsHelper.waitForExistance(adminApplicationsListPage.getBtnOk(),5));
    }
// missing step add new inetrview from
    // then ::
@org.testng.annotations.Test(description = "Confirm interview for applicant ",enabled = false)
public void confirmInerview() throws Exception {
    driver.navigate().to( ReadWriteHelper.ReadData("ApplicantURL"));
    LoginPage loginPage = new LoginPage(driver);

    loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials2"
            , "username" ),
            ReadWriteHelper.readCredentialsXMLFile(
                    "applicantCredentials2", "password" ) );

    myApplication1 = new MyApplicationsPage(driver);
    myApplication1.confirmInterview(ReadWriteHelper.readProgramsXMLFile(
            "program19"
            ,"title"));

    Assert.assertTrue(myApplication1.getCancelInterview().isDisplayed());





}

}
