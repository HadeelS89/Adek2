package com.qpros.scholarship_admin.scholarships;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ScholarshipsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AddScholarshipBankDetailsTest extends Base {
    LoginPage loginPage;
    ScholarshipsPage scholarshipsPage;


    @Test(description = "add bank details for scholarship test cas id 2770",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addBankDetails() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.findProgram(ReadWriteHelper.getScholarshipProgram());
        scholarshipsPage.addBankDetails();
        Assert.assertTrue(scholarshipsPage.getSuccess().isDisplayed());
        scholarshipsPage.getBtnOK().click();
    }


}
