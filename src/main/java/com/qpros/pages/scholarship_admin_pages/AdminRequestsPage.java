package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadFromExcel1;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

@Getter
public class AdminRequestsPage extends Base {
    int waitTime = 60;


    public AdminRequestsPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);

    }


    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> scholarshipsTab;
    @FindBy(id = "btnApply")
    private WebElement btnApply;
    @FindBy(xpath = "//label[@class='filter-container-label' and contains(text(), 'Programs')]")
    private WebElement programsLabel;
    @FindBy(xpath = "//span[starts-with(@class,'select2-selection')]")
    private List<WebElement> programsList1;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement programNameInput;
    @FindBy(css = ".font-weight-bold > .col-md-auto:nth-child(1)")
    private WebElement lblFirstResultCode;
    @FindBy(id = "timeline")
    private WebElement timeLine;
    @FindBy(id = "home-tab")
    private List<WebElement> applicationTabs;
    @FindBy(id = "searchbox")
    private WebElement applicantIDSearchBox;
    @FindBy(xpath = "//a[starts-with(@class, 'nav-link')]")
    private List<WebElement> scholarSubTab;
    @FindBy(id = "btnView")
    private List<WebElement> viewRequestBtn;
    @FindBy(css = "div[class='col-md-auto']")
    private List<WebElement> firstRecord;
    @FindBy(css = "a[class='nav-link borderleft']")
    private List<WebElement> requestDetails;
    @FindBy(css = "i[class='fa fa-edit fontSize21Css']")
    private List<WebElement> editRequestBtn;
    @FindBy(xpath = "//tr[@class='odd']")
    private List<WebElement> firstRow;
    @FindBy(xpath = "//button[@name='button']")
    private List<WebElement> saveBtn;
    @FindBy(css = "button[@value='Approve']")
    private List<WebElement> approveBtn;
    @FindBy(css = "button[class='confirm btn btn-lg btn-primary']")
    private List<WebElement> submitBtn;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement okBtn;
    @FindBy(css = "input[class='form-control']")
    private WebElement rejectReasonText;
    @FindBy(css = "i[class='fa fa-check-circle-o fontSize21Css greenColorCss']")
    private List<WebElement> approveLetterBtn;
    @FindBy(id = "btnAcceptLetter")
    private WebElement sendLetterBtn;
    @FindBy(css = "i[class='fa fa-times-circle fontSize21Css redColorCss']")
    private List<WebElement> rejectLettersBtn;
    @FindBy(id = "CommitteeDecisionStatusId")
    private WebElement committeMedicalField;
    @FindBy(id = "ScholarshipBankRequest_EffectiveDate")
    private WebElement backActiveDate;
    @FindBy(id = "toggle-filter")
    private WebElement filterSelection;
    @FindBy(css = "label[class='custom-control-label']")
    private WebElement allStudentFlag;
    @FindBy(id = "btnApply")
    private WebElement applyBtn;
    @FindBy(id = "inputConsellorComments")
    private WebElement commentArea;
    @FindBy(css = "button[class='custom-control-label']")
    private List<WebElement> closeBtn;
    @FindBy(css = "div[class='modal-footer']")
    private WebElement footer;

    public boolean isSkipped =false;


    public void sharedSteps(String scholarId) throws Exception {
        ActionsHelper.waitForListExistance(getScholarshipsTab(), waitTime);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");
        ActionsHelper.waitForExistance(getApplicantIDSearchBox(), waitTime);
        getApplicantIDSearchBox().sendKeys(scholarId + Keys.ENTER);

        ActionsHelper.waitForListExistance(getFirstRecord(), waitTime);
        getFirstRecord().get(0).click();
        ActionsHelper.waitForListExistance(getApplicationTabs(), waitTime);
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Requests");
        Thread.sleep(1000);
    }

    public void sharedStepsAndFilter(String scholarId) throws Exception {
        ActionsHelper.waitForListExistance(getScholarshipsTab(), waitTime);
        ActionsHelper.waitForExistance(getApplicantIDSearchBox(), waitTime);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");

        ActionsHelper.waitForExistance(getFilterSelection(), waitTime);
        getFilterSelection().click();
        Thread.sleep(1000);
        ActionsHelper.waitForExistance(getAllStudentFlag(), waitTime);
        getAllStudentFlag().click();
        getApplyBtn().click();
        Thread.sleep(1000);
        ActionsHelper.waitForExistance(getApplicantIDSearchBox(), waitTime);
        getApplicantIDSearchBox().sendKeys(scholarId + Keys.ENTER);

        ActionsHelper.waitForListExistance(getFirstRecord(), waitTime);
        getFirstRecord().get(0).click();
        ActionsHelper.waitForListExistance(getApplicationTabs(), waitTime);
        Thread.sleep(3000);
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Requests");

        Thread.sleep(3000);
    }


    public String approveRequestAdvisor(String requestType, String tableID, String requestID,
                                        String committeDecision, String isBank, String changeLocator) throws Exception {
        String systemRequest = "";
        String status = "";
        ActionsHelper.waitForListExistance(getRequestDetails(), waitTime);
        ActionsHelper.selectElementFromList(getRequestDetails(), requestType);
        Thread.sleep(2000);

        System.out.println("request file " + requestID);
        Thread.sleep(2000);
        HashMap table = ActionsHelper.getWebColumnIndex(tableID, 0,
                0);

        int size = table.size();
        ActionsHelper.scrollTo(getFirstRow().get(0));
        System.out.println("request system1  " + table.get(0));
        System.out.println("request system2  " + table.get(1));
        System.out.println("size = " + size);
        for (int i = 1; i <= table.size(); i++) {

            systemRequest = (String) table.get(i);
            System.out.println("request system " + systemRequest);

            if (requestID.equalsIgnoreCase(systemRequest)) {
                System.out.println(" i = " + i);
                System.out.println("inside if " + requestID + systemRequest);
                ActionsHelper.waitForExistance(getEditRequestBtn().get(i - 1));
                ActionsHelper.scrollTo(getEditRequestBtn().get(i - 1));
                getEditRequestBtn().get(i - 1).click();
                if (committeDecision.equalsIgnoreCase("true")) {
                    ActionsHelper.waitForExistance(getCommitteMedicalField(), waitTime);
                    getCommitteMedicalField().sendKeys("Committee Approved" + Keys.ENTER);

                }
                if (isBank.equalsIgnoreCase("true")) {
                    ActionsHelper.waitForExistance(getBackActiveDate(), waitTime);
                    getBackActiveDate().sendKeys("02/01/2020");

                }
                Thread.sleep(5000);
                if (driver.findElements(By.className("modal-footer")).
                        get(1).findElements(By.className("btn-light")).size()==1
                ) {
                    WebElement element = driver.findElements(By.className("modal-footer")).get(1).
                            findElement(By.className("btn-light"));
                   ActionsHelper.retryClick(element,waitTime);
                   isSkipped= true;

                }else {
                    if (changeLocator.equalsIgnoreCase("true")) {
                        ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                        getSaveBtn().get(1).click();//approve or reject buttons
                    } else {
                        ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                        getSaveBtn().get(0).click();//approve or reject buttons
                    }
                }
                if(!isSkipped) {
                    ActionsHelper.waitForListExistance(getSubmitBtn(), waitTime);
                    getSubmitBtn().get(0).click();//confirm btn
                    ActionsHelper.waitForExistance(getOkBtn(), waitTime);
                    getOkBtn().click();
                    Thread.sleep(2000);
                    ActionsHelper.waitForExistance(getEditRequestBtn().get(i - 1), waitTime);

                    System.out.println(" i new = " + i);
                    HashMap table2 = ActionsHelper.getWebColumnIndex(tableID, 3);
                    ActionsHelper.scrollTo(getEditRequestBtn().get(i - 1));
                    status = (String) table2.get(i + 1);

                    System.out.println("status =" + status);
                }
                break;
            }


        }
        return status;
    }

    public void rejectReimbursementRequests(String requestID) throws Exception {
        String systemRequest = "";
        ActionsHelper.waitForListExistance(getRequestDetails(), waitTime);
        ActionsHelper.selectElementFromList(getRequestDetails(), "Financial Requests");
        requestID = ReadWriteHelper.readCreatedRequest();
        System.out.println("request file " + requestID);

        HashMap table = ActionsHelper.getWebColumnIndex(
                "dtFinancialList", 0, 0);
        int size = table.size();
        ActionsHelper.scrollTo(getFirstRow().get(0));
        System.out.println("request system1  " + table.get(0));
        System.out.println("request system2  " + table.get(1));
        System.out.println("size = " + size);
        for (int i = 1; i <= table.size(); i++) {

            systemRequest = (String) table.get(i);
            System.out.println("request system " + systemRequest);

            if (requestID.equalsIgnoreCase(systemRequest)) {
                System.out.println(" i = " + i);
                System.out.println("inside if " + requestID + systemRequest);
                getEditRequestBtn().get(i - 1).click();
                Thread.sleep(5000);
                ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                getSaveBtn().get(1).click();
                ActionsHelper.waitForListExistance(getSubmitBtn(), waitTime);
                getRejectReasonText().sendKeys("Hadeel Automation");
                getSubmitBtn().get(0).click();
                ActionsHelper.waitForExistance(getOkBtn(), waitTime);
                getOkBtn().click();
                break;
            }


        }
    }

    public String approveRequestSectionManager(String requestType, String tableID, String requestID) throws Exception {
        String systemRequest = "";
        String status = "";
        ActionsHelper.waitForListExistance(getRequestDetails(), waitTime);
        ActionsHelper.selectElementFromList(getRequestDetails(), requestType);

        System.out.println("request file " + requestID);

        HashMap table = ActionsHelper.getWebColumnIndex(tableID, 0,
                0);

        int size = table.size();
        ActionsHelper.scrollTo(getFirstRow().get(0));
        System.out.println("request system1  " + table.get(0));
        System.out.println("request system2  " + table.get(1));
        System.out.println("size = " + size);
        for (int i = 1; i <= table.size(); i++) {

            systemRequest = (String) table.get(i);
            System.out.println("request system " + systemRequest);

            if (requestID.equalsIgnoreCase(systemRequest)) {
                System.out.println(" i = " + i);
                System.out.println("inside if " + requestID + systemRequest);
                ActionsHelper.waitForExistance(getEditRequestBtn().get(i - 1));
                ActionsHelper.scrollTo(getEditRequestBtn().get(i - 1));
                getEditRequestBtn().get(i - 1).click();

                Thread.sleep(5000);
                ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                getApproveBtn().get(0).click();//approve or reject buttons
                ActionsHelper.waitForListExistance(getSubmitBtn(), waitTime);
                getSubmitBtn().get(0).click();//confirm btn
                ActionsHelper.waitForExistance(getOkBtn(), waitTime);
                getOkBtn().click();
                Thread.sleep(2000);
                ActionsHelper.waitForExistance(getEditRequestBtn().get(i - 1), waitTime);

                System.out.println(" i new = " + i);
                HashMap table2 = ActionsHelper.getWebColumnIndex(tableID, 3);
                ActionsHelper.scrollTo(getEditRequestBtn().get(i - 1));
                status = (String) table2.get(i + 1);

                System.out.println("status =" + status);
                break;
            }


        }
        return status;
    }

    public void approveLetters(String requestId) throws Exception {
        String systemRequest = "";
        ActionsHelper.waitForListExistance(getRequestDetails(), waitTime);
        ActionsHelper.selectElementFromList(getRequestDetails(),
                "Request For Letters");
        //requestID = ReadWriteHelper.readCreatedRequest();
        System.out.println("request file " + requestId);

        HashMap table = ActionsHelper.getWebColumnIndex
                ("scholarLetterRequestTable", 0, 0);
        int size = table.size();
        ActionsHelper.scrollTo(getFirstRow().get(0));
        System.out.println("request system1  " + table.get(0));
        System.out.println("request system2  " + table.get(1));
        System.out.println("size = " + size);
        for (int i = 1; i <= table.size(); i++) {

            systemRequest = (String) table.get(i);
            System.out.println("request system " + systemRequest);

            if (requestId.equalsIgnoreCase(systemRequest)) {
                System.out.println(" i = " + i);
                System.out.println("inside if " + requestId + systemRequest);
                getApproveLetterBtn().get(i - 1).click();
                Thread.sleep(2000);
                ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                getRejectReasonText().sendKeys("Hadeel Automation");
                getSendLetterBtn().click();
                ActionsHelper.waitForListExistance(getSubmitBtn(), waitTime);
                getSubmitBtn().get(0).click();
                ActionsHelper.waitForExistance(getOkBtn(), waitTime);
                getOkBtn().click();
                break;
            }


        }
    }

    public void rejectLetters(String requestID) throws Exception {
        String systemRequest = "";
        ActionsHelper.waitForListExistance(getRequestDetails(), waitTime);
        ActionsHelper.selectElementFromList(getRequestDetails(),
                "Request For Letters");
        requestID = ReadWriteHelper.readCreatedRequest();
        System.out.println("request file " + requestID);

        HashMap table = ActionsHelper.getWebColumnIndex
                ("scholarLetterRequestTable", 0, 0);
        int size = table.size();
        ActionsHelper.scrollTo(getFirstRow().get(0));
        System.out.println("request system1  " + table.get(0));
        System.out.println("request system2  " + table.get(1));
        System.out.println("size = " + size);
        for (int i = 1; i <= table.size(); i++) {

            systemRequest = (String) table.get(i);
            System.out.println("request system " + systemRequest);

            if (requestID.equalsIgnoreCase(systemRequest)) {
                System.out.println(" i = " + i);
                System.out.println("inside if " + requestID + systemRequest);
                getRejectLettersBtn().get(i - 1).click();
                Thread.sleep(2000);
                ActionsHelper.waitForListExistance(getSaveBtn(), waitTime);
                getRejectReasonText().sendKeys("Hadeel Automation");

                getSubmitBtn().get(0).click();
                ActionsHelper.waitForExistance(getOkBtn(), waitTime);
                getOkBtn().click();
                break;
            }


        }
    }


}

