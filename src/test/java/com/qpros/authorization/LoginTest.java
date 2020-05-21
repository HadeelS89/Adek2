package com.qpros.authorization;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.qpros.reporting.Listeners.class)
public class LoginTest extends Base {
    LoginPage loginPage;


    @Test(description = "Login as applicant successfully",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, enabled = true)
    public void loginAsApplicant(){

        //Navigate to Application
        driver.navigate().to( ReadWriteHelper.ReadData("ApplicantURL"));

        loginPage = new LoginPage(driver);
        loginPage.signIn( "mohyounis83@gmail.com", "Test@123" );
        WebElement applicantLeftMenu = ActionsHelper.getElement( driver, "id", "Biographical" );
        Assert.assertTrue( ActionsHelper.waitVisibility( applicantLeftMenu, 20 ) );
    }


    @Test(description = "Login as ADEK employee successfully",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void loginAsADEKEmployee(){

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee( "test.user2@adek.gov.ae", "Adek@12345" );
        WebElement adminLeftMenu = ActionsHelper.getElement( driver, "id", "div_air__menuLeft__list" );
        Assert.assertTrue( ActionsHelper.waitVisibility( adminLeftMenu, 10 ) );
    }




}
