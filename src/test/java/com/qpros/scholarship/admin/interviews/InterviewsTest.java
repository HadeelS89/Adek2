package com.qpros.scholarship.admin.interviews;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.InterviewsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(com.qpros.reporting.Listeners.class)
public class InterviewsTest extends Base {
    private LoginPage loginPage;
    private InterviewsPage interviewsPage;

    @Test(description = "Create new interview from admin panel",

            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createInterview() throws InterruptedException, IOException {
        //Login as Program Manager
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "interviewer1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "interviewer1", "password" ) );

        //Create new interview
        interviewsPage = new InterviewsPage( driver );
        interviewsPage.addNewInterview( ReadWriteHelper.getCreatedProgram() );
        Assert.assertTrue( interviewsPage.getSuccess().isDisplayed() );
        interviewsPage.getBtnOK().click();
    }


    @Test(description = "Add interview Score from admin panel",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class )
    public void fillInterviewScore() throws Exception {

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "recruiterCredentials3", "password" ));

        //Create new interview
        interviewsPage = new InterviewsPage( driver );
        interviewsPage.searchInterview(ReadWriteHelper.getCreatedProgram());
        interviewsPage.addScore(driver);
        Assert.assertTrue(interviewsPage.getScoreSuccessText().isDisplayed());
    }


}
