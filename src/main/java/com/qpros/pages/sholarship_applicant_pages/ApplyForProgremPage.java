package com.qpros.pages.sholarship_applicant_pages;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Getter
public class ApplyForProgremPage extends Base {

    public static String programTilteLabel = "";

    public ApplyForProgremPage(WebDriver driver) {
        PageFactory.initElements( driver, this );
    }

    //    @FindBy(xpath = "//span[contains(.,'Programs')]")
//    private WebElement programs;
    @FindBy(xpath = "//div/div/div/button")
    private WebElement applyBtn;
    @FindBy(xpath = "//*[@class='btn ml-auto mb-0 btn-primary']//*[text()='Apply']")
    private List<WebElement> multiApplyBtn;
    @FindBy(xpath = "/html/body/div/div/div[3]/button[1]")
    private WebElement yes;
    @FindBy(xpath = "//adek-application-step/a/span")
    private WebElement Step1;
    //    @FindBy(xpath = "//div[@id='kick-start']/div/div/application/form/div[2]/div" +
//            "/div/div/program-dynamic/adek-drop-down/div/ng-select/div/span")
//    private WebElement academicLevel;
//    @FindBy(xpath = "//div[@id='kick-start']/div/div/application/form/div[2]/div/div/div[2]/program-dynamic/adek-drop-down/div/ng-select/div/div/div[2]")
//    private WebElement preferredUniversity;
//    @FindBy(xpath = "(//input[@type='text'])[3]")
//    private WebElement PreferredMajor;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    private WebElement university;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    private WebElement major;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    private WebElement admissionTerm;
    @FindBy(xpath = "(//input[@type='text'])[7]")
    private WebElement admissionType;
    @FindBy(xpath = "/html/body/app-root/app-layout-admin/div[1]/div[2]/div/div/div/scholarship-root/div/ng-component/div/section/div/div/div/div/div/achievement/div[2]/admissions/form/div/div/div[3]/div/div/div[3]/" +
            "div[2]/file-component/div/div[1]/div[2]/div/div/div/div/div/div[1]/div")
    private WebElement admissionLetter;
    @FindBy(css = "input[type='file']")
    private WebElement uploadLetter;
    @FindBy(xpath = "//div[3]/div[2]/button")
    private WebElement uploadButton;
    @FindBy(xpath = "//div[@id='ngxEditor']/div/div")
    private WebElement achievements;
    @FindBy(xpath = "(//div[@id='ngxEditor']/div/div)[2]")
    private WebElement statementPurpose;
    @FindBy(xpath = "//button[contains(.,'Next')]")
    private WebElement btnNext1;
    @FindBy(xpath = "//button[contains(.,'Save As Draft')]")
    private WebElement saveAsDraft;
    @FindBy(xpath = "//button[contains(.,'Confirm')]")
    private WebElement confirm;
    @FindBy(id = "Biographical")
    private WebElement personalInfo;
    // --------- step 2
    @FindBy(xpath = "//input[@type='text']")
    private WebElement currentEducationLevel;
    @FindBy(xpath = "//input[@type='text'][3]")
    private WebElement schoolInstitName;
    @FindBy(xpath = "//input[@type='text'][4]")
    private WebElement schoolInstitType;
    @FindBy(xpath = "//input[@type='text'][5]")
    private WebElement curriculum;
    @FindBy(css = "input[type='file']")
    private WebElement eduCertificate;
    @FindBy(xpath = "//button[contains(.,'Upload')]")
    private WebElement uploadCertButton;
    @FindBy(xpath = "//span[contains(.,'My Applications')]")
    private WebElement myApplication;
    //---------step  4 based on program setups
    @FindBy(xpath = "//input[@type='text']")
    private WebElement step4GuardianName;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement step4GuardianRelation;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement step4Phone;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    private WebElement step4Email;
    @FindBy(xpath = "//button[contains(.,'Submit Application')]")
    private WebElement submitApplication;
    @FindBy(xpath = "//button[contains(.,'Return to Dashboard')]")
    private WebElement returnToDashboard;
    //------- for program lists
    @FindBy(css = "div[class='card-body']")
    private List<WebElement> programDiv;
    @FindBy(css = "h5[class='card-title']")
    private List<WebElement> programTilte;
    @FindBy(css = "p[class='card-text text-muted']")
    private List<WebElement> programDate;
    @FindBy(css = "button[tabindex='0']")
    private List<WebElement> programButton;
    @FindBy(css = "h4[class='card-title']")
    private List<WebElement> applicantProgramTilte;


    @FindBy(xpath = "//span[starts-with(@class,'menu-title')]")
    private List<WebElement> programs;
    @FindBy(xpath = "//div[starts-with(@class, 'ng-value-container')]")
    private List<WebElement> step1EducationLists;
    @FindBy(xpath = "//div[@class = 'ng-select-container' and contains(text(), 'Preferred University')]")
    private WebElement preferredUniversity;
    @FindBy(xpath = "//div[@class = 'ng-select-container' and contains(text(), 'Preferred Major')]")
    private WebElement PreferredMajor;

    @FindBy(xpath = "//span[starts-with(@class, 'ng-option-label')]")
    private List<WebElement> step1Lists;

    @FindBy(id = "docUp73")
    private WebElement step2EducationLable;
    @FindBy(id = "docUp79")
    private WebElement step3ProficiencyLable;


    public void saveAsDrat(String programTitle) throws Exception {
        programeSharedSteps( programTitle );
        ActionsHelper.waitVisibility( getSaveAsDraft(), 10 );
        getSaveAsDraft().click();
        ActionsHelper.waitVisibility( getConfirm(), 10 );
        getConfirm().click();
       // findDraftApplication( programTitle );
    }

    public void submitProgram(String ProgramTitle) throws Exception {
        programeSharedSteps( ProgramTitle );
        Thread.sleep( 5000 );
        ActionsHelper.waitForExistance( getStep4GuardianName(), 30 );
        ActionsHelper.waitForExistance( getSubmitApplication(), 30 );
        getSubmitApplication().click();
        ActionsHelper.waitForExistance( getConfirm(), 30 );
        getConfirm().click();
        ActionsHelper.waitForExistance( getStep4Email(), 10 );
        ActionsHelper.waitForExistance( getStep4Phone(), 10 );
    }

    // to apply for one program
    public void applyForProgram(String ProgrameTitle) throws InterruptedException {
        ActionsHelper.waitForListExistance( getPrograms(), 30 );
        ActionsHelper.selectElementFromList( getPrograms(), "Programs" );
        //getPrograms().click();
        selectProgram( ProgrameTitle );
        ActionsHelper.waitVisibility( getStep1(), 15 );
    }


    public void findDraftApplication(String programTitle) throws InterruptedException {
        System.out.println( "Current Date: " + ActionsHelper.getTodayDate() );
        ActionsHelper.waitVisibility( getMyApplication(), 15 );
        Thread.sleep( 10000 );
        getMyApplication().click();
        Thread.sleep( 10000 );
        System.out.println( "Program Size: " + getProgramDiv().size() );
        System.out.println( "Title Size: " + getApplicantProgramTilte().size() );
        //System.out.println("Button Size: "+ getApplicationButton().size());
        for (int i = 0; i < getApplicantProgramTilte().size(); i++) {
            programTilteLabel = getApplicantProgramTilte().get( i ).getText();
            if (programTilteLabel.equalsIgnoreCase( programTitle )) {
                break;
            }
        }
    }

    // to check whether the program status is drafted (go to my application) or new (apply)
    public void selectProgram(String programTitle) throws InterruptedException {
        ActionsHelper.waitForListExistance( getProgramDiv(), 30 );
        ActionsHelper.selectElementFromList( getProgramDiv(), "Programs" );
        System.out.println( "Program Size: " + getProgramDiv().size() );
        System.out.println( "Title Size: " + getProgramTilte().size() );
        System.out.println( "Button Size: " + getProgramButton().size() );
        for (int i = 0; i < getProgramDiv().size(); i++) {
            programTilteLabel = getProgramTilte().get( i ).getText();
            String programDate = getProgramDate().get( i ).getText();
            String programButton = getProgramButton().get( i ).getText();
            System.out.println( "Program Title: " + programTilte );
            System.out.println( "Program Date: " + programDate );
            System.out.println( "Program Button: " + programButton );
            if (programTilteLabel.equalsIgnoreCase( programTitle ) &&
                    programButton.equalsIgnoreCase( "apply" )
                    && getProgramButton().get( i ).isEnabled()) {
                getProgramButton().get( i ).click();
                break;
            }
        }
    }


    public void getProgram(String value) {
        HashMap<String, WebElement> map = new HashMap();

        for (int i = 0; i < getProgramDiv().size(); i++) {
            if (getProgramButton().get( i ).getText().equalsIgnoreCase( "apply" )) {

                map.put( getProgramDiv().get( i ).getText().substring( 0, 21 ), getProgramButton().get( i ) );
                System.out.print( "Saved title: " + map.keySet() );
                System.out.println( "------ Saved button: " + map.get( getProgramDiv().get( i ).getText() ) );
                if (getProgramTilte().get( i ).getText().equalsIgnoreCase( value )) {
                    getProgramButton().get( i ).click();
                    break;
                }
            }
        }
        //System.out.println( "Map size: " + map.size() );

        //WebElement element = map.get( value );

    }


    public void programeSharedSteps(String programTitle) throws Exception {
        System.out.println( "Current Date: " + ActionsHelper.getTodayDate() );
        Thread.sleep( 5000 );
        ActionsHelper.waitForListExistance( getPrograms(), 50 );
        ActionsHelper.selectElementFromList( getPrograms(), "Programs" );
        ActionsHelper.waitForListExistance( getProgramTilte(), 30 );

        ActionsHelper.waitForListExistance( getPrograms(), 30 );
        //selectProgram( programTitle );
        getProgram( programTitle );
        //WebElement applyButton = getProgram( programTitle );
        //ActionsHelper.actionsClick( applyButton, programTitle );
        //ActionsHelper.safeJavaScriptClick( applyButton );


        Thread.sleep( 8000 );
        ActionsHelper.waitForListExistance( getStep1EducationLists(), 50 );
        getStep1EducationLists().get( 0 ).click();
        ActionsHelper.waitForListExistance( getStep1Lists(), 20 );
        ActionsHelper.selectElementFromList( getStep1Lists(), "Doctorate" );

        ActionsHelper.waitForListExistance( getStep1EducationLists(), 20 );
        getStep1EducationLists().get( 1 ).click();
        ActionsHelper.waitForListExistance( getStep1Lists(), 50 );
        ActionsHelper.selectElementFromList( getStep1Lists(), "Boston University" );

        ActionsHelper.waitForListExistance( getStep1EducationLists(), 20 );
        getStep1EducationLists().get( 2 ).click();
        ActionsHelper.waitForListExistance( getStep1Lists(), 50 );
        ActionsHelper.selectElementFromList( getStep1Lists(), "Accounting" );

        ActionsHelper.waitForExistance( getAchievements(), 30 );
        getAchievements().sendKeys( "test33" );

        ActionsHelper.waitForExistance( getBtnNext1(), 50 );
        getBtnNext1().click();// step 1
        ActionsHelper.waitForExistance( getStep2EducationLable(), 50 );// step 2
        getBtnNext1().click();
        ActionsHelper.waitForExistance( getStep3ProficiencyLable(), 50 );// step 3
        getBtnNext1().click();// step 3

    }


}