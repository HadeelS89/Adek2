package com.qpros.scholarship_applicant;


//import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.qpros.pages.MyApplications;

public class ConfirmInterviewTest extends Base {
    LoginPage loginPage;
    MyApplicationsPage myApplication1;

    @Test (description = "Confirm interview for applicant " )
    public void confirmInerview() throws Exception {
        driver.navigate().to( ReadWriteHelper.ReadData("ApplicantURL"));
        LoginPage loginPage = new LoginPage(driver);

        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials2"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials2", "password" ) );

        myApplication1 = new MyApplicationsPage(driver);
        myApplication1.confirmInterview(ReadWriteHelper.readProgramsXMLFile(
                "User4Program"
        ,"title"));

        Assert.assertTrue(myApplication1.getCancelInterview().isDisplayed());





    }
}
