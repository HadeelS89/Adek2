package com.qpros.scholarship.applicant.activeScholarships;


import com.qpros.common.Base;

import com.qpros.helpers.ReadWriteHelper;
import com.qpros.model.enums.RequestType;
import com.qpros.pages.authorization_pages.LoginPage;
import com.qpros.pages.scholarship.applicant.RequestPage;

import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;



public class RequestTest extends Base {
    private RequestPage requestPage;

    private LoginPage loginPage;


    @Test(description = "create request Request to Reimbursement ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void createReimbursementRequest() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        //requestPage.selectRequest(RequestPage.RequestList.ReimbursementRequest);
        requestPage.selectRequest(RequestType.ReimbursementRequest);

        //Assert.assertTrue(requestPage.getPassedAssert().isDisplayed());
       // requestPage.saveRequestID();
    }

    @Test(description = " request a National service letter ",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestForNationalServiceLetter() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.NationalService);

        //Assert.assertTrue(requestPage.getPassedAssert().isDisplayed());
        // requestPage.saveRequestID();
    }
    @Test(description = " Request National service letter",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToWhomItMayConcern() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.ToWhomItMayConcern);

        //Assert.assertTrue(requestPage.getPassedAssert().isDisplayed());
        // requestPage.saveRequestID();
    }

    @Test(description = " Request Drop a Class",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToDropAClass() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.DropAClass);

    }

    @Test(description = " Change bank details request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToChangeBank() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.ChangeBankDetails);

    }
    @Test(description = " Suspend Study request",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToSuspendStudy() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.SuspendStudies);

    }

    @Test(description = "Register into an internship program",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToRegisterInternshipProgram() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.RegisterInternshipProgram);

    }
    @Test(description = "Request an internship change",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestToInternshipChange() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.InternshipChange);

    }

    @Test(description = "Request a medical claim not covered in insurance",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void MedicalClaim() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.MedicalClaimRequest);

    }

    @Test(description = "Request to study a course",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestStudyACourse() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

        requestPage.selectRequest(RequestPage.RequestList.StudyACourse);


    }


    @Test(description = "Request to study a course",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void type3() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();

//        requestPage.selectRequest(RequestPage.RequestList.CancelDiscontinueScholarship);
//        requestPage.nextStep();
//        requestPage.selectRequest(RequestPage.RequestList.ExtendPeriodOfStudy);
//        requestPage.nextStep();
//        requestPage.selectRequest(RequestPage.RequestList.ExtendEmployeeStudyLeave);
//        requestPage.nextStep();
Thread.sleep(9000);
        requestPage.selectRequest(RequestPage.RequestList.Preliminaries);



    }

    @Test(description = " Female  requests",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)// one programe
    public void requestFemaleRequests() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("ScholarFemale"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "ScholarFemale", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();
try{
        requestPage.selectRequest(RequestPage.RequestList.Maternity);
}catch (ParserConfigurationException pce) {
    pce.printStackTrace();
}
        requestPage.nextStep();

        try{
            requestPage.selectRequest(RequestPage.RequestList.Chaperone);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

    }

    @Test(description = " All requests from scholar side",
            retryAnalyzer = com.qpros.helpers.RetryAnalyzer.class)
    public void allScholarRequest() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.signIn(ReadWriteHelper.readCredentialsXMLFile("Scholar1"
                , "username"),
                ReadWriteHelper.readCredentialsXMLFile(
                        "Scholar1", "password"));
        requestPage =new RequestPage(driver);
        requestPage.sharedSteps();
try {
    requestPage.selectRequest(RequestPage.RequestList.DropAClass);
}catch (ParserConfigurationException pce) {
    pce.printStackTrace();
}


        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.ReimbursementRequest);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.ChangeBankDetails);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.SuspendStudies);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.RegisterInternshipProgram);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.InternshipChange);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.MedicalClaimRequest);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.StudyACourse);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.CancelDiscontinueScholarship);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }


        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.ExtendPeriodOfStudy);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }


        requestPage.nextStep();
        try {

            requestPage.selectRequest(RequestPage.RequestList.ExtendEmployeeStudyLeave);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

       //





        requestPage.nextStep();
try {
    requestPage.selectRequest(RequestPage.RequestList.ToWhomItMayConcern);
}catch (ParserConfigurationException pce) {
    pce.printStackTrace();
}

        requestPage.nextStep();
try {
    requestPage.selectRequest(RequestPage.RequestList.NationalService);
}catch (ParserConfigurationException pce) {
    pce.printStackTrace();
}
        requestPage.nextStep();

        Thread.sleep(9000);
        try {

            requestPage.selectRequest(RequestPage.RequestList.Preliminaries);
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }




    }



    @Test
    public static void main() {
        System.out.println(ReadWriteHelper.readCreatedRequest1("ReimbursementRequest"));

    }





}


