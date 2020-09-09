package com.qpros.scholarship.applicant.applications;


import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
import com.qpros.common.Requester;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.sholarship_applicant_pages.MyApplicationsPage;
import okhttp3.Request;
import org.testng.annotations.Test;

import java.util.HashMap;

//import com.qpros.pages.MyApplications;

public class MyApplicationTest extends Base {
    LoginPage loginPage;
    private MyApplicationsPage myApplication1;


    @Test(description = "Perform some edits on drafted application on my application page ")
    public void login() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        myApplication1 = new MyApplicationsPage(driver);
        // myApplication1.checkProgramName("NEW SCHOLARSHIPS FOR " +
        //       "DISTINGUISHED STUDENTS SDS");
    }

    @Test(description = "Perform some edits on drafted application on my application page ")
    public void logins() throws Exception {
        HashMap<String,String> params= new HashMap<>();
        params.put("title","test");
        params.put("search","test");
        Requester requester= new Requester();
        Request request=requester.request(Requester.Verb.POST,"http://Autoserver:8080","/externalhelper-email/api/v1/email/check",params,null);
        requester.response(request);

    }
}
