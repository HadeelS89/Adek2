package com.qpros.authorization;


import com.qpros.common.Base;
import com.qpros.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    LoginPage loginPage;

    @Test (description = "System should display alert message for invalid credentials" )
    public void login(){

        loginPage = new LoginPage(driver);
        loginPage.signIn( "test@test.com", "1234" );
        Assert.assertEquals(loginPage.getAlertMessage().getText(),
                "The email you’ve entered doesn’t match any account. Sign up for an account.");
    }

    @Test (description = "Sample test case for reporting purposes", priority = 1)
    public void login2(){

        loginPage = new LoginPage(driver);
        loginPage.signIn( "test@test.com", "1234" );
        Assert.assertEquals(loginPage.getAlertMessage().getText(),
                "The email you’ve entered doesn’t match any account.");
    }


}
