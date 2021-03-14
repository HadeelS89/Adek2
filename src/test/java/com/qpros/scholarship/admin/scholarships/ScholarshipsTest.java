package com.qpros.scholarship.admin.scholarships;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.FakeMailPage;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import com.qpros.pages.scholarship_admin_pages.ScholarshipsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class ScholarshipsTest extends Base {
    private LoginPage loginPage;
    private ScholarshipsPage scholarshipsPage;
    private ProgramsPage programsPage;

    @Test(description = "add new pay element test cas id 2815",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addScholarshipPayElement() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.
                        readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.findProgram(ReadWriteHelper.getScholarshipProgram());
        scholarshipsPage.addPayElement();
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        // scholarshipsPage.getBtnOK().click();
    }

    @Test(description = "add bank details for scholarship test cas id 2770",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addBankDetails() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.findProgram("Hadeel Program");
        scholarshipsPage.addBankDetails();
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        // scholarshipsPage.getBtnOK().click();
    }

    @Test(description = "add new pay enrollment from admin ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addEnrollment() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.selectAdvisor("All", "Added New 08");
        scholarshipsPage.addEnrollment();
        ActionsHelper.waitForExistance(scholarshipsPage.getSuccess(), 60);
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        // scholarshipsPage.getBtnOK().click();
    }


    @Test(description = "add new transcript from admin",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addTranscript() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.selectAdvisor("Tester 1", "Activation Program 02");
        scholarshipsPage.addTranscript();
        ActionsHelper.waitForExistance(scholarshipsPage.getSuccess(), 60);
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        scholarshipsPage.getBtnOK().click();
        ActionsHelper.waitForExistance(scholarshipsPage.getIndecatorArea(), 50);
        Assert.assertTrue(scholarshipsPage.getIndecator().equals(scholarshipsPage.getIndecatorArea().getText()));
    }

    @Test(description = "add new transcript from admin",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void generateLetter() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.selectAdvisor("All", "Activation Program 02");// scholarshipsPage.finalCompare();
        scholarshipsPage.generateLetter();

        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        scholarshipsPage.getBtnOK().click();

        //Verify received email
        FakeMailPage email = new FakeMailPage(driver);
        email.checkReceivedEmail(driver);

    }



    @Test(description = "check letter Key after program team letter",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    //this method should be done after method templateConfiguration("Added ");
    public void checkLetterKey() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.selectAdvisor("Tester 1", "Added New 08");// scholarshipsPage.finalCompare();
        programsPage = new ProgramsPage( driver );
        programsPage.templateConfiguration("");
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        scholarshipsPage.getBtnOK().click();
    }
}
