package com.qpros.higher.education.Scenrios;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.helpers.RetryAnalyzer;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.higher.education.admin.DDActions;
import com.qpros.pages.higher.education.admin.ERActions;
import com.qpros.pages.higher.education.admin.PCActions;
import com.qpros.pages.higher.education.client.HEProgram;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class WithoutERTest extends Base {
    LoginPage loginPage;
    HEProgram myProgram;
    DDActions ddActions;
    PCActions pcActions;





    // read fields from excel file
    final String ER_numbers = ReadWriteHelper.readFromExcel
            ("ERHireEducation", "ER", "Number of ER");
    @Test(description = "Submit new program for existing provider ",
            retryAnalyzer = RetryAnalyzer.class,priority = 0)
    public void submitProgramExistingProv() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("HEProvider2",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("HEProvider2", "password"),"HigherApplicantURL");

        //Create program and set configurations and team
        myProgram = new HEProgram(driver);
        myProgram.applyForProgram();
        Assert.assertTrue( myProgram.getThankYouTag().isDisplayed());


    }

    @Test(description = "Submit new program for existing provider ",
            retryAnalyzer = RetryAnalyzer.class,priority = 1)
    public void saveProgramId() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("HEProvider2",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("HEProvider2", "password"),"HigherApplicantURL");

        //Create program and set configurations and team
        myProgram = new HEProgram(driver);
        myProgram.addProgramToFile();

    }
    @Test(description = "Assign to PC ",
            retryAnalyzer = RetryAnalyzer.class,priority = 2)
    public void assignProgramToProvisionManager() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("DivisionDirector",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionDirector", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        ddActions = new DDActions(driver);
        ddActions.findProgram(ReadWriteHelper.getHEApplication());
        ddActions.assignApplication("Hadeel Salameh");

        Assert.assertTrue( ddActions.getSuccessLabel().isDisplayed());


    }
    @Test(description = "Start application by PC ",
            retryAnalyzer = RetryAnalyzer.class,priority = 3)
    public void startReviewByPC() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("ProvisionCoord1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("ProvisionCoord1", "password"), "HigherAdminURL");

        //Create program and set configurations and team
        pcActions = new PCActions(driver);
        pcActions.findProgram(ReadWriteHelper.getHEApplication());
        pcActions.startReviewApplication();
        ActionsHelper.waitForExistance(pcActions.getSuccessStartReviewText(), 30);
        Assert.assertTrue(pcActions.getSuccessStartReviewText().isDisplayed());


    }


    @Test(description = "Send Technical Report by PC ",
            retryAnalyzer = RetryAnalyzer.class,priority = 4)
    public void sendTechnicalReport() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("ProvisionCoord1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("ProvisionCoord1", "password"), "HigherAdminURL");

        //Create program and set configurations and team
        pcActions = new PCActions(driver);
        pcActions.findProgram(ReadWriteHelper.getHEApplication());
        pcActions.sendTechnicalReport();
        ActionsHelper.waitForExistance(pcActions.getSuccessStartReviewText(), 40);
        Assert.assertTrue(pcActions.getSuccessStartReviewText().isDisplayed());


    }

    @Test(description = "Proceed with selected ER Numbers ",
            retryAnalyzer = RetryAnalyzer.class,priority = 5)
    public void proceedWithoutER() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("DivisionDirector",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionDirector", "password"),"HigherAdminURL");

        //Create program and set configurations and team
        ddActions = new DDActions(driver);
        ddActions.findProgram(ReadWriteHelper.getHEApplication());
        ddActions.proceedWithoutER();

        Assert.assertTrue( ddActions.getSuccessLabel().isDisplayed());


    }







}

