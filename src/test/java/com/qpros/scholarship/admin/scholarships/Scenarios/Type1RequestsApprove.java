package com.qpros.scholarship.admin.scholarships.Scenarios;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.applicant.RequestPage;
import com.qpros.pages.scholarship_admin_pages.AdminRequestsPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(com.qpros.reporting.Listeners.class)
public class Type1RequestsApprove extends Base {
    private RequestPage requestPage;

    private LoginPage loginPage;

    private ProgramsPage programsPage;
    private AdminRequestsPage adminRequestsPage;

//    @Test(description = "create request Request to Reimbursement ",
//            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 0)// one programe
    public void createReimbursementRequest() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.ReimbursementRequest);

        //Assert.assertTrue(requestPage.getPassedAssert().isDisplayed());
        // requestPage.saveRequestID();
    }


//    @Test(description = "Approve Reimbursement Request",
//            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveReimbursementRequest() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                        "ReimbursementRequest" ),"false","false","false").
                equalsIgnoreCase("Approved"));
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();

    }


//    @Test(description = "Request an internship change",
//            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToInternshipChange() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar2", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.InternshipChange);

    }
    @Test(description = "Approve Internship Change Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveInternshipChange() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

//        Assert.assertTrue(adminRequestsPage.approveFinancialRequest
//                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
//                        "RegisterInternshipProgram" ),"true","false").
//                equalsIgnoreCase("ApprovedByAdvisor"));
        adminRequestsPage.sharedSteps("PS20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "InternshipChange" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

    }
    @Test(description = "Approve Internship Change Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveRegisterInternshipProgram() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "RegisterInternshipProgram" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
        adminRequestsPage.sharedSteps("PS20316");


    }
    @Test(description = "Request an CancelDiscontinueScholarship change",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToCancelDiscontinueScholarship() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar2"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar2", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.CancelDiscontinueScholarship);

    }
    @Test(description = "Approve CancelDiscontinueScholarship Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveCancelDiscontinueScholarship() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);


        adminRequestsPage.sharedSteps("PS20316");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "CancelDiscontinueScholarship" ),"true",
                        "false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));

    }


    @Test(description = "Approve Change Bank Details Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveChangeBankDetails() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);


        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Financial Requests","dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                        "ChangeBankDetails" ),"true","false","false").
                equalsIgnoreCase("Approved"));

    }

    @Test(description = " Female  requests",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void femaleRequests() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("ScholarFemale"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "ScholarFemale", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

            requestPage.selectRequest(RequestPage.RequestList.Maternity);
        }
    @Test(description = " Approve Female  requests",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe

    public void approveFemaleRequests() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

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

    }

    @Test(description = " Request to cancel or discontinue scholarship",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void cancelDiscontinueScholarshipRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "CancelDiscontinueScholarship" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }

    @Test(description = " Request for extend period of study",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void ExtendPeriodOfStudyRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendPeriodOfStudy" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }


    @Test(description = " Request to extend employee study leave",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void extendEmployeeStudyLeaveRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendEmployeeStudyLeave" ),"true","false",
                        "false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }



    @Test(description = "Approve all Requests by adviser ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void advisorApproval2() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        SoftAssert softAssert= new SoftAssert();

        //==============

        try {
            adminRequestsPage.sharedSteps("PS20298");
            softAssert.assertTrue(adminRequestsPage.approveRequestAdvisor
                    ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                            "Maternity" ),"false","false","false").
                    equalsIgnoreCase("Approved"));
            adminRequestsPage.sharedSteps("PS20298");
        }catch (Exception e){

            System.out.println("Failed");
        }

        try {
            softAssert.assertTrue(adminRequestsPage.approveRequestAdvisor
                    ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                            "RegisterInternshipProgram" ),"true","false","false").
                    equalsIgnoreCase("ApprovedByAdvi"));

        }catch (Exception e) {
            System.out.println("Failed");
        }

        softAssert.assertAll();
    }

    @Test(description = "Approve all Requests by adviser ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void advisorApproval1() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        SoftAssert softAssert= new SoftAssert();

        //==============
        adminRequestsPage.sharedSteps("ps20302");
        try {
            adminRequestsPage.sharedSteps("ps20302");

            softAssert.assertTrue(adminRequestsPage.approveRequestAdvisor
                    ("Scholarship Requests","dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                            "RegisterInternshipProgram" ),"true","false","false").
                    equalsIgnoreCase("ApprovedByAdvis"));
        }catch (Exception e){

            System.out.println("Failed");
        }

       try {
           adminRequestsPage.sharedSteps("ps20302");
           softAssert.assertTrue(adminRequestsPage.approveRequestAdvisor
                   ("Financial Requests", "dtFinancialList", ReadWriteHelper.readCreatedRequest1(
                           "MedicalClaim"), "true", "false", "false").
                   equalsIgnoreCase("ApprovedByAdvisor"));

    }catch (Exception e) {
        System.out.println("Failed");
    }

        softAssert.assertAll();
}

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


    @Test(description = " Drop a Class Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void dropAClassRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "DropAClass" ),"false","false","false").
                equalsIgnoreCase("Approved"));
    }
    @Test(description = " Request to suspend studies",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void SuspendStudiesRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "SuspendStudies" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }


    @Test(description = " Request to study a course",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void studyACourseRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "StudyACourse" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }

    @Test(description = " Change Request Preliminaries ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void preliminariesRequest() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedSteps("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor
                ("Educational Requests","dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "Preliminaries" ),"true","false","false").
                equalsIgnoreCase("ApprovedByAdvisor"));
    }
}
