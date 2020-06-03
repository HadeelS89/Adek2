package com.qpros.pages.sholarship_applicant_pages;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Getter
public class MyApplicationsPage extends Base {

    public MyApplicationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(.,'My Applications')]")
    private WebElement myApplication;


    @FindBy(css = "div[class='card shadow-sm']")
    private List<WebElement> applicationDiv;
    @FindBy(css = "h4[class='card-title']")
    private List<WebElement> applicationTilte;
    //    @FindBy(css = "p[class='card-text text-muted']")
//    private List<WebElement> programDate;
    @FindBy(xpath = "//div[2]/div/div[2]/div[2]/div/div[3]/button/i")
    private WebElement editAdmission;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement editMajor;
    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement editSaveBtn;
    @FindBy(xpath = "//div[2]/div/div[2]/div[2]/div/div[3]/button[2]/i")
    private WebElement editProfDetails;
    @FindBy(xpath = "//input[@placeholder='IELTS - UKVI Score']")
    private WebElement editIELTS;
    @FindBy(xpath = "//div[@id='docUp74']/div/div")
    private WebElement uploadIELTSField;
    @FindBy(css = "input[type='file']")
    private WebElement uploadIELTS;
    @FindBy(xpath = "//div[3]/div[2]/button")
    private WebElement uploadButton;
    @FindBy(xpath = "(//button[@type='button'])[11]")
    private WebElement goToMyApp;
    // confirm interview locators
    @FindBy(xpath = "//button[contains(.,'Book Interview')]")
    private WebElement bookInterview;
    @FindBy(xpath = "//label")
    private WebElement interviewTime;
    @FindBy(xpath = "//span[contains(.,'Confirm Interview')]")
    private WebElement confirmInterview;
    //@FindBy(xpath = "//button[contains(.,'Confirm')]")
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")
    private List<WebElement> confirm;
    @FindBy(xpath = "//span[contains(.,'Cancel Interview')]")
    private WebElement cancelInterview;

    // to confirm interview for applicant:mdamati@outlook.com - Test@123
    public void confirmInterview(String progarmTitle) throws Exception {
       // System.out.println("Current Date: " + ActionsHelper.getTodayDate())
        ActionsHelper.waitVisibility(getMyApplication(), 50);
       // Thread.sleep(20000);
        getMyApplication().click();
       Thread.sleep(10000);
        ActionsHelper.waitVisibility(getApplicationDiv().get(0),30);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        //System.out.println("Button Size: "+ getApplicationButton().size());
        for (int i = 0; i < getApplicationDiv().size(); i++) {

            String programTilte = getApplicationTilte().get(i).getText();

            System.out.println("Program Title: " + programTilte);
            if ((programTilte.equalsIgnoreCase(programTilte)
                    && getBookInterview().isEnabled())) {
                System.out.println("Program Title inside if: " + programTilte);
                getBookInterview().click();
                ActionsHelper.waitVisibility(getInterviewTime(), 30);
                getInterviewTime().click();
                ActionsHelper.waitVisibility(getConfirmInterview(), 30);
                getConfirmInterview().click();
                ActionsHelper.waitVisibility(getConfirm().get(0), 30);
                System.out.println("Button size: "+getConfirm().size());
                getConfirm().get(0).click();
                break;

            }
        }


    }


    public void myApplication() throws InterruptedException {
        ActionsHelper.waitVisibility(getMyApplication(), 5);
        getMyApplication().click();


    }

    public void applicationEdits(String programTitle) throws Exception {
        System.out.println("Current Date: " + ActionsHelper.getTodayDate());
        ActionsHelper.waitVisibility(getMyApplication(), 15);
        getMyApplication().click();
        Thread.sleep(10000);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        //System.out.println("Button Size: "+ getApplicationButton().size());
        for (int i = 0; i < getApplicationDiv().size(); i++) {
            String programTilte = getApplicationTilte().get(i).getText();

            System.out.println("Program Title: " + programTilte);

            if (programTilte.equalsIgnoreCase(programTitle)
                    && getEditAdmission().isEnabled()) {
                System.out.println("Program Title inside if: " + programTilte);
                getEditAdmission().click();
                ActionsHelper.waitVisibility(getEditMajor(), 5);
                getEditMajor().clear();
                getEditMajor().sendKeys("edit 1");
                ActionsHelper.waitVisibility(getEditSaveBtn(), 5);
                getEditSaveBtn().click();
                ActionsHelper.waitVisibility(getEditProfDetails(), 10);
                getEditProfDetails().click();
                ActionsHelper.waitVisibility(getEditIELTS(), 10);
                getEditIELTS().sendKeys("5");
                ActionsHelper.waitVisibility(getUploadIELTSField(), 15);
                getUploadIELTSField().click();
                ActionsHelper.waitVisibility(getUploadIELTS(), 15);
                getUploadIELTS().sendKeys("C:\\Users\\HadeelSalameh\\" +
                        "Pictures\\image.PNG");
                ActionsHelper.safeJavaScriptClick(getUploadButton());
                ActionsHelper.waitVisibility(getEditSaveBtn(), 15);
                getEditSaveBtn().click();
                // ActionsHelper.waitVisibility(getGoToMyApp(),15);


                break;

            }

        }


    }

}
