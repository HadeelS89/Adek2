package com.qpros.scholarship.admin.programs;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship_admin_pages.ProgramsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qpros.reporting.Listeners.class)
public class ProgramsTest extends Base {
    private LoginPage loginPage;
    private ProgramsPage programsPage;

    @Test(description = "Create new Program",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createProgram() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "advisor",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "advisor", "password" ));

        //Create program and set configurations and team
        programsPage = new ProgramsPage( driver );
        programsPage.createFullProgram();

    }

    @Test(description = "Create new Program",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void createProgram2() throws Exception {
        //Login as Program Manager
        loginPage = new LoginPage(driver);
        loginPage.signInAsADEKEmployee( ReadWriteHelper.readCredentialsXMLFile( "programManager1",
                "username" ),
                ReadWriteHelper.readCredentialsXMLFile( "programManager1", "password" ));

        //Create program and set configurations and team
        programsPage = new ProgramsPage( driver );
        programsPage.getCreatedProgram1("AUTOMATION TEST 47516");
        programsPage.setProgramTeam();

    }
}
