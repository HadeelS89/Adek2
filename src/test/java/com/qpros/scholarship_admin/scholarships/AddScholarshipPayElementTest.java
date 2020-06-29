package com.qpros.scholarship_admin.scholarships;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ScholarshipsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class AddScholarshipPayElementTest extends Base {
    LoginPage loginPage;
    ScholarshipsPage scholarshipsPage;


    @Test(description = "add new pay element test cas id 2815",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void addScholarshipPayElement() throws Exception {


        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile("interviewer1",
                "username"),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "password"));
        scholarshipsPage = new ScholarshipsPage(driver);
        scholarshipsPage.findProgram(ReadWriteHelper.getScholarshipProgram());
        scholarshipsPage.addPayElement();
        Assert.assertTrue(scholarshipsPage.getSucessLabel().get(0).isDisplayed());
        scholarshipsPage.getBtnOK().click();
    }


}
