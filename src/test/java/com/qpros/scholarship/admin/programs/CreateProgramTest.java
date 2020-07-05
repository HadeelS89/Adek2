package com.qpros.scholarship.admin.programs;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.admin.ProgramsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class CreateProgramTest extends Base {

    private LoginPage loginPage;
    private ProgramsPage programsPage;

    @Test(description = "Create new program from admin panel",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createProgram() {
        //Login as Program Manager
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ) );

        //Create new program
        programsPage = new ProgramsPage( driver );
        programsPage.addProgram();
        Assert.assertEquals( ProgramsPage.createdProgram, ProgramsPage.randomName );


    }


    @Test(description = "Set program configurations",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 1)
    public void setConfigurations() {
        //Login as Program Manager
        loginPage = new LoginPage( driver );
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ) );

        //Set program configurations
        programsPage = new ProgramsPage( driver );
        programsPage.getCreatedProgram();
        programsPage.getCreatedProgramName().click();
        programsPage.setProgramConfig();

    }

    @Test(description = "Set Program Team",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class, priority = 2)
    public void setProgramTeam() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee(ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Set program team
        programsPage = new ProgramsPage( driver );
        programsPage.getCreatedProgram();
        programsPage.getCreatedProgramName().click();
        programsPage.setProgramTeam();

    }

}
