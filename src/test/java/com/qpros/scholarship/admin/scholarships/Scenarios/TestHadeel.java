package com.qpros.scholarship.admin.scholarships.Scenarios;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import com.qpros.pages.scholarship_admin_pages.AdminRequestsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class TestHadeel extends Base {
    private LoginPage loginPage;

    private ProgramsPage programsPage;
    private AdminRequestsPage adminRequestsPage;







    @Test(description = "Approve all Requests by adviser ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void advisorApproval() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        //==============
        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                "ReimbursementRequest" ),"false","false","false").
                equalsIgnoreCase("Approved"));
 adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                        "MedicalClaim" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
//        adminRequestsPage.sharedSteps("PS20316");
//        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
//                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
//                        "ChangeBankDetails" ),"false","true","false").
//                equalsIgnoreCase("Approved"));
        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "RegisterInternshipProgram" ),"true","false","false").
              equalsIgnoreCase("ApprovedByAdvisor"));
        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "InternshipChange" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
// female request
        adminRequestsPage.sharedSteps("PS20298");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "Maternity" ),"false","false","false").
                equalsIgnoreCase("Approved"));
        adminRequestsPage.sharedSteps("PS20298");

        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                        "Chaperone" ),"false","false","false").
                equalsIgnoreCase("Approved"));

//==================Request to cancel or discontinue scholarship

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "CancelDiscontinueScholarship" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

        //==================Request for extend period of study

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendPeriodOfStudy" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

        //==================Request to extend employee study leave

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendEmployeeStudyLeave" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
        //==================Drop a Class Request

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "DropAClass" ),"false","false","false").
                equalsIgnoreCase("Approved"));
//==================Request to suspend studies

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "SuspendStudies" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

        //==================Request to study a course

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "StudyACourse" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
        //==================Change Request Preliminaries

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "Preliminaries" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

//=============letters approval
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.approveLetters(ReadWriteHelper.readCreatedRequest1("ToWhomItMayConcern"));
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.approveLetters(ReadWriteHelper.readCreatedRequest1("NationalService"));
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();
    }
    @Test(description = "reject Reimbursement Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void rejectReimbursementRequest() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.rejectReimbursementRequests(ReadWriteHelper.readCreatedRequest1("ReimbursementRequest"));
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();

    }
    @Test(description = "Approve Letters",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void approveLetters() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.approveLetters(ReadWriteHelper.readCreatedRequest1("ToWhomItMayConcern"));
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.approveLetters(ReadWriteHelper.readCreatedRequest1("NationalService"));
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();

    }
    @Test(description = "Reject Letters",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void rejectLetters() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        adminRequestsPage.sharedSteps("ps20302");
        adminRequestsPage.rejectLetters(ReadWriteHelper.readCreatedRequest1("ToWhomItMayConcern"));
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();

    }
}
