package com.qpros.pages.higher.education.client;

import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

@Getter
public class HEProgram {
    public HEProgram(WebDriver driver) {
        PageFactory.initElements( driver, this );
    }
    @FindBy(linkText = "New applications")
    private WebElement expandNewApplications;
    @FindBy(linkText = "Programs")
    private WebElement programSection;
    @FindBy(xpath = "//li[2]/a")
    private WebElement applicationsSection;
    @FindBy(css = ".col:nth-child(1) adek-input .form-control")
    private WebElement programNameEnglish;
    @FindBy(css = ".col:nth-child(2) adek-input .form-control")
    private WebElement programNameArabic;
    @FindBy(css = ".col:nth-child(1) adek-text-area .form-control")
    private WebElement descriptionEnglish;
    @FindBy(css = ".col:nth-child(2) adek-text-area .form-control")
    private WebElement descriptionArabic;
    @FindBy(xpath = "//ng-dropdown-panel/div/div[2]/div")
    private WebElement firstOption;
    @FindBy(css = ".ng-arrow-wrapper")
    private WebElement facultyArrow;
    @FindBy(css = ".ng-arrow-wrapper:nth-of-type(1)")
    private WebElement providerContactArrow;
    @FindBy(css = ".ng-arrow-wrapper:nth-of-type(1)")
    private WebElement degreeLevelArrow;
    @FindBy(css = ".btn:nth-child(2)")
    private WebElement nextButton;

    @FindBy(css = ".adek-upload-div")
    private WebElement uploadDiv;
    @FindBy(css = "input[type='file']")
    //@FindBy(id = "adek-file-selector")
    private List<WebElement> uploadFilePath;
    @FindBy(css = ".row > .form-control")
    private WebElement uploadDescription;
    @FindBy(css = ".adek-upload-popup-btn")
    private WebElement uploadButton;
    @FindBy(css = ".ml-1")
    private WebElement submitButton;
    @FindBy(css = ".swal2-confirm")
    private WebElement confirmButton;
    @FindBy(css = ".h5")
    private WebElement feedbackText;
    @FindBy(css = ".ng-star-inserted:nth-child(1) > td:nth-child(2)")
    private WebElement currentProgram; //GetText
    @FindBy(css = ".ng-star-inserted > adek-label .mb-2")
    private WebElement expiryDate;
    @FindBy(css = ".fa-remove")
    private WebElement closeFeedback;



    public void applyForProgram() throws Exception {
        ActionsHelper.waitForExistance(getExpandNewApplications(), 60);
        ActionsHelper.waitVisibility(getExpandNewApplications(), 60);
        ActionsHelper.waitToBeClickable(getExpandNewApplications(),60);
        ActionsHelper.waitForExistance(getExpiryDate(),60);
        ActionsHelper.retryClick(getExpandNewApplications(), 30);
        getProgramSection().click();
        //Reached program form input area

        ActionsHelper.waitVisibility(getProgramNameEnglish(), 60);
        getProgramNameEnglish().sendKeys("Testapp d" + System.currentTimeMillis() % 100000);
        getProgramNameArabic().sendKeys("عربياسم "+ System.currentTimeMillis() % 100000);
        getDescriptionEnglish().sendKeys(String.format("Teseawt ", System.currentTimeMillis() % 100000));
        getDescriptionArabic().sendKeys(String.format("عربياسشيسم ", System.currentTimeMillis() % 100000));
        getFacultyArrow().click();
        getFirstOption().click();
        getProviderContactArrow().click();
        getFirstOption().click();
        getDegreeLevelArrow().click();
        getFirstOption().click();
        Assert.assertNotNull(getNextButton());
        getNextButton().click();
        //Finished first page of program application data

        ActionsHelper.waitToBeClickable(getUploadDiv(),60);
        ActionsHelper.retryClick(getUploadDiv(), 30);
        ActionsHelper.waitForListExistance(getUploadFilePath(),60);
        System.out.println("Upload size: "+getUploadFilePath().size());
        getUploadFilePath().get(0).sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\images\\image.PNG");
        getUploadDescription().sendKeys("MyDescription");
        getUploadButton().click();
        //Upload success

        ActionsHelper.waitVisibility(getSubmitButton(), 60);
        ActionsHelper.retryClick(getSubmitButton(),10);
        ActionsHelper.waitVisibility(getConfirmButton(), 60);
        ActionsHelper.retryClick(getConfirmButton(),10);
        System.out.println("Trying to click application section");
        ActionsHelper.retryClick(getCloseFeedback(),10);
        //Finished program application and closed feedback popup

        ActionsHelper.retryClick(getApplicationsSection(),10);
        System.out.println("Clicked application section successfully");
        ActionsHelper.waitVisibility(getCurrentProgram(), 60);
        System.out.println("Found damn program area");
        ReadWriteHelper.writeCSVFirstCell(getCurrentProgram().getText());
        //Read last created program ID and write it to ActiveProgram.csv
    }
}
