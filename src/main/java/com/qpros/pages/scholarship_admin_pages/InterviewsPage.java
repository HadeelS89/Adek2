package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InterviewsPage extends Base {

    public static String randomName = "";
    public static String createdProgram = "";

    public InterviewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> interviewsTab;
    @FindBy(id = "ProgramId")
    private WebElement programDDL;
    @FindBy(className = "col-md-auto")
    private List<WebElement> programsDiv;
    @FindBy(css = "i[class='btn-addon-icon fe fe-plus-circle']")
    private List<WebElement> addInterviewButton;
    @FindBy(id = "Venue")
    private WebElement provideVenue;
    @FindBy(id = "DescriptionEnglish")
    private WebElement descriptionEnglish;
    @FindBy(id = "DescriptionArabic")
    private WebElement descriptionArabic;
    @FindBy(id = "Date")
    private WebElement date;
    @FindBy(xpath = "//*[@id=\"StartTime\"]")
    private WebElement startTime;
    @FindBy(id = "EndTime")
    private WebElement endTime;
    @FindBy(id = "Capacity")
    private WebElement capacity;
    @FindBy(id = "btnSubmit")
    private WebElement submitInterView;
    @FindBy(xpath = "//p[contains(.,'Success')]")
    private WebElement success;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement btnOK;
    @FindBy(id = "searchbox")
    private WebElement interviewSearchBox;
    @FindBy(css = "div[class='col-md-auto']")
    private List<WebElement> firstRecord;
    @FindBy(xpath = "//i[starts-with(@class,'fa fa-address-card-o')]")
    private List<WebElement> applicantSummary;
    // for assessment buttons :
    @FindBy(xpath = "//label[@class='btn-notacceptable' and contains(text(), 'Not Acceptable')]")
    private List<WebElement> notAcceptableBtn;
    @FindBy(xpath = "//label[@class='btn-poor' and contains(text(), 'Poor')]")
    private List<WebElement> poorBtn;
    @FindBy(xpath = "//label[@class='btn-acceptable' and contains(text(), 'Acceptable')]")
    private List<WebElement> acceptableBtn;
    @FindBy(xpath = "//label[@class='btn-good' and contains(text(), 'Good')]")
    private List<WebElement> goodBtn;
    @FindBy(xpath = "//label[@class='btn-excellent' and contains(text(), 'Excellent')]")
    private List<WebElement> excellentBtn;
    @FindBy(id = "InterviewResult_Comment")
    private WebElement InterviewComment;
    @FindBy(id = "btnScoreSubmit")
    private WebElement btnSubmit;
    @FindBy(id = "cal_score")
    private WebElement calculateScore;
    @FindBy(id = "btnGroupAddon2")
    private WebElement searchBtn;
    @FindBy(id = "SpanScoreAlreadySubmitted")
    private WebElement scoreSuccessText;
//    @FindBy(xpath = "//h2[contains(.,'Success')]")
//    private WebElement successScore;

    public void addNewInterview(String programTitle)  {
        if (isHeadless) {
            ActionsHelper.navigateTo("https://apps-tst.adek.gov.ae/ScholarshipNew/ScholarshipAdminUI/Interview");
        } else {
            ActionsHelper.waitForListExistance(getInterviewsTab(), 50);
            ActionsHelper.selectElementFromList(getInterviewsTab(), "Interviews");
        }
        // ActionsHelper.waitForListExistance(getAddInterviewButton(), 50);
        ActionsHelper.retryClick(getAddInterviewButton().get(0),30);
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        // ActionsHelper.waitForExistance(getProgramDDL(), 50);
        ActionsHelper.actionsClick(getProgramDDL(), programTitle);
        ActionsHelper.actionsClick(getProvideVenue(), "MeetingRoom B ");
        ActionsHelper.actionsClick(getDescriptionEnglish(), "1234");
        getDescriptionArabic().sendKeys("3444");
        getDate().sendKeys(ActionsHelper.getFutureDate(0, 2, 3));
        ActionsHelper.actionsClick(getStartTime(), ActionsHelper.getFutureTime(2, 5));
        ActionsHelper.actionsClick(getEndTime(), ActionsHelper.getFutureTime(3, 5));
        getCapacity().sendKeys("1");
        getSubmitInterView().click();
        ActionsHelper.waitForExistance(getSuccess(), 20);
    }

    //for search box
    public void searchInterview(String programName) throws InterruptedException {
        if (isHeadless) {
            ActionsHelper.navigateTo("https://apps-tst.adek.gov.ae/ScholarshipNew/ScholarshipAdminUI/Interview");
        } else {

            ActionsHelper.waitForListExistance(getInterviewsTab(), 100);
            ActionsHelper.selectElementFromList(getInterviewsTab(), "Interviews");
        }
        ActionsHelper.waitForExistance(getInterviewSearchBox(), 90);
        getInterviewSearchBox().sendKeys(programName);
        ActionsHelper.waitForExistance(getSearchBtn(), 100);
        getSearchBtn().click();
        ActionsHelper.waitForListExistance(getFirstRecord(), 100);

    }

    public void addScore(WebDriver driver) throws InterruptedException {

        ActionsHelper.waitForListExistance(getFirstRecord(), 100);
        System.out.println(getFirstRecord().size());
        getFirstRecord().get(0).click();
        System.out.println("applicant summary " + getApplicantSummary().size());
        ActionsHelper.waitForListExistance(getApplicantSummary(), 60);
        getApplicantSummary().get(0).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        ActionsHelper.waitForListExistance(getGoodBtn(), 60);
        System.out.println("GoodBtn size " + getGoodBtn().size());
        getGoodBtn().get(0).click();
        getAcceptableBtn().get(1).click();
        getExcellentBtn().get(2).click();
        getGoodBtn().get(3).click();
        getPoorBtn().get(4).click();
        getGoodBtn().get(5).click();
        ActionsHelper.waitForExistance(getInterviewComment(), 50);
        getInterviewComment().sendKeys("121322");
        getCalculateScore().click();
        ActionsHelper.retryClick(getBtnSubmit(),50);
        //getBtnSubmit().click();
        ActionsHelper.waitForExistance(getScoreSuccessText(), 50);

    }
}

