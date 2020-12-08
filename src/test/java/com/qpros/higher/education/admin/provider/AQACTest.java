package com.qpros.higher.education.admin.provider;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.helpers.RetryAnalyzer;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.higher.education.admin.AQACSecretary;
import com.qpros.pages.higher.education.admin.DDActions;
import com.qpros.scholarship.admin.applicationsScenarios.AcceptAcknowledgeApplsTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AQACTest extends Base {
    LoginPage loginPage;
    DDActions ddActions;
    AQACSecretary aQACSecretary;

    // read fields from excel file
    final String ER_numbers = ReadWriteHelper.readFromExcel
            ("ERHireEducation", "ER", "Number of ER");

    @Test(description = "Schedule Meeting by AQAC Secretary",
            retryAnalyzer = RetryAnalyzer.class)
    public void scheduleMeeting() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("AQACSecretary",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("AQACSecretary", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        aQACSecretary = new AQACSecretary(driver);

        aQACSecretary.scheduleMeeting(ReadWriteHelper.getHEApplication());
        ActionsHelper.waitForListExistance(aQACSecretary.getScheduleMeetingBtn(),80);
       Assert.assertTrue( aQACSecretary.getScheduleMeetingBtn().get(1).isDisplayed());


    }
    @Test(description = "Issue NOL by AQAC secretary ",
            retryAnalyzer = RetryAnalyzer.class)
    public void issueNOL() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("AQACSecretary",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("AQACSecretary", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        aQACSecretary = new AQACSecretary(driver);

        aQACSecretary.findProgram(ReadWriteHelper.getHEApplication());
        aQACSecretary.issueNOL();
       // ActionsHelper.waitForListExistance(aQACSecretary.getScheduleMeetingBtn(),80);
        //Assert.assertTrue( aQACSecretary.getScheduleMeetingBtn().get(1).isDisplayed());



    }
    @Test(description = "Proceed with selected ER Numbers ",
            retryAnalyzer = RetryAnalyzer.class)
    public void proceedWithER() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("DivisionDirector",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionDirector", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        ddActions = new DDActions(driver);
        ddActions.findProgram(ReadWriteHelper.getHEApplication());
        ddActions.proceedWithER(ER_numbers);

        Assert.assertTrue( ddActions.getSuccessLabel().isDisplayed());


    }



    @Test(description = "DD accepts all the ERs ",
            retryAnalyzer = RetryAnalyzer.class)
    public void acceptAllReviewersByDD() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("DivisionDirector",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionDirector", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        ddActions = new DDActions(driver);
        ddActions.findProgram(ReadWriteHelper.getHEApplication());
        ddActions.acceptAllReviewers();

        Assert.assertTrue( ddActions.getSuccessLabel().isDisplayed());


    }

    @Test(description = "DD request to change one  ER ",
            retryAnalyzer = RetryAnalyzer.class)
    public void requestToChangeER() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("DivisionDirector",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionDirector", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        ddActions = new DDActions(driver);
        ddActions.findProgram(ReadWriteHelper.getHEApplication());
        ddActions.requestToChangeER();

       // Assert.assertTrue( ddActions.getSuccessLabel().isDisplayed());


    }
}

