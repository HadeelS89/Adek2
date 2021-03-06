package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.EnumMap;
import java.util.List;

@Getter
public class AdminApplicationsListPage extends Base {


    int waitTime = 60;

    public AdminApplicationsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchbox")
    private WebElement searchBox;
    @FindBy(id = "btnGroupAddon2")
    private WebElement btnSearch;
    //    @FindBy(xpath = "//*[@id=\"mainDiv\"]/div[3]/div[1]/div[2]/div[1]/div[1]")
//    private WebElement lblFirstResultCode;
    @FindBy(css = ".list-inline-item:nth-child(1) > b")
    private WebElement lblFirstResultCode;
    //TODO: Locate Status Drop down list
    @FindBy(xpath = "//div[@id='filterContainer']/div/div[3]/select")
    private WebElement statusDDL;
    @FindBy(css = "div[class='col-md-auto']")
    private List<WebElement> resultsCodes;
    @FindBy(id = "btnApply")
    private WebElement btnApply;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement cbAssignedToMe;
    @FindBy(css = "button[value='StartReview']")
    private List<WebElement> btnStartReviews;
    @FindBy(xpath = "(//button[@name='button'])[2]")
    private WebElement btnPresent;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement btnAbsence;
    @FindBy(xpath = "//div[7]/div/button")
    private List<WebElement> btnSubmit;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement btnOk;
    @FindBy(id = "timeline")
    private WebElement workflowArea;
    @FindBy(css = "div[row adek-table-row']")
    private List<WebElement> resultsApplicant;
    @FindBy(css = "ul[starts-with(@class,'select2-selection')]")
    private List<WebElement> programsList;
    @FindBy(css = "li[class='select2-results__option']")
    private List<WebElement> programsIndex;
    @FindBy(css = ".confirm")
    private WebElement nextStepButton;
    @FindBy(css = ".ml-2:nth-child(1)")
    private WebElement confirmButton;
    @FindBy(css = ".list-inline-item:nth-child(1) > b")
    private WebElement firstResult;
    @FindBy(css = ".btn-success:nth-child(2)")
    private WebElement secondThing;
    @FindBy(xpath = "//button[3]")
    private WebElement btnScheduleInterview;
    @FindBy(xpath = "//button[3]")
    private WebElement btnRequestForChange;
    @FindBy(id = "Comment")
    private WebElement requesChangeComment;
    @FindBy(id = "adekFlowCommandParamSubmit")
    private WebElement requesChangeSubmit;
    @FindBy(css = ".ml-2:nth-child(1)")
    private WebElement firstButton;
    @FindBy(css = ".ml-2:nth-child(2)")
    private WebElement secondButton;
    @FindBy(css = ".ml-2:nth-child(3)")
    private WebElement thirdButton;
    @FindBy(id = "Comment")
    private WebElement rejectionComment;
    @FindBy(id = "adekFlowCommandParamSubmit")
    private WebElement rejectionButton;

    @FindBy(id = "btnClear")
    private WebElement clearFiltersButton;
    @FindBy(id = "btnApply")
    private WebElement applyButton;

    @FindBy(xpath = "//label[@class='filter-container-label' and contains(text(), 'Programs')]")
    private WebElement programsLabel;
    @FindBy(xpath = "//span[starts-with(@class,'select2-selection')]")
    private List<WebElement> programsList1;

    //=====================================

    @FindBy(xpath = "//button[starts-with(@class,'btn btn-success')]")
    private List<WebElement> applicationButtons;
    WebElement delegateButton = null;
    WebElement activate = null;
    WebElement startReviewButton = null;
    WebElement appReviewCompletedButton = null;
    WebElement appDocumentsVerifiedButton = null;
    WebElement approveAndProceedToAcknowledgement = null;
    WebElement ApplicantPresent = null;
    WebElement ScheduleInterview = null;
    WebElement RequestForChange = null;
    WebElement ApplicantAbsent = null;
    @FindBy(xpath = "//button[starts-with(@class,'confirm btn')]")
    private List<WebElement> confirmationButtons;
    WebElement submitButton = null;
    WebElement okButton = null;

    @FindBy(xpath = "//h2[contains(text(),'Are you sure?')]")
    private List<WebElement> areYouSureLabel;
    @FindBy(xpath = "//p[starts-with(@class,'lead ')]")
    private List<WebElement> sucessLabel;
    @FindBy(id = "toggle-filter")
    private WebElement filterSelection;

    //TODO: Locators for activation form
    @FindBy(id = "UniversityStartDate")
    private WebElement startDateUnv;
    @FindBy(id = "UniversityId")
    private WebElement university;
    @FindBy(id = "MajorId")
    private WebElement major;
    @FindBy(id = "ExpectedGraduationTermId")
    private WebElement expectedGradTerm;
    @FindBy(id = "ExpectedGraduationDate")
    private WebElement expectedGraduationDate;
    @FindBy(id = "TotalCreditsForGraduation")
    private WebElement totalCreditsGraduation;
    @FindBy(id = "ErppayStartDate")
    private WebElement erpStartDate;
    @FindBy(id = "AcademicProgramId")
    private WebElement AcademicProgramId;
    //    @FindBy(id = "btnSubmit")
//    private WebElement saveActivationForm;
    @FindBy(xpath = "//input[@class='btn btn-success']")
    private List<WebElement> activeButton;

    @FindBy(xpath = "//p[contains(.,'Success')]")
    private WebElement success;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement btnOK;
    @FindBy(id = "searchbox")
    private WebElement programNameInput;
    @FindBy(css = ".row:nth-child(1) > .col-md-8 > .row:nth-child(4) > .col-md-auto:nth-child(2)")
    private WebElement emailField;
    @FindBy(xpath = "//li[contains(.,'Active Scholarships')]")
    private WebElement activateScholarshipLabel;
    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> scholarshipsTab;
    @FindBy(css = "span[class='select2-selection__rendered']")
    private WebElement applicantIDSearchBox;
    @FindBy(css = "input[class='select2-search__field']")
    private WebElement programIdSearch;
    @FindBy(css = "label[class='custom-control-label']")
    private WebElement allStudentFlag;
    @FindBy(id = "btnApply")
    private WebElement applyBtn;

    public void findProgram(String programName) throws InterruptedException {
        ActionsHelper.waitForListExistance(getScholarshipsTab(), waitTime);
      //  ActionsHelper.waitForExistance(getApplicantIDSearchBox(), waitTime);
       // ActionsHelper.selectElementFromList(getScholarshipsTab(), "Applications");

        ActionsHelper.waitForExistance(getFilterSelection(), waitTime);
        getFilterSelection().click();
        Thread.sleep(1000);
        ActionsHelper.waitForExistance(getAllStudentFlag(), waitTime);
       // getAllStudentFlag().click();
        ActionsHelper.waitForExistance(getApplicantIDSearchBox(), waitTime);
        getApplicantIDSearchBox().click();
        getProgramIdSearch().sendKeys(programName + Keys.ENTER);

        getApplyBtn().click();
        Thread.sleep(1000);

//        ActionsHelper.waitForListExistance(getFirstRecord(), waitTime);
//        getFirstRecord().get(0).click();
    }


    public enum ButtonsList {
        Delegate, ApplicationReviewCompleted, ApplicationDocumentsVerified, ApproveAndProceedToAcknowledgement,
        StartReview, RejectApplication, RequestForChange, ScheduleInterview, ApplicantPresent, ApplicantAbsent
    }

    EnumMap<ButtonsList, Integer> buttonTarget =
            new EnumMap<ButtonsList, Integer>(ButtonsList.class);

    public void clearFilters() {
        ActionsHelper.waitForExistance(getClearFiltersButton(), waitTime);
        ActionsHelper.waitForExistance(getApplyButton(), waitTime);
        getClearFiltersButton().click();
    }

    /**
     * @param button Buttons: Delegate, ApplicationReviewCompleted, ApplicationDocumentsVerified, ApproveAndProceedToAcknowledgement, StartReview, RejectApplication, RequestForChange, ScheduleInterview
     */
    public void clickApplicationButton(ButtonsList button) throws Exception {

        //Map of buttons by their names
        buttonTarget.put(ButtonsList.Delegate, 1);
        buttonTarget.put(ButtonsList.ApplicationReviewCompleted, 4);
        buttonTarget.put(ButtonsList.ApplicationDocumentsVerified, 5);
        buttonTarget.put(ButtonsList.ApproveAndProceedToAcknowledgement, 6);
        buttonTarget.put(ButtonsList.StartReview, 2);
        buttonTarget.put(ButtonsList.RejectApplication, 2);
        buttonTarget.put(ButtonsList.RequestForChange, 9);
        buttonTarget.put(ButtonsList.ScheduleInterview, 8);
        buttonTarget.put(ButtonsList.ApplicantPresent, 7);
        buttonTarget.put(ButtonsList.RejectApplication, 10);
        buttonTarget.put(ButtonsList.ApplicantAbsent, 11);


        if (buttonTarget.get(button) == 1) {
            System.out.println("Button1 ");
            ActionsHelper.waitVisibility(getFirstButton(), waitTime);
            getFirstButton().click();
            ActionsHelper.waitVisibility(getNextStepButton(), waitTime);
            getNextStepButton().click();
            ActionsHelper.waitVisibility(getConfirmButton(), waitTime);
            getConfirmButton().click();
        } else if (buttonTarget.get(button) == 2) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            delegateButton = ActionsHelper.getElementFromList(getApplicationButtons(), "Delegate");
            startReviewButton = ActionsHelper.getElementFromList(getApplicationButtons(), "Start Review");
            ActionsHelper.waitForExistance(delegateButton, waitTime);
            ActionsHelper.waitForExistance(startReviewButton, waitTime);
            startReviewButton.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            ActionsHelper.waitForExistance(okButton, waitTime);
            ActionsHelper.retryClick(okButton, 50);
        } else if (buttonTarget.get(button) == 3) {
            System.out.println("Button3");
            ActionsHelper.waitVisibility(getThirdButton(), waitTime);
            getThirdButton().click();
            ActionsHelper.waitVisibility(getNextStepButton(), waitTime);
            getNextStepButton().click();
            ActionsHelper.waitVisibility(getConfirmButton(), waitTime);
            getConfirmButton().click();

        } else if (buttonTarget.get(button) == 4) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            appReviewCompletedButton = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Application Review Completed");
            appReviewCompletedButton.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            System.out.println("OK button: " + okButton.getText());
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        } else if (buttonTarget.get(button) == 5) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            appDocumentsVerifiedButton = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Application Documents Verified");
            ActionsHelper.retryClick(appDocumentsVerifiedButton, 30);
            //appDocumentsVerifiedButton.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            System.out.println("OK button: " + okButton.getText());
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        } else if (buttonTarget.get(button) == 6) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            approveAndProceedToAcknowledgement = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Approve and Proceed to Acknowledgement");
            approveAndProceedToAcknowledgement.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            System.out.println("OK button: " + okButton.getText());
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        } else if (buttonTarget.get(button) == 7) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ApplicantPresent = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Applicant Present");
            ApplicantPresent.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            Thread.sleep(1000);
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();

        } else if (buttonTarget.get(button) == 11) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ApplicantAbsent = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Applicant Absent");
            ApplicantAbsent.click();
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            Thread.sleep(1000);
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();

        } else if (buttonTarget.get(button) == 8) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ScheduleInterview = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Schedule Interview");
            ActionsHelper.retryClick(ScheduleInterview, 50);
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            Thread.sleep(1000);
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        } else if (buttonTarget.get(button) == 9) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            RequestForChange = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Request For Change");
            ActionsHelper.retryClick(RequestForChange, 50);
            //add comment
            ActionsHelper.waitVisibility(getRejectionComment(), waitTime);
            getRejectionComment().sendKeys("RejectionReason123");
            ActionsHelper.waitVisibility(getRequesChangeSubmit(), 30);
            ActionsHelper.safeJavaScriptClick(getRequesChangeSubmit());
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            Thread.sleep(1000);
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        } else if (buttonTarget.get(button) == 10) {
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            ActionsHelper.waitForListExistance(getApplicationButtons(), waitTime);
            RequestForChange = ActionsHelper.getElementFromList(getApplicationButtons(),
                    "Reject Application");
            ActionsHelper.retryClick(RequestForChange, 50);
            //add comment
            ActionsHelper.waitVisibility(getRejectionComment(), waitTime);
            getRejectionComment().sendKeys("RejectionReason123");
            ActionsHelper.waitVisibility(getRequesChangeSubmit(), 30);
            ActionsHelper.safeJavaScriptClick(getRequesChangeSubmit());
            //Submit
            ActionsHelper.waitForListExistance(getAreYouSureLabel(), waitTime);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            submitButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "Submit");
            ActionsHelper.waitForExistance(submitButton, waitTime);
            submitButton.click();
            //Confirm
            ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);
            Thread.sleep(1000);
            ActionsHelper.waitForListExistance(getConfirmationButtons(), waitTime);
            okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
            Thread.sleep(1000);
            ActionsHelper.waitForExistance(okButton, waitTime);
            okButton.click();
        }
    }

    public void searchByKeyWord_ApplicantCode(String keyWord) throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 20);
        getSearchBox().sendKeys(keyWord);
        ActionsHelper.waitVisibility(getBtnApply(), 20);
        ActionsHelper.waitVisibility(getBtnSearch(), 20);
        getBtnSearch().click();

    }

    public void searchByStatus(String statusText, Boolean isAssignedToMe) {
        ActionsHelper.waitVisibility(getSearchBox(), waitTime);
        ActionsHelper.waitVisibility(getCbAssignedToMe(), waitTime);
        ActionsHelper.waitVisibility(getBtnApply(), waitTime);
        System.out.println("Status selected is " + statusText);
        ActionsHelper.actionsClick(getStatusDDL(), statusText);
        ActionsHelper.waitVisibility(getBtnApply(), waitTime);
        ActionsHelper.waitToBeClickable(getBtnApply(), waitTime);
        ActionsHelper.waitForSeconds(waitTime);
        if (isAssignedToMe) {
            getCbAssignedToMe().click();
        }
        ActionsHelper.waitForExistance(getBtnApply(), waitTime);
        getBtnApply().click();
    }

    // this method to schedule interview from admin side
    public void scheduleInterview() throws Exception {
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getBtnPresent(), 100);
        getBtnScheduleInterview().click();
        ActionsHelper.waitForListExistance(getBtnSubmit(), 100);
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), 50);
        getBtnOk().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getWorkflowArea(), waitTime);

    }

    //this method to mark applicant as absence
    public void applicantAbsent() throws Exception {
        System.out.println("after search display results " + getLblFirstResultCode().getText());
        ActionsHelper.waitForExistance(getLblFirstResultCode(), waitTime);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.waitForExistance(getBtnAbsence(), waitTime);
        ActionsHelper.scrollTo(getBtnAbsence());
        ActionsHelper.waitVisibility(getBtnAbsence(), 30);
        getBtnAbsence().click();
        ActionsHelper.waitForExistance(getBtnSubmit().get(0), waitTime);
        System.out.println("Submit size " + getBtnSubmit().size());
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), waitTime);
        getBtnOk().click();
        Thread.sleep(3000);

    }

    //this method to mark applicant as present
    public void applicantPresent() throws Exception {
        // System.out.println( "after search display results " + getLblFirstResultCode().getText() );
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getBtnPresent(), 100);
        getBtnPresent().click();
        ActionsHelper.waitForListExistance(getBtnSubmit(), 100);
        System.out.println("Submit size " + getBtnSubmit().size());
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), 50);
        getBtnOk().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getWorkflowArea(), waitTime);
    }

    public void findProgram1(String programName) throws InterruptedException {
        ActionsHelper.waitForExistance(getProgramsLabel(), waitTime);
        //Thread.sleep( 3000 );
        //ActionsHelper.waitForListExistance(getProgramsList1(), waitTime);
       // getProgramsList1().get(0).click();
        getProgramNameInput().sendKeys(programName);
        getProgramNameInput().sendKeys(Keys.ENTER);
        ActionsHelper.waitForExistance(getBtnApply(), 100);
        getBtnApply().click();
    }

    public void findProgram2(String programName) throws InterruptedException {
        ActionsHelper.waitForExistance(getProgramsLabel(), 1000);
        Thread.sleep(3000);
        ActionsHelper.waitForListExistance(getProgramsList1(), 20);
        getProgramsList1().get(0).click();
        ActionsHelper.waitForListExistance(getProgramsIndex(), 50);
        for (int i = 0; i < getProgramsIndex().size(); i++) {
            if (getProgramsIndex().get(i).getText().equalsIgnoreCase(programName)) {
                getProgramsIndex().get(i).click();
            }
        }

    }

    public void goNextStepProgram(int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.println("Iteration start");
            ActionsHelper.waitVisibility(getNextStepButton(), 50);
            getNextStepButton().click();
            System.out.println("Button1 hit");
            ActionsHelper.waitVisibility(getNextStepButton(), 50);
            getNextStepButton().click();
            System.out.println("Button2 hit");
            ActionsHelper.waitVisibility(getConfirmButton(), 50);
            getConfirmButton().click();
            System.out.println("Button3 hit");
        }
    }

    public void selectFirstResult() {
        ActionsHelper.waitForExistance(getFirstResult(), 50);
        getFirstResult().click();
        System.out.println("Clicked first result");
    }

    public void requestForChange() throws Exception {
        System.out.println("after search display results " + getLblFirstResultCode().getText());
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.scrollTo(getBtnScheduleInterview());
        ActionsHelper.waitForExistance(getBtnRequestForChange(), waitTime);
        getBtnRequestForChange().click();
        ActionsHelper.waitForExistance(getRejectionComment(), 50);
        getRejectionComment().sendKeys("change 123");
        ActionsHelper.safeJavaScriptClick(getRequesChangeSubmit());
        ActionsHelper.waitForExistance(getConfirmButton(), waitTime);
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), waitTime);
        getBtnOk().click();
        ActionsHelper.scrollTo(getLblFirstResultCode());
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getResultsCodes().get(0).click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getResultsCodes().get(0).click();
        ActionsHelper.scrollTo(getWorkflowArea());
        ActionsHelper.waitForExistance(getWorkflowArea(), 10);
    }


    public void activationForm() throws Exception {

        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getStartDateUnv(), 50);
        getStartDateUnv().sendKeys(ActionsHelper.getFutureDate(0, 0, 2));
        getUniversity().sendKeys("Boston University");
        getMajor().sendKeys("Accounting");
        getExpectedGradTerm().sendKeys("2021-2022 Fall");
        getExpectedGraduationDate().sendKeys(ActionsHelper.getFutureDate(0, 2, 3));
        getTotalCreditsGraduation().sendKeys("10");
        getErpStartDate().sendKeys(ActionsHelper.getFutureDate(0, 0, 5));
        getAcademicProgramId().sendKeys("Doctorate");
        ActionsHelper.waitForListExistance(getActiveButton(), 50);
        System.out.println("Button2 hit" + getActiveButton().get(0).getText());
        getActiveButton().get(0).click();
        okButton = ActionsHelper.getElementFromList(getConfirmationButtons(), "OK");
        ActionsHelper.waitForExistance(okButton, 30);
        okButton.click();
        Thread.sleep(10000);
        ActionsHelper.waitForListExistance(getSucessLabel(), waitTime);

    }

}
