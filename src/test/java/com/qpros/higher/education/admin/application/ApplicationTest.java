package com.qpros.higher.education.admin.application;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.higher.education.admin.Applications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class ApplicationTest extends Base {
    LoginPage loginPage;
    Applications applications;

    @Test(description = "Process Application By Name",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void StartApplicationProcess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("DivisionManager1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionManager1", "password"),
                "HigherAdminURL");
        applications= new Applications(driver);
        applications.ApplicationProcessStatusNew();
    }
    @Test(description = "Process Application By Name by Process Coordinator",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void StartApplicationProcessProcess() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("ProcessCoordinator1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("ProcessCoordinator1", "password"),
                "HigherAdminURL");
        applications= new Applications(driver);
        applications.ApplicationProcessStatusNewProcess();
    }

    @Test(description = "Start Review Application By Name by Process Coordinator",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void StartApplicationStartReview() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("ProcessCoordinator1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("ProcessCoordinator1", "password"),
                "HigherAdminURL");
        applications= new Applications(driver);
        applications.ApplicationProcessStatusStartReview();
    }

    @Test(description = "Start Review Application By Name by Process Coordinator",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void StartApplicationTechReview() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("DivisionManager1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("DivisionManager1", "password"),
                "HigherAdminURL");
        applications= new Applications(driver);
        applications.ApplicationProcessStatusTechReviewAccept();
    }
}



