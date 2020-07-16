package com.qpros.pages.higher.education.admin;

import com.github.javafaker.Faker;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import com.qpros.pages.higher.education.Locators;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

   private final String programName = ReadWriteHelper.readCSVFile("ActiveProgram",1,1)[0][0];

    public void ApplicationProcessStatusNew() throws InterruptedException {
        ActionsHelper.retryClick(getSearchBox(), 100);
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.retryClick(getApplicationSchoolName(), 50);
        ActionsHelper.retryClick(getApplicationAssignButton(), 50);
        ActionsHelper.retryClick(getApplicationAssignTo(), 50);
        getApplicationAssignTo().sendKeys("Process Coordinator1");
        ActionsHelper.retryClick(getApplicationSelectAssignee(), 50);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmit(), 50);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(),50);

    }

    public void ApplicationProcessStatusNewProcess() throws InterruptedException {
        ActionsHelper.retryClick(getSearchBox(), 30);
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.retryClick(getApplicationSchoolName(), 30);
        ActionsHelper.retryClick(getApplicationAssignButton(), 20);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
    }

    public void ApplicationProcessStatusStartReview() throws InterruptedException {
        ActionsHelper.retryClick(getSearchBox(), 30);
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.retryClick(getApplicationSchoolName(), 50);
        ActionsHelper.retryClick(getSendToTechApproval(), 50);
        ActionsHelper.retryClick(getYesButton(), 50);
        ActionsHelper.retryClick(getOkButton(), 50);
    }

    public void ApplicationProcessStatusTechReviewAccept() throws InterruptedException {
        ActionsHelper.retryClick(getSearchBox(), 50);
        getSearchBox().sendKeys(programName + Keys.ENTER);
        ActionsHelper.retryClick(getApplicationSchoolName(), 50);
        ActionsHelper.retryClick(getReviewAcceptedButton(), 30);
          ActionsHelper.retryClick(getCommentTextArea(), 50);
        getCommentTextArea().sendKeys(new Faker().company().profession());
        ActionsHelper.retryClick(getCommandParamSubmit(), 30);
        ActionsHelper.retryClick(getAdekFlowCommandParamSubmitConfirm(), 30);
        ActionsHelper.retryClick(getOkButton(), 30);

    }

}
