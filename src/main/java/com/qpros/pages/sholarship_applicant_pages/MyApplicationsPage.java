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

    public boolean result = false;
    @FindBy(xpath = "//span[contains(.,'My Applications')]")
    private WebElement myApplication;
    @FindBy(css = "div[class='card shadow-sm']")
    private List<WebElement> applicationDiv;
    @FindBy(css = "h4[class='card-title']")
    private List<WebElement> applicationTilte;
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
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")
    private List<WebElement> confirm;
    @FindBy(xpath = "//span[contains(.,'Cancel Interview')]")
    private WebElement cancelInterview;
    @FindBy(xpath = "//button[contains(text(), 'Acknowledge Application')]")
    private List<WebElement> acknowledge;
    @FindBy(xpath = "//span[contains(.,'Decline')]")
    private WebElement declineAcc;
    @FindBy(xpath = "//div[@id='toast-container']/div/div[2]")
    private WebElement declineValidation;
    @FindBy(xpath = "//textarea[@placeholder='Comments']")
    private WebElement declineTextArea;
    @FindBy(xpath = "//span[contains(.,'Accept')]")
    private WebElement acceptAcc;


    public void acknowledgeApplicantion(String programTitle) throws Exception {
        ActionsHelper.waitForExistance(getMyApplication(), 100);
        getMyApplication().click();
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        for (int i = 0; i < getApplicationDiv().size(); i++) {
            String programTilte = getApplicationTilte().get(i).getText();
            System.out.println("Program Title: " + programTilte);
            //System.out.println("check name1: " + getAcknowledge());
            System.out.println("check name2: " + getAcknowledge().get(i).getText());
            if ((programTilte.equalsIgnoreCase(programTitle)
                    && getAcknowledge().get(i).isEnabled())) {
                System.out.println("Program Title inside if: " + programTilte);
                System.out.println("Program Title inside if222: " +
                        getAcknowledge().get(i).getText());
                result = true;
                break;
            }
        }
    }

    // this method to decline application by leaving the message filed empty
    public void declineApplicationEmpty(String programTitle) throws Exception {
        ActionsHelper.waitForExistance(getMyApplication(), 100);
        getMyApplication().click();
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        for (int i = 0; i < getApplicationDiv().size(); i++) {
            String programTilte = getApplicationTilte().get(i).getText();
            System.out.println("Program Title: " + programTilte);
            // System.out.println("check size in for: " + getAcknowledge().size());
            if ((programTilte.equalsIgnoreCase(programTitle)
                    && getAcknowledge().get(i).isEnabled())) {
                System.out.println("Program Title inside if: " + programTilte);
                System.out.println("Program Title inside if222: " +
                        getAcknowledge().get(i).getText());
                ActionsHelper.scrollTo(getAcknowledge().get(i));
                ActionsHelper.waitForExistance(getAcknowledge().get(i), 50);
                getAcknowledge().get(i).click();
                ActionsHelper.waitForExistance(getDeclineAcc(), 50);
                getDeclineAcc().click();
                break;

            }
        }
    }

    // this method to decline application by entering valid text
    public void declineApplicationWithMessage(String programTitle) throws Exception {
        ActionsHelper.waitForExistance(getMyApplication(), 100);
        getMyApplication().click();
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        for (int i = 0; i < getApplicationDiv().size(); i++) {
            String programTilte = getApplicationTilte().get(i).getText();
            System.out.println("Program Title: " + programTilte);
            // System.out.println("check size in for: " + getAcknowledge().size());
            if ((programTilte.equalsIgnoreCase(programTitle)
                    && getAcknowledge().get(i).isEnabled())) {
                System.out.println("Program Title inside if: " + programTilte);
                System.out.println("Program Title inside if222: " +
                        getAcknowledge().get(i).getText());
                ActionsHelper.scrollTo(getAcknowledge().get(i));
                ActionsHelper.waitForExistance(getAcknowledge().get(i), 50);
                getAcknowledge().get(i).click();
                ActionsHelper.waitForExistance(getDeclineAcc(), 50);
                getDeclineTextArea().sendKeys("1235");
                getDeclineAcc().click();
                ActionsHelper.waitForListExistance(getAcknowledge(), 50);
                result = true;
                break;

            }
        }
    }

    // this method to accept application
    public void acceptApplication(String programTitle) throws Exception {
        ActionsHelper.waitForExistance(getMyApplication(), 100);
        getMyApplication().click();
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
        ActionsHelper.waitForListExistance(getApplicationDiv(), 100);
        for (int i = 0; i < getApplicationDiv().size(); i++) {
            String programTilte = getApplicationTilte().get(i).getText();
            System.out.println("Program Title: " + programTilte);
            // System.out.println("check size in for: " + getAcknowledge().size());
            if ((programTilte.equalsIgnoreCase(programTitle)
                    && getAcknowledge().get(i).isEnabled())) {
                System.out.println("Program Title inside if: " + programTilte);
                System.out.println("Program Title inside if222: " +
                        getAcknowledge().get(i).getText());
                ActionsHelper.scrollTo(getAcknowledge().get(i));
                ActionsHelper.waitForExistance(getAcknowledge().get(i), 50);
                getAcknowledge().get(i).click();
                ActionsHelper.waitForExistance(getDeclineAcc(), 50);
                getDeclineTextArea().sendKeys("1235");
                getAcceptAcc().click();
                ActionsHelper.waitForListExistance(getAcknowledge(), 50);
                result = true;
                break;
            }
        }
    }

    // to confirm interview for applicant:mdamati@outlook.com - Test@123
    public void confirmInterview(String progarmTitle) throws Exception {
        ActionsHelper.waitVisibility(getMyApplication(), 50);
        getMyApplication().click();
        ActionsHelper.waitForListExistance(getApplicationDiv(), 90);
        System.out.println("Program Size: " + getApplicationDiv().size());
        System.out.println("Title Size: " + getApplicationTilte().size());
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
                System.out.println("Button size: " + getConfirm().size());
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
                break;

            }

        }

    }

}
