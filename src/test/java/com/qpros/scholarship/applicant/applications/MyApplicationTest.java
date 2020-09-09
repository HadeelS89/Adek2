package com.qpros.scholarship.applicant.applications;


import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.applicant.MyApplicationsPage;
import org.testng.annotations.Test;

//import com.qpros.pages.MyApplications;

public class MyApplicationTest extends Base {
    LoginPage loginPage;
    private MyApplicationsPage myApplication1;


    @Test (description = "Perform some edits on drafted application on my application page " )
    public void login() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        myApplication1 = new MyApplicationsPage(driver);
       // myApplication1.checkProgramName("NEW SCHOLARSHIPS FOR " +
         //       "DISTINGUISHED STUDENTS SDS");
    }
}
