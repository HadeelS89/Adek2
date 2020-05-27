package com.qpros.authorization;

import com.qpros.common.Base;
import com.qpros.pages.AdminExternalLogin;
import org.testng.annotations.Test;


public class ExternalLogin extends Base {

    AdminExternalLogin adminExternalLogin;

    @Test(description = "Try login using external recruiter", priority = 1,
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void externalAdminLogin(){

        adminExternalLogin = new AdminExternalLogin(driver);
        adminExternalLogin.signInAsExternalUser( "leone.bulmaro@andyes.net", "Adek@123" );
        //Assert.assertEquals(loginPage.getAlertMessage().getText(),
        //      "The email you’ve entered doesn’t match any account.");
    }
}
