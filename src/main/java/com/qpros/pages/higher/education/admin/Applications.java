package com.qpros.pages.higher.education.admin;

import com.github.javafaker.Faker;
import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.Data;
import com.qpros.pages.Locators;
import com.qpros.pages.authorization_pages.LoginPage;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


@Getter
public class Applications {

    public Applications(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = Locators.APPLICATION_TAB)
    private List<WebElement> applicationTab;
    @FindBy(id = Locators.SEARCH_BOX)
    private WebElement searchBox;
    @FindBy(css = ".ApplicationSchoolName")
    private WebElement applicationSchoolName;
    @FindBy(css = ".btn-success")
    private WebElement applicationAssignButton;
    @FindBy(id = "typeahead_AssignedTo")
    private WebElement applicationAssignTo;
    @FindBy(xpath = "//a[contains(.,' Process Coordinator1')]")
    private WebElement applicationSelectAssignee;
    @FindBy(id = "adekFlowCommandParamSubmit")
    private WebElement adekFlowCommandParamSubmit;
    @FindBy(css = ".swal2-confirm")
    private WebElement adekFlowCommandParamSubmitConfirm;
    @FindBy(css = ".dropdown-toggle")
    private WebElement logoutDropDown;
    @FindBy(xpath = "//a[contains(@href, '/HEIAuthorizationSystem/Admin/Home/Logout')]")
    private WebElement logoutDropDownClick;
    @FindBy(xpath = "//input[@value='Send technical report for approval']")
    private WebElement sendToTechApproval;
    @FindBy(css = "swal2-title")
    private WebElement successWaitFor;
    @FindBy(xpath = "//button[contains(.,'Submit')]")
    private WebElement successWaitForOK;
    @FindBy(xpath = "//button[contains(.,'Yes')]")
    private WebElement yesButton;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement okButton;
    @FindBy(xpath = "//button[contains(.,'Review accepted and needing changes by HEI')]")
    private WebElement reviewAcceptedButton;
    @FindBy(id = "Comment")
    private WebElement commentTextArea;
    @FindBy(id = "adekFlowCommandParamSubmit")
    private WebElement commandParamSubmit;


    private final String programName = "NP_0052";

    public void ApplicationProcessStatusNew() throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 30);
        getSearchBox().click();
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.waitVisibility(getApplicationSchoolName(), 30);
        getApplicationSchoolName().click();
        ActionsHelper.waitVisibility(getApplicationAssignButton(), 20);
        getApplicationAssignButton().click();
        ActionsHelper.waitVisibility(getApplicationAssignTo(), 20);
        getApplicationAssignTo().click();
        getApplicationAssignTo().sendKeys("Process Coordinator1");
        ActionsHelper.waitVisibility(getApplicationSelectAssignee(), 20);
        getApplicationSelectAssignee().click();
        getAdekFlowCommandParamSubmit().click();
        //ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(),30);
        // getAdekFlowCommandParamSubmitConfirm().click();
        //logoutProcess();

    }

    public void ApplicationProcessStatusNewProcess() throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 30);
        getSearchBox().click();
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.waitVisibility(getApplicationSchoolName(), 30);
        getApplicationSchoolName().click();
        ActionsHelper.waitVisibility(getApplicationAssignButton(), 20);
        getApplicationAssignButton().click();
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
        getAdekFlowCommandParamSubmitConfirm().click();
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
        getAdekFlowCommandParamSubmitConfirm().click();
    }

    public void ApplicationProcessStatusStartReview() throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 30);
        getSearchBox().click();
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.waitVisibility(getApplicationSchoolName(), 30);
        getApplicationSchoolName().click();
        ActionsHelper.retryClick(getSendToTechApproval(), 30);
        getSendToTechApproval().click();
        ActionsHelper.waitVisibility(getYesButton(), 20);
        getYesButton().click();
        ActionsHelper.waitVisibility(getOkButton(), 20);
        getOkButton().click();
    }

    public void ApplicationProcessStatusTechReviewAccept() throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 30);
        getSearchBox().click();
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.waitVisibility(getApplicationSchoolName(), 30);
        getApplicationSchoolName().click();
        ActionsHelper.retryClick(getReviewAcceptedButton(), 30);
        getReviewAcceptedButton().click();
        ActionsHelper.waitVisibility(getCommentTextArea(), 20);
        getCommentTextArea().sendKeys(new Faker().company().profession());
        ActionsHelper.retryClick(getCommandParamSubmit(), 30);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
        ActionsHelper.retryClick(getOkButton(), 30);

    }

    public void logoutProcess() {
        getLogoutDropDown().click();
        getLogoutDropDownClick().click();
    }

    //get program name
    // click on assign to process coordinator
    //Assign


}
