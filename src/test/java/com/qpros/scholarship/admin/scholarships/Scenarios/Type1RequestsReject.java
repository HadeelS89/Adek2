package com.qpros.scholarship.admin.scholarships.Scenarios;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.applicant.RequestPage;
import com.qpros.pages.scholarship_admin_pages.AdminRequestsPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class Type1RequestsReject extends Base {
    private RequestPage requestPage;

    private LoginPage loginPage;

    private ProgramsPage programsPage;
    private AdminRequestsPage adminRequestsPage;

    @Test(description = "create request Request to Reimbursement ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 0)// one programe
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


    @Test(description = "reject Reimbursement Request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class,priority = 1)
    public void rejectReimbursementRequest() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("advisor",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("advisor", "password"));
        adminRequestsPage = new AdminRequestsPage(driver);
        adminRequestsPage.sharedSteps("ps20302");
       // adminRequestsPage.rejectReimbursementRequests();
        //requestPage.approveRequestToCancelOrDiscontinueScholarship();

    }
}
