package com.qpros.pages.scholarship.applicant;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.model.enums.RequestType;
import com.qpros.pages.scholarship_admin_pages.AdminApplicationsListPage;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;


@Getter
public class RequestPage extends Base {

    public static String programTilteLabel = "";
    int waitTime = 60;

    public RequestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='menu-title']")
    private List<WebElement> clientTabs;
    @FindBy(css = "li[class='list-group-item ng-star-inserted'")
    private List<WebElement> requests;
    @FindBy(xpath = "//button[starts-with(@class,'btn btn-primary ml-1 mb-3')]")
    private List<WebElement> addNewRequestBtn;
    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> reimbursementType;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement amountField;
    @FindBy(css = ".adek-upload-div")
    private List<WebElement> uploadField;
    @FindBy(css = "input[type='file']")
    private List<WebElement> uploadInput;
    @FindBy(css = ".adek-upload-popup-btn")
    private WebElement uploadBtn;
    @FindBy(css = ".adek-upload-div")
    private WebElement uploadDiv; //Test123
    @FindBy(css = "button[class='btn btn-raised btn-primary']")
    private List<WebElement> saveBtn;
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")
    private WebElement confirmBtn;
    @FindBy(css = "h5[class='h5 my-2 font-weight-bold text-center']")
    private WebElement passedAssert;
    @FindBy(css = "button[class='btn btn-raised mr-1 btn-primary']")
    private List<WebElement> submitCommentBtn;
    @FindBy(id = "emoji")
    private List<WebElement> feedBackBtn;
    @FindBy(xpath = "//td")
    private List<WebElement> requestId;
    @FindBy(xpath = "//textarea[starts-with(@class,'form-control')]")
    private List<WebElement> textFields;
    @FindBy(css = "button[class='btn btn-primary ml-auto mb-0']")
    private WebElement sendFeedBackBtn;
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")
    private WebElement okButton;
    @FindBy(xpath = "//input[starts-with(@class,'form-control')]")
    private List<WebElement> dateFields;
    @FindBy(css = "label[class='custom-control-label']")
    private List<WebElement> countryCheckBox;
    @FindBy(id = "major")
    private WebElement majorCheckBox;

    public enum RequestList {
        ReimbursementRequest, NationalService, ToWhomItMayConcern, DropAClass,
        ChangeBankDetails, Maternity, Chaperone, SuspendStudies, RegisterInternshipProgram,
        InternshipChange, MedicalClaimRequest, StudyACourse, CancelDiscontinueScholarship,
        ExtendPeriodOfStudy, ExtendEmployeeStudyLeave, Preliminaries
    }

    EnumMap<RequestList, Integer> requestTarget =
            new EnumMap<RequestList, Integer>(RequestList.class);

    public void sharedSteps() throws Exception {


        ActionsHelper.waitForListExistance(getClientTabs(), 60);
        ActionsHelper.selectElementFromList(getClientTabs(), "Active Scholarships");
        Thread.sleep(2000);
        ActionsHelper.scrollTo(getClientTabs().get(8));
        ActionsHelper.waitForListExistance(getClientTabs(), 60);
        ActionsHelper.selectElementFromList(getClientTabs(), "Scholar Requests");
        Thread.sleep(6000);
        ActionsHelper.waitForListExistance(getClientTabs(), waitTime);
        System.out.println("size 1 " + getClientTabs().size());

        ActionsHelper.scrollTo(getRequests().get(0));
        System.out.println("size 1 " + getRequests().size());
    }

    public void nextStep() throws Exception {


        ActionsHelper.waitForListExistance(getClientTabs(), 60);
        ActionsHelper.selectElementFromList(getClientTabs(), "Scholar Requests");
        Thread.sleep(6000);
        ActionsHelper.waitForListExistance(getClientTabs(), waitTime);
        System.out.println("size 1 " + getClientTabs().size());

        ActionsHelper.scrollTo(getRequests().get(0));
        System.out.println("size 1 " + getRequests().size());
    }

    // the original method
    public void selectRequest(RequestList request) throws Exception {

        requestTarget.put(RequestList.ReimbursementRequest, 1);
        requestTarget.put(RequestList.NationalService, 2);
        requestTarget.put(RequestList.ToWhomItMayConcern, 3);
        requestTarget.put(RequestList.DropAClass, 4);
        requestTarget.put(RequestList.ChangeBankDetails, 5);
        requestTarget.put(RequestList.Maternity, 6);
        requestTarget.put(RequestList.Chaperone, 7);
        requestTarget.put(RequestList.SuspendStudies, 8);
        requestTarget.put(RequestList.RegisterInternshipProgram, 9);
        requestTarget.put(RequestList.InternshipChange, 10);
        requestTarget.put(RequestList.MedicalClaimRequest, 11);
        requestTarget.put(RequestList.StudyACourse, 12);
        requestTarget.put(RequestList.CancelDiscontinueScholarship, 13);
        requestTarget.put(RequestList.ExtendPeriodOfStudy, 14);
        requestTarget.put(RequestList.ExtendEmployeeStudyLeave, 15);
        requestTarget.put(RequestList.Preliminaries, 16);


        switch (RequestType.valueOf("Preliminaries")){

            case ReimbursementRequest:
                break;
            case NationalService:
                break;
            case ToWhomItMayConcern:
                break;
            case DropAClass:
                break;
            case ChangeBankDetails:
                break;
            case Maternity:
                break;
            case Chaperone:
                break;
            case SuspendStudies:
                break;
            case RegisterInternshipProgram:
                break;
            case InternshipChange:
                break;
            case MedicalClaimRequest:
                break;
            case StudyACourse:
                break;
            case CancelDiscontinueScholarship:
                break;
            case ExtendPeriodOfStudy:
                break;
            case ExtendEmployeeStudyLeave:
                break;
            case Preliminarie:
                break;
        }
        if (requestTarget.get(request) == 1) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Reimbursement Requests");

            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("Air Ticket" + Keys.ENTER);
            getReimbursementType().get(1).sendKeys("AED" + Keys.ENTER);
            getAmountField().sendKeys("600");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ReimbursementRequest", getRequestId().get(0).getText());
        }


        if (requestTarget.get(request) == 2) {

            ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //text Filed:
            getReimbursementType().get(0).sendKeys("National service letter" + Keys.ENTER);
//submit letter request :
            getSaveBtn().get(0).click();
            getConfirmBtn().click();
            Thread.sleep(3000);

            ActionsHelper.waitForListExistance(getRequestId(), waitTime);
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("NationalService", getRequestId().get(1)
                    .getText());
        }

        if (requestTarget.get(request) == 3) {

            ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //text Filed:
            getReimbursementType().get(0).sendKeys("To whom it may concern letter" + Keys.ENTER);
            //submit letter request :
            getSaveBtn().get(0).click();
            getConfirmBtn().click();
            Thread.sleep(3000);
            // feedBack();
            ActionsHelper.waitForListExistance(getRequestId(), waitTime);
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ToWhomItMayConcern",
                    getRequestId().get(1)
                            .getText());
        }

        if (requestTarget.get(request) == 4) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Drop a Class Request");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);

            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //for drop a class details
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("2020-2021 Winter -Qtr" + Keys.ENTER);
            getTextFields().get(0).sendKeys("Automation Hadeel" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("DropAClass",
                    getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 5) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Change Request Bank Details");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);


            getAddNewRequestBtn().get(0).click();

            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).
                    sendKeys("United Arab Emirates" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(1).sendKeys("Al Halal" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(2).sendKeys("Mall" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(3).sendKeys("0908889");
            getReimbursementType().get(4).sendKeys("12345678908776");
            getReimbursementType().get(5).sendKeys("test");
            getReimbursementType().get(6).sendKeys("test");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            //feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ChangeBankDetails", getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 6) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request For Maternity Leave");
            //Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("1 02 2021");
            getDateFields().get(0).click();
            getDateFields().get(1).sendKeys("31 08 2021");
            getDateFields().get(1).click();
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Maternity", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 7) {


            ActionsHelper.selectElementFromList(getClientTabs(), "Chaperone Request");
             Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("80");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Chaperone", getRequestId().get(0).getText());
        }
//type 2
        if (requestTarget.get(request) == 8) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request to suspend studies");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("1" + Keys.ENTER);
            getReimbursementType().get(1).sendKeys("2020-2021 Fall -Qtr" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Hadeel Automation");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("SuspendStudies", getRequestId().get(0).getText());

        }
        if (requestTarget.get(request) == 9) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Register into an internship program");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("test");
            getDateFields().get(1).sendKeys("2020-2021 Fall -Qtr");


            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(2).sendKeys("Hadeel Automation");


            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(3).sendKeys("1 02 2021");
            getDateFields().get(3).click();
            getDateFields().get(4).sendKeys("31 08 2021");
            getDateFields().get(4).click();
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();

            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("RegisterInternshipProgram", getRequestId().get(0).getText());

        }

        if (requestTarget.get(request) == 10) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request an internship change");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);

            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("test");
            getDateFields().get(1).sendKeys("2020-2021 Fall -Qtr");


            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(2).sendKeys("Hadeel Automation");


            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(3).sendKeys("1 02 2021");
            getDateFields().get(3).click();
            getDateFields().get(4).sendKeys("30 09 2021");
            getDateFields().get(4).click();
            getTextFields().get(0).sendKeys("Automation");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("InternshipChange", getRequestId().get(0).getText());


        }

        if (requestTarget.get(request) == 11) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request a medical claim not covered in insurance");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("2000");
            getReimbursementType().get(0).sendKeys("AED" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("hadeel");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("MedicalClaim", getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 12) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to study a course");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            Thread.sleep(2000);
            getDateFields().get(0).sendKeys("New Course");
            getDateFields().get(1).sendKeys("14");
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(2).sendKeys("HU");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("StudyACourse", getRequestId().get(3).getText());
        }
        //type 3
        if (requestTarget.get(request) == 13) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to cancel or discontinue scholarship");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation Hadeel");

            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("CancelDiscontinueScholarship", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 14) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request for extend period of study");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("1" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation Hadeel");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ExtendPeriodOfStudy", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 15) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to extend employee study leave");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(0).sendKeys("1 02 2021");
            getDateFields().get(0).click();
            getDateFields().get(1).sendKeys("30 09 2021");
            getDateFields().get(1).click();

            getTextFields().get(0).sendKeys("Automation Hadeel");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ExtendEmployeeStudyLeave", getRequestId().get(0).getText());
        }//
        if (requestTarget.get(request) == 16) {
            Thread.sleep(5000);
            ActionsHelper.selectElementFromList
                    (getClientTabs(), "Change Request Preliminaries");
            Thread.sleep(10000);

            //ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
          //  ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();

            Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getCountryCheckBox(), waitTime);
            getCountryCheckBox().get(0).click();
            ActionsHelper.waitForListExistance(getCountryCheckBox(), waitTime);
            getCountryCheckBox().get(2).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("Afghanistan" + Keys.ENTER);//
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(1).sendKeys("City University of Hong Kong" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(3).sendKeys("Artificial Intelligence" + Keys.ENTER);

            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();


            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation hadeel");
            getSubmitCommentBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Preliminaries", getRequestId().get(0).getText());
        }
    }

    // need to be fixed:::
    public void selectRequest(RequestType request) throws Exception {



        switch (RequestType.valueOf(request.name())){

            case ReimbursementRequest:
                ActionsHelper.selectElementFromList(getClientTabs(), "Reimbursement Requests");

                ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
                getAddNewRequestBtn().get(0).click();
                ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
                getReimbursementType().get(0).sendKeys("Air Ticket" + Keys.ENTER);
                getReimbursementType().get(1).sendKeys("AED" + Keys.ENTER);
                getAmountField().sendKeys("600");
                ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
                getUploadDiv().click();
                getUploadInput().get(0).sendKeys(ActionsHelper.
                        getImagePath("Amending.pdf"));
                ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
                getUploadBtn().click();
                ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                getSaveBtn().get(0).click();
                ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
                getConfirmBtn().click();
                ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
                feedBack();
                ReadWriteHelper.writeIntoXMLFileCreatedRequest("ReimbursementRequest", getRequestId().get(0).getText());
                break;
            case NationalService:
                ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
                ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
                getAddNewRequestBtn().get(0).click();
                //text Filed:
                getReimbursementType().get(0).sendKeys("National service letter" + Keys.ENTER);
//submit letter request :
                getSaveBtn().get(0).click();
                getConfirmBtn().click();
                Thread.sleep(3000);

                ActionsHelper.waitForListExistance(getRequestId(), waitTime);
                ReadWriteHelper.writeIntoXMLFileCreatedRequest("NationalService", getRequestId().get(1)
                        .getText());
                break;
            case ToWhomItMayConcern:
                break;
            case DropAClass:
                break;
            case ChangeBankDetails:
                break;
            case Maternity:
                break;
            case Chaperone:
                break;
            case SuspendStudies:
                break;
            case RegisterInternshipProgram:
                break;
            case InternshipChange:
                break;
            case MedicalClaimRequest:
                break;
            case StudyACourse:
                break;
            case CancelDiscontinueScholarship:
                break;
            case ExtendPeriodOfStudy:
                break;
            case ExtendEmployeeStudyLeave:
                break;
            case Preliminarie:
                break;
        }
        if (requestTarget.get(request) == 1) {

        }


        if (requestTarget.get(request) == 2) {


        }

        if (requestTarget.get(request) == 3) {

            ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //text Filed:
            getReimbursementType().get(0).sendKeys("To whom it may concern letter" + Keys.ENTER);
            //submit letter request :
            getSaveBtn().get(0).click();
            getConfirmBtn().click();
            Thread.sleep(3000);
            // feedBack();
            ActionsHelper.waitForListExistance(getRequestId(), waitTime);
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ToWhomItMayConcern",
                    getRequestId().get(1)
                            .getText());
        }

        if (requestTarget.get(request) == 4) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Drop a Class Request");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);

            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //for drop a class details
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("2020-2021 Winter -Qtr" + Keys.ENTER);
            getTextFields().get(0).sendKeys("Automation Hadeel" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("DropAClass",
                    getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 5) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Change Request Bank Details");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);


            getAddNewRequestBtn().get(0).click();

            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).
                    sendKeys("United Arab Emirates" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(1).sendKeys("Al Halal" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(2).sendKeys("Mall" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(3).sendKeys("0908889");
            getReimbursementType().get(4).sendKeys("12345678908776");
            getReimbursementType().get(5).sendKeys("test");
            getReimbursementType().get(6).sendKeys("test");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            //feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ChangeBankDetails", getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 6) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request For Maternity Leave");
            //Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("1 02 2021");
            getDateFields().get(0).click();
            getDateFields().get(1).sendKeys("31 08 2021");
            getDateFields().get(1).click();
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Maternity", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 7) {


            ActionsHelper.selectElementFromList(getClientTabs(), "Chaperone Request");
            Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("80");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Chaperone", getRequestId().get(0).getText());
        }
//type 2
        if (requestTarget.get(request) == 8) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request to suspend studies");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("1" + Keys.ENTER);
            getReimbursementType().get(1).sendKeys("2020-2021 Fall -Qtr" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Hadeel Automation");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("SuspendStudies", getRequestId().get(0).getText());

        }
        if (requestTarget.get(request) == 9) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Register into an internship program");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("test");
            getDateFields().get(1).sendKeys("2020-2021 Fall -Qtr");


            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(2).sendKeys("Hadeel Automation");


            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(3).sendKeys("1 02 2021");
            getDateFields().get(3).click();
            getDateFields().get(4).sendKeys("31 08 2021");
            getDateFields().get(4).click();
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();

            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("RegisterInternshipProgram", getRequestId().get(0).getText());

        }

        if (requestTarget.get(request) == 10) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request an internship change");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);

            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("test");
            getDateFields().get(1).sendKeys("2020-2021 Fall -Qtr");


            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(2).sendKeys("Hadeel Automation");


            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(3).sendKeys("1 02 2021");
            getDateFields().get(3).click();
            getDateFields().get(4).sendKeys("30 09 2021");
            getDateFields().get(4).click();
            getTextFields().get(0).sendKeys("Automation");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("InternshipChange", getRequestId().get(0).getText());


        }

        if (requestTarget.get(request) == 11) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request a medical claim not covered in insurance");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(0).sendKeys("2000");
            getReimbursementType().get(0).sendKeys("AED" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("hadeel");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("MedicalClaim", getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 12) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to study a course");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            Thread.sleep(2000);
            getDateFields().get(0).sendKeys("New Course");
            getDateFields().get(1).sendKeys("14");
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            getDateFields().get(2).sendKeys("HU");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("StudyACourse", getRequestId().get(3).getText());
        }
        //type 3
        if (requestTarget.get(request) == 13) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to cancel or discontinue scholarship");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation Hadeel");

            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("CancelDiscontinueScholarship", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 14) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request for extend period of study");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("1" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation Hadeel");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ExtendPeriodOfStudy", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 15) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Request to extend employee study leave");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            Thread.sleep(2000);
            ActionsHelper.waitForListExistance(getDateFields(), waitTime);
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getDateFields().get(0).sendKeys("1 02 2021");
            getDateFields().get(0).click();
            getDateFields().get(1).sendKeys("30 09 2021");
            getDateFields().get(1).click();

            getTextFields().get(0).sendKeys("Automation Hadeel");
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ExtendEmployeeStudyLeave", getRequestId().get(0).getText());
        }//
        if (requestTarget.get(request) == 16) {
            Thread.sleep(5000);
            ActionsHelper.selectElementFromList
                    (getClientTabs(), "Change Request Preliminaries");
            Thread.sleep(10000);

            //ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            //  ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();

            Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getCountryCheckBox(), waitTime);
            getCountryCheckBox().get(0).click();
            ActionsHelper.waitForListExistance(getCountryCheckBox(), waitTime);
            getCountryCheckBox().get(2).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("Afghanistan" + Keys.ENTER);//
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(1).sendKeys("City University of Hong Kong" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(3).sendKeys("Artificial Intelligence" + Keys.ENTER);

            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();


            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("Automation hadeel");
            getSubmitCommentBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("Preliminaries", getRequestId().get(0).getText());
        }
    }
    public void selectRequest1(RequestList request) throws Exception {

        requestTarget.put(RequestList.ReimbursementRequest, 1);
        requestTarget.put(RequestList.NationalService, 2);
        requestTarget.put(RequestList.ToWhomItMayConcern, 3);
        requestTarget.put(RequestList.DropAClass, 4);
        requestTarget.put(RequestList.ChangeBankDetails, 5);
        requestTarget.put(RequestList.Maternity, 6);
        requestTarget.put(RequestList.Chaperone, 7);

        if (requestTarget.get(request) == 1) {
            ActionsHelper.selectElementFromList(getClientTabs(), "Reimbursement Requests");

            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("Air Ticket" + Keys.ENTER);
            getReimbursementType().get(1).sendKeys("AED" + Keys.ENTER);
            getAmountField().sendKeys("600");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ReimbursementRequest", getRequestId().get(0).getText());
        }


        if (requestTarget.get(request) == 2) {

            ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //text Filed:
            getReimbursementType().get(0).sendKeys("National service letter" + Keys.ENTER);
//submit letter request :
            getSaveBtn().get(0).click();
            getConfirmBtn().click();
            Thread.sleep(3000);

            ActionsHelper.waitForListExistance(getRequestId(), waitTime);
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("NationalService", getRequestId().get(1)
                    .getText());
        }

        if (requestTarget.get(request) == 3) {

            ActionsHelper.selectElementFromList(getClientTabs(), "National service letter");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //text Filed:
            getReimbursementType().get(0).sendKeys("To whom it may concern letter" + Keys.ENTER);
            //submit letter request :
            getSaveBtn().get(0).click();
            getConfirmBtn().click();
            Thread.sleep(3000);
            // feedBack();
            ActionsHelper.waitForListExistance(getRequestId(), waitTime);
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ToWhomItMayConcern",
                    getRequestId().get(1)
                            .getText());
        }

        if (requestTarget.get(request) == 4) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Drop a Class Request");
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);

            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            //for drop a class details
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).sendKeys("2020-2021 Winter -Qtr" + Keys.ENTER);
            getTextFields().get(0).sendKeys("Automation Hadeel" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            ActionsHelper.waitForExistance(getPassedAssert(), waitTime);
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("DropAClass",
                    getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 5) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Change Request Bank Details");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);


            getAddNewRequestBtn().get(0).click();

            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(0).
                    sendKeys("United Arab Emirates" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(1).sendKeys("Al Halal" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(2).sendKeys("Mall" + Keys.ENTER);
            ActionsHelper.waitForListExistance(getReimbursementType(), waitTime);
            getReimbursementType().get(3).sendKeys("0908889");
            getReimbursementType().get(4).sendKeys("12345678908776");
            getReimbursementType().get(5).sendKeys("test");
            getReimbursementType().get(6).sendKeys("test");
            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();
            ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
            getSaveBtn().get(0).click();
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            //feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest("ChangeBankDetails", getRequestId().get(0).getText());
        }
        if (requestTarget.get(request) == 6) {

            ActionsHelper.selectElementFromList(getClientTabs(), "Request For Maternity Leave");
            Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("1 FEB 2021");
            getTextFields().get(1).sendKeys("31 AUG 2021");

            ActionsHelper.waitForExistance(getUploadDiv(), waitTime);
            getUploadDiv().click();
            getUploadInput().get(0).sendKeys(ActionsHelper.
                    getImagePath("Amending.pdf"));
            ActionsHelper.waitForExistance(getUploadBtn(), waitTime);
            getUploadBtn().click();

            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ChangeBankDetails", getRequestId().get(0).getText());
        }

        if (requestTarget.get(request) == 7) {


            ActionsHelper.selectElementFromList(getClientTabs(), "Chaperone Request");
            //  Thread.sleep(3000);
            ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
            getAddNewRequestBtn().get(0).click();
            ActionsHelper.waitForListExistance(getTextFields(), waitTime);
            getTextFields().get(0).sendKeys("80");
            ActionsHelper.waitForExistance(getConfirmBtn(), waitTime);
            getConfirmBtn().click();
            feedBack();
            ReadWriteHelper.writeIntoXMLFileCreatedRequest
                    ("ChangeBankDetails", getRequestId().get(0).getText());
        }
    }

    public void feedBack() {

        ActionsHelper.waitForListExistance(getFeedBackBtn(), waitTime);
        getFeedBackBtn().get(0).click();
        ActionsHelper.waitForExistance(getSendFeedBackBtn(), waitTime);
        getSendFeedBackBtn().click();
        ActionsHelper.waitForExistance(getOkButton(), waitTime);
        getOkButton().click();
//    if (getFeedBackBtn().get(0).isDisplayed()) {
//        ActionsHelper.waitForExistance(getAddNewRequestBtn(), waitTime);
//        ActionsHelper.waitForListExistance(getFeedBackBtn(), waitTime);
//        getFeedBackBtn().get(0).click();
//    }

//request 1
//        try {
//            if (getFeedBackBtn().get(0).isDisplayed()) {
//                ActionsHelper.waitForListExistance(getFeedBackBtn(), waitTime);
//                getFeedBackBtn().get(0).click();
//            }
//        } catch (Exception e) {
//
//        }
    }

    public void saveRequestID() throws Exception {
        ActionsHelper.scrollTo(getRequests().get(0));
        System.out.println("size 1 " + getRequests().size());
        //ActionsHelper.selectElementFromList(getClientTabs(), "Reimbursement Requests");
        ActionsHelper.selectElementFromList(getClientTabs(), "Drop a Class Requests");
        ActionsHelper.waitForListExistance(getAddNewRequestBtn(), waitTime);
        ActionsHelper.waitForListExistance(getFeedBackBtn(), waitTime);
        getFeedBackBtn().get(0).click();
        ReadWriteHelper.writeIntoXMLFileCreatedRequest(getRequestId().
                get(0).getText(), "DropClass");
//-------------------------
        boolean isExist = false;

        try {

            if (getFeedBackBtn().get(0).isDisplayed()) {
                ActionsHelper.waitForListExistance(getFeedBackBtn(), waitTime);
                getFeedBackBtn().get(0).click();
            }

        } catch (Exception e) {
            System.out.println("Error occurred locating feedback ");

        }
    }

    public void requestToWithDrawFromSemester() throws Exception {


        ActionsHelper.waitForListExistance(getClientTabs(), 60);
        System.out.println("size 1 " + getClientTabs().size());

        ActionsHelper.scrollTo(getRequests().get(0));
        System.out.println("size 1 " + getRequests().size());
        ActionsHelper.selectElementFromList(getClientTabs(), "Reimbursement Requests");
    }


}