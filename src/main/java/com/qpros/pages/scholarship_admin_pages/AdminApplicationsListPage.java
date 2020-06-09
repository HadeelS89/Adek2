package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

@Getter
public class AdminApplicationsListPage extends Base{

    public AdminApplicationsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchbox")
    private WebElement searchBox;
    @FindBy(id="btnGroupAddon2")
    private WebElement btnSearch;
    @FindBy(xpath="//*[@id=\"mainDiv\"]/div[3]/div[1]/div[2]/div[1]/div[1]")
    private WebElement lblFirstResultCode;
    //TODO: Locate Status Drop down list
    @FindBy(xpath="//div[@id='filterContainer']/div/div[3]/select")
    private WebElement statusDDL;
    @FindBy(css="div[class='col-md-auto']")
    private List<WebElement> resultsCodes;
    @FindBy(id="btnApply")
    private WebElement btnApply;
    @FindBy(xpath="//input[@type='checkbox']")
    private WebElement cbAssignedToMe;
    @FindBy(css="button[value='StartReview']")
    private List<WebElement> btnStartReviews;
    @FindBy(xpath = "(//button[@name='button'])[2]")
    private WebElement btnAbsence;
    @FindBy(xpath = "//button[@name='button']")
    private WebElement btnPresent;
    @FindBy(xpath = "//div[7]/div/button")
    private List <WebElement> btnSubmit;
    //private List<WebElement> btnSubmit;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement btnOk;
    @FindBy(css = "div[row adek-table-row']")
    private List<WebElement> resultsApplicant;
    @FindBy(css="ul[class='select2-selection__rendered']")
    private List<WebElement> programsList;
    @FindBy(css="li[class='select2-results__option']")
    private List<WebElement> programsIndex;
    @FindBy(css=".confirm")
    private WebElement nextStepButton;
    @FindBy(css=".ml-2:nth-child(1)")
    private WebElement confirmButton;
    @FindBy(css=".font-weight-bold > .col-md-auto:nth-child(3)")
    private WebElement firstResult;
    @FindBy(css=".btn-success:nth-child(2)")
    private WebElement secondThing;
    @FindBy(xpath = "//button[3]")
    private WebElement btnScheduleInterview;



    public void searchByKeyWord_ApplicantCode(String keyWord) throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 20);
        getSearchBox().sendKeys(keyWord);
        ActionsHelper.waitVisibility(getBtnApply(), 20);
        ActionsHelper.waitVisibility(getBtnSearch(), 20);
        getBtnSearch().click();

    }

    public void searchByStatus(String statusText, Boolean isAssignedToMe){
        ActionsHelper.waitVisibility(getSearchBox(), 90);
        ActionsHelper.waitVisibility(getCbAssignedToMe(), 90);
        ActionsHelper.waitVisibility(getBtnApply(), 90);
        System.out.println("Status selected is " + statusText );
        //ActionsHelper.selectByValue(getStatusDDL(), statusText);
        ActionsHelper.actionsClick(getStatusDDL(),statusText);
        ActionsHelper.waitVisibility(getBtnApply(), 90);
        ActionsHelper.waitToBeClickable(getBtnApply(), 90);
        ActionsHelper.waitForSeconds(90);
        if (isAssignedToMe){
            getCbAssignedToMe().click();
        }
        ActionsHelper.waitForExistance(getBtnApply(),90);

    }

    // this method to schedule interview from admin side
    public void scheduleInterview() throws Exception {
        ActionsHelper.safeJavaScriptClick(getBtnApply());// after select program then select apply filter
        System.out.println("after search display results " + getLblFirstResultCode().getText());
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.scrollTo(getBtnScheduleInterview());
        ActionsHelper.waitForExistance(getBtnScheduleInterview(),90);
        getBtnScheduleInterview().click();
        ActionsHelper.waitForExistance(getBtnSubmit().get(0), 90);
        System.out.println("Submit size " + getBtnSubmit().size());
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), 90);
        getBtnOk().click();
        Thread.sleep(3000);
    }

    //this method to mark applicant as absence
    public void applicantAbsent() throws Exception {
        System.out.println("after search display results " + getLblFirstResultCode().getText());
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 90);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.waitForExistance(getBtnAbsence(), 90);
        ActionsHelper.scrollTo(getBtnAbsence());
        ActionsHelper.waitVisibility(getBtnAbsence(), 30);
        getBtnAbsence().click();
        ActionsHelper.waitForExistance(getBtnSubmit().get(0), 90);
        System.out.println("Submit size " + getBtnSubmit().size());
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        ActionsHelper.waitForExistance(getBtnOk(), 90);
        getBtnOk().click();
        Thread.sleep(3000);

    }

    //this method to mark applicant as present
    public void applicantPresent() throws Exception {
        Thread.sleep(10000);
        System.out.println("after search display results " + getLblFirstResultCode().getText());
        ActionsHelper.waitVisibility(getLblFirstResultCode(), 30);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.waitVisibility(getBtnPresent(), 30);
        ActionsHelper.scrollTo(getBtnPresent());
        ActionsHelper.waitVisibility(getBtnPresent(), 30);
        getBtnPresent().click();
        Thread.sleep(4000);
        ActionsHelper.waitVisibility(getBtnSubmit().get(0), 10);
        System.out.println("Submit size on present " + getBtnSubmit().size());
        ActionsHelper.safeJavaScriptClick(getBtnSubmit().get(0));
        Thread.sleep(4000);
        ActionsHelper.waitVisibility(getBtnOk(), 50);
        getBtnOk().click();
        Thread.sleep(3000);
    }
    public void findProgram(String programName) throws Exception {
        System.out.println("program Name:"+ programName );
        ActionsHelper.waitForExistance(getProgramsList().get( 0 ), 60);
        System.out.println("List size:"+ getProgramsList().size());
        getProgramsList().get( 0 ).click();
        ActionsHelper.waitVisibility(getProgramsIndex().get( 0 ), 30);
        System.out.println("program list size:"+ getProgramsIndex().size());
        for (int i = 0; i<getProgramsIndex().size(); i++){
            if (getProgramsIndex().get( i ).getText().equalsIgnoreCase( programName )){
                getProgramsIndex().get( i ).click();
            }
        }


    }

    public void goNextStepProgram(int iterations){
        for (int i=0; i<iterations; i++) {
            System.out.println("Iteration start");
            ActionsHelper.waitVisibility(getNextStepButton(), 90);
            getNextStepButton().click();
            System.out.println("Button1 hit");
            ActionsHelper.waitVisibility(getNextStepButton(), 90);
            getNextStepButton().click();
            System.out.println("Button2 hit");
            ActionsHelper.waitVisibility(getConfirmButton(), 90);
            getConfirmButton().click();
            System.out.println("Button3 hit");
        }
    }
    public void selectFirstResult(){
        ActionsHelper.waitVisibility(getFirstResult(), 90);
        getFirstResult().click();
        System.out.println("Clicked first result");
    }

}
