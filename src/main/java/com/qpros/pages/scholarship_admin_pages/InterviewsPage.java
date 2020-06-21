package com.qpros.pages.scholarship_admin_pages;

import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InterviewsPage {

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
    @FindBy(id = "StartTime")
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
//    @FindBy(xpath = "//h2[contains(.,'Success')]")
//    private WebElement successScore;



    public void addNewInterview(String programTitle) throws InterruptedException {
        ActionsHelper.waitForListExistance(getInterviewsTab(), 50);
        ActionsHelper.selectElementFromList(getInterviewsTab(), "Interviews");
        // System.out.println("Divs size: "+getProgramsDiv().size());
        ActionsHelper.waitForListExistance(getAddInterviewButton(), 30);
        getAddInterviewButton().get(0).click();
        ActionsHelper.waitForExistance(getProgramDDL(), 50);
        getProgramDDL().sendKeys(programTitle);
        getProvideVenue().sendKeys("room 123");
        getDescriptionEnglish().sendKeys("1234");
        getDescriptionArabic().sendKeys("3444");
        getDate().sendKeys(ActionsHelper.getFutureDate(0, 0, 3));
        getStartTime().sendKeys("10:30", Keys.ARROW_UP);
        getEndTime().sendKeys("11:00", Keys.ARROW_UP);
        getCapacity().sendKeys("1");
        getSubmitInterView().click();
        ActionsHelper.waitForExistance(getSuccess(), 20);
    }

    //for search box
    public void searchInterview(String programName) throws InterruptedException {
        ActionsHelper.waitForListExistance(getInterviewsTab(), 50);
        ActionsHelper.selectElementFromList(getInterviewsTab(), "Interviews");
        ActionsHelper.waitForExistance(getInterviewSearchBox(), 90);
        getInterviewSearchBox().sendKeys(programName);
        ActionsHelper.waitForExistance(getSearchBtn(),30);
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
       // Thread.sleep(10000);
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
        ActionsHelper.waitForExistance(getInterviewComment(), 30);
        getInterviewComment().sendKeys("121322");
        getCalculateScore().click();
        getBtnSubmit().click();
        ActionsHelper.waitForExistance(getSuccess(), 20);
    }
}

