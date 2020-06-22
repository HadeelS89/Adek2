package com.qpros.authorization;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
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

        loginPage = new LoginPage(driver);
        loginPage.signIn( ReadWriteHelper.readCredentialsXMLFile( "applicantCredentials1"
                , "username" ),
                ReadWriteHelper.readCredentialsXMLFile(
                        "applicantCredentials1", "password" ) );
        WebElement applicantLeftMenu = ActionsHelper.getElement( driver, "id", "Biographical" );
        Assert.assertTrue( ActionsHelper.waitVisibility( applicantLeftMenu, 20 ) );
    }


    @Test(description = "Login as ADEK employee successfully",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void loginAsADEKEmployee(){

        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "adminCredentials1", "password" ) );
        WebElement adminLeftMenu = ActionsHelper.getElement( driver, "id", "div_air__menuLeft__list" );
        Assert.assertTrue( ActionsHelper.waitVisibility( adminLeftMenu, 20 ) );
    }

    @Test(description = "Login as ADEK employee successfully",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void Looog(){
        System.out.println("Login 1");
    }




}
