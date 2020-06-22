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


    @org.testng.annotations.Test(description = "Set Program Team",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 0)
    public void setProgramTeam() throws Exception {
        System.out.println("Test 1");

    }

    @org.testng.annotations.Test(description = "Submit Application", priority = 1)// one programe
    public void submitProgram() throws Exception {
        System.out.println("Test 2");
    }

    @org.testng.annotations.Test(description = "Search Applications by Applicant Code, Valid keyword",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 2)
    public void searchApplicationsAndProcessThem() throws Exception {
        System.out.println("Test 3");
    }

    @org.testng.annotations.Test(description = "Schedule interview from recruiter", priority = 3)
    public void scheduleInterview() throws Exception {
        System.out.println(ActionsHelper.getFutureDate( 0,
                0,0 ));
    }

    // missing step add new inetrview from
    // then ::
    @org.testng.annotations.Test(description = "Confirm interview for applicant ", enabled = false)
    public void confirmInerview() throws Exception {
        System.out.println("Test 5");
    }


    public static void main(String[] args){
        String x = "Moahmmed-Mohaidat";
        System.out.println(ActionsHelper.getFutureDate( 0,
                0,0 ));
    }

}
