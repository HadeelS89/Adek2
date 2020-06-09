package com.qpros.scholarship_admin;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class ProgramsTest extends Base {
    LoginPage loginPage;
    ProgramsPage programsPage;

    @Test(description = "Create new program from admin panel",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createProgram() throws Exception {

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Create new program
        programsPage = new ProgramsPage( driver );
        programsPage.addProgram();
        Assert.assertEquals( ProgramsPage.createdProgram, ProgramsPage.randomName );

    }

    @Test(description = "Set program configurations",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void setConfigurations() throws Exception {

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Set program configurations
        programsPage = new ProgramsPage( driver );
        programsPage.setProgramConfig();

    }

    @Test(description = "Set Program Team",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void setProgramTeam() throws Exception {

        //Navigate to Admin panel
        driver.navigate().to( ReadWriteHelper.ReadData("AdminURL"));

        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Set program configurations
        programsPage = new ProgramsPage( driver );
        programsPage.setProgramTeam();

    }


}
