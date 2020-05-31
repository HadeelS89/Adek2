package com.qpros.scholarship_applicant;


import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.pages.ApplyForProgremPage;
import com.qpros.pages.LoginPage;
//import com.qpros.pages.MyApplications;
import com.qpros.pages.MyApplicationsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyApplicationTest extends Base {
    LoginPage loginPage;
    MyApplicationsPage myApplication1;

    @Test (description = "Perform some edits on drafted application on my application page " )
    public void login() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        myApplication1 = new MyApplicationsPage(driver);
        myApplication1.checkProgramName("NEW SCHOLARSHIPS FOR " +
                "DISTINGUISHED STUDENTS SDS");
    }
}
