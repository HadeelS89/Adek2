package com.qpros.scholarship_applicant;


import com.qpros.authorization.LoginTest;
import com.qpros.common.Base;
//import com.qpros.pages.ApplicantLoginPage;
import com.qpros.helpers.ActionsHelper;
import com.qpros.pages.sholarship_applicant_pages.ApplyForProgremPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectProgrmeTest extends Base {
    ApplyForProgremPage applyForProgremPage;


    @Test (description = "Save one program as draft ")// one programe
    public void saveToDraft() throws Exception {
        String programTitle = "New Scholarships for Distinguished Students SDS";
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.saveAsDrat(programTitle);
        Assert.assertTrue(ApplyForProgremPage.programTilteLabel.equalsIgnoreCase(programTitle));

    }

    @Test (description = "Apply for one program")// one programe
    public void applyForOne() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.applyForProgram("Scholarships for Distinguished Students");
        Assert.assertEquals(applyForProgremPage.getStep1().getText(),
                "Step 1");
    }

    @Test (description = "Submit Application" )// one programe
    public void submitProgram() throws Exception {
        LoginTest applicantLoginTest;
        applicantLoginTest = new LoginTest();
        applicantLoginTest.loginAsApplicant();
        applyForProgremPage = new ApplyForProgremPage(driver);
        applyForProgremPage.submitProgram("Scholarships for Distinguished Students");
        Thread.sleep(5000);
        //verify the final results ; submit button is not displayed
        WebElement submitButton = null;
        try{
             submitButton = ActionsHelper.getElement(driver, "xpath",
                    "//button[contains(.,'Submit Application')]");
        }catch(Exception e){
            Assert.assertTrue(!submitButton.isDisplayed());
        }

    }
}
