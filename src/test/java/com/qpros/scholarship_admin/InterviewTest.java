package com.qpros.scholarship_admin;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.InterviewsPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class InterviewTest extends Base {
    LoginPage loginPage;
    InterviewsPage interviewsPage;

    @Test(description = "Create new interview from admin panel",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createInterview() throws Exception {

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Create new interview
        interviewsPage = new InterviewsPage( driver );
        interviewsPage.addNewInterview("Automation Test 79756");
        Assert.assertTrue(interviewsPage.getSuccess().isDisplayed());
        interviewsPage.getBtnOK().click();
    }

    @Test(description = "Add interview Score from admin panel",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addInterviewScore() throws Exception {

        //Navigate to Admin panel
        // driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "interviewer1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "interviewer1", "password" ));

        //Create new interview
        interviewsPage = new InterviewsPage( driver );
        interviewsPage.searchInterview("Automation Test 79756");
        interviewsPage.addScore(driver);
        Assert.assertTrue(interviewsPage.getSuccess().isDisplayed());
        interviewsPage.getBtnOK().click();
    }


}
