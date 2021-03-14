package com.qpros.scholarship.admin.scholarships.Scenarios;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.applicant.RequestPage;
import com.qpros.pages.scholarship_admin_pages.AdminRequestsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class Type2RequestsApprove extends Base {
    private RequestPage requestPage;

    private LoginPage loginPage;

    private AdminRequestsPage adminRequestsPage;





    @Test(description = "Request an internship change",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
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
    @Test(description = "Approve Internship Change Request by section Manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveInternshipChange() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Scholarship Requests"),"dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "InternshipChange" ),
                "false","false","true").
                equalsIgnoreCase("completed"));

    }
    @Test(description = "Approve Register into an internship program by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveRegisterInternshipProgram() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("PS20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Scholarship Requests"),"dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "RegisterInternshipProgram" ),
                "false","false","false").
                equalsIgnoreCase("completed"));

    }

    @Test(description = "Approve Request to cancel or discontinue scholarship by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveCancelDiscontinueScholarship() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Scholarship Requests"),"dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "CancelDiscontinueScholarship" ),
                "false","false","false").
                equalsIgnoreCase("ApprovedBySectionManager"));

    }
    @Test(description = "Approve Request for extend period of study by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveExtendPeriodOfStudy() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Scholarship Requests"),"dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendPeriodOfStudy" ),
                "false","false","false").
                equalsIgnoreCase("ApprovedBySectionManager"));

    }
    @Test(description = "Approve Request to extend employee study leave by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveExtendEmployeeStudyLeave() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Scholarship Requests"),"dtScholarshipRequestList",ReadWriteHelper.readCreatedRequest1(
                        "ExtendEmployeeStudyLeave" ),
                "false","false","false").
                equalsIgnoreCase("ApprovedBySectionManager"));

    }
    @Test(description = "Approve Request a medical claim not covered in insurance by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveMedicalClaim() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Financial Requests"),"dtFinancialList",ReadWriteHelper.readCreatedRequest1(
                        "MedicalClaim" ),
                "false","false","false").
                equalsIgnoreCase("Completed"));

    }


    @Test(description = "Approve Request to suspend studies by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveSuspendStudies() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Educational Requests"),"dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "SuspendStudies" ),
                "false","false","false").
                equalsIgnoreCase("Completed"));

    }

    @Test(description = "Approve Request to suspend studies by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approveStudyACourse() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Educational Requests"),"dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "StudyACourse" ),
                "false","false","false").
                equalsIgnoreCase("Completed"));

    }

    @Test(description = "Approve Change Request Preliminaries by section manager",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void approvePreliminaries() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("sectionManager",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("sectionManager", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);

        adminRequestsPage.sharedStepsAndFilter("ps20302");
        Assert.assertTrue(adminRequestsPage.approveRequestAdvisor(
                ("Educational Requests"),"dtPreliminaryRequests",ReadWriteHelper.readCreatedRequest1(
                        "Preliminaries" ),
                "false","false","false").
                equalsIgnoreCase("ApprovedBySectionManager"));

    }
}
