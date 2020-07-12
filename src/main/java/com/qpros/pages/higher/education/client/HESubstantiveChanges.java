package com.qpros.pages.higher.education.client;

import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

@Getter
public class HESubstantiveChanges {
    public HESubstantiveChanges(WebDriver driver) {
        PageFactory.initElements( driver, this );
    }
    @FindBy(linkText = "New applications")
    private WebElement expandNewApplications;
    @FindBy(linkText = "Substantive changes")
    private WebElement substantiveChanges;
    @FindBy(xpath = "//li[2]/a")
    private WebElement applicationsSection;


    @FindBy(css = ".ng-star-inserted:nth-child(1) > .ant-checkbox-wrapper > span:nth-child(2)")
    //             .ng-star-inserted:nth-child(1) .ant-checkbox-inner
    private WebElement checkBox1; //Test123
    @FindBy(css = ".ng-star-inserted:nth-child(2) > .ant-checkbox-wrapper > span:nth-child(2)")
    //             .ng-star-inserted:nth-child(2) > .ant-checkbox-wrapper .ant-checkbox-inner
    private WebElement checkBox2; //فثسف123
    @FindBy(css = ".ng-star-inserted:nth-child(3) > .ant-checkbox-wrapper > span:nth-child(2)")
    private WebElement checkBox3; //Test123
    @FindBy(css = ".ng-star-inserted:nth-child(4) > .ant-checkbox-wrapper > span:nth-child(2)")
    private WebElement checkBox4; //فثسف123
    @FindBy(css = ".ng-star-inserted:nth-child(5) > .ant-checkbox-wrapper > span:nth-child(2)")
    private WebElement checkBox5; //Test123


    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(1) > .ng-star-inserted:nth-child(2) .col-12:nth-child(1) .form-control")
    private WebElement newProviderNameEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(1) > .ng-star-inserted:nth-child(2) .col-12:nth-child(2) .form-control")
    private WebElement newProviderNameArabic;
    @FindBy(css = ".ng-dirty .col-12:nth-child(1) .form-control:nth-child(2)")
    private WebElement newNomenclatureEnglish;
    @FindBy(css = ".ng-dirty .col-12:nth-child(2) .form-control:nth-child(2)")
    private WebElement newNomenclatureArabic;

    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(2) > .ng-star-inserted:nth-child(2) .col-12:nth-child(1) .form-control")
    private WebElement oldExistingMissionEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(2) > .ng-star-inserted:nth-child(2) .col-12:nth-child(2) .form-control")
    private WebElement oldExistingMissionArabic;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(2) > .ng-star-inserted:nth-child(3) .col-12:nth-child(1) .form-control")
    private WebElement newMissionEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(2) > .ng-star-inserted:nth-child(3) .col-12:nth-child(2) .form-control")
    private WebElement newMissionArabic;

    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(3) > .ng-star-inserted:nth-child(2) .col-12:nth-child(1) .form-control")
    private WebElement existingProviderEnglishOld;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(3) > .ng-star-inserted:nth-child(2) .col-12:nth-child(2) .form-control")
    private WebElement existingProviderArabicOld;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(3) > .ng-star-inserted:nth-child(3) .col-12:nth-child(1) .form-control")
    private WebElement newProviderPurposeEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(3) > .ng-star-inserted:nth-child(3) .col-12:nth-child(2) .form-control")
    private WebElement newProviderPurposeArabic;

    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(4) .col-12:nth-child(1) .form-control")
    private WebElement newLocationEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(4) .col-12:nth-child(2) .form-control")
    private WebElement newLocationArabic;

    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(5) > .ng-star-inserted:nth-child(2) .col-12:nth-child(1) .form-control")
    private WebElement existingPartnershipEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(5) > .ng-star-inserted:nth-child(2) .col-12:nth-child(2) .form-control")
    private WebElement existingPartnershipArabic;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(5) > .ng-star-inserted:nth-child(3) .col-12:nth-child(1) .form-control")
    private WebElement newPartnershipEnglish;
    @FindBy(css = ".ng-dirty > .ng-star-inserted:nth-child(5) > .ng-star-inserted:nth-child(3) .col-12:nth-child(2) .form-control")
    private WebElement newPartnershipArabic;




    @FindBy(css = ".btn-primary")
    private WebElement nextButton; //Test123

    @FindBy(css = ".adek-upload-div")
    private WebElement uploadDiv; //Test123
    @FindBy(css = "input[type='file']")
    private List<WebElement> uploadFilePath; //Add filepath to this by sendkeys
    @FindBy(css = ".row > .form-control")
    private WebElement uploadDescription; //Test123
    @FindBy(css = ".adek-upload-popup-btn")

    private WebElement uploadButton; //Test123
    @FindBy(css = ".ml-1")
    private WebElement submitButton; //Test123
    @FindBy(css = ".swal2-confirm")
    private WebElement confirmButton; //Test123
    @FindBy(css = ".h5")
    private WebElement feedbackText; //Should contain: SHARE YOUR FEEDBACK
    @FindBy(css = ".ng-star-inserted:nth-child(1) > td:nth-child(2)")
    private WebElement currentProgram; //GetText
    @FindBy(css = ".ng-star-inserted > adek-label .mb-2")
    private WebElement expiryDate; //GetText
    @FindBy(css = ".fa-remove")
    private WebElement closeFeedback; //GetText

    public void applySubstantiveChanges() throws Exception {
        ActionsHelper.waitForExistance(getExpandNewApplications(), 60);
        ActionsHelper.waitVisibility(getExpandNewApplications(), 60);
        ActionsHelper.waitToBeClickable(getExpandNewApplications(),60);
        ActionsHelper.waitForExistance(getExpiryDate(),60);
        ActionsHelper.retryClick(getExpandNewApplications(), 30);
        //ActionsHelper.waitVisibility(getProgramSection(), 60);
        getSubstantiveChanges().click();
        ActionsHelper.waitVisibility(getCheckBox5(), 60);
        ActionsHelper.retryClick(getCheckBox5(), 10);
        getCheckBox4().click();
        getCheckBox3().click();
        getCheckBox2().click();
        getCheckBox1().click();

        getNewProviderNameEnglish().sendKeys("ProviderNameEnglish " + System.currentTimeMillis() % 100000);
        getNewProviderNameArabic().sendKeys("ProviderNameArabic " + System.currentTimeMillis() % 100000);
        getNewNomenclatureEnglish().sendKeys("NomenclatureEnglish");
        getNewNomenclatureArabic().sendKeys("NomenclatureEnglish");

        getOldExistingMissionEnglish().sendKeys("oldMissionEnglish " + System.currentTimeMillis() % 100000);
        getOldExistingMissionArabic().sendKeys("oldMissionArabic " + System.currentTimeMillis() % 100000);
        getNewMissionEnglish().sendKeys("newMissionEnglish " + System.currentTimeMillis() % 100000);
        getNewMissionArabic().sendKeys("newMissionArabic " + System.currentTimeMillis() % 100000);

        getExistingProviderEnglishOld().sendKeys("oldExistingProviderEnglish");
        getExistingProviderArabicOld().sendKeys("oldExistingProviderArabic");
        getNewProviderPurposeEnglish().sendKeys("newProviderPurposeEnglish");
        getNewProviderPurposeArabic().sendKeys("newProviderPurposeArabic");

        getNewLocationEnglish().sendKeys("newLocationEnglish");
        getNewLocationArabic().sendKeys("newLocationArabic");

        getExistingPartnershipEnglish().sendKeys("oldPartnerEnglish " + System.currentTimeMillis() % 100000);
        getExistingPartnershipArabic().sendKeys("oldPartnerArabic " + System.currentTimeMillis() % 100000);
        getNewPartnershipEnglish().sendKeys("newPartnerEnglish " + System.currentTimeMillis() % 100000);
        getNewPartnershipArabic().sendKeys("newPartnerArabic " + System.currentTimeMillis() % 100000);

        ActionsHelper.retryClick(getNextButton(), 5);

        ActionsHelper.waitToBeClickable(getUploadDiv(),60);

        ActionsHelper.retryClick(getUploadDiv(), 30);
        ActionsHelper.waitForListExistance(getUploadFilePath(),60);
        System.out.println("Upload size: "+getUploadFilePath().size());
        getUploadFilePath().get(0).sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\images\\image.PNG");
        getUploadDescription().sendKeys("MyDescription");
        getUploadButton().click();
        ActionsHelper.waitVisibility(getSubmitButton(), 60);
        ActionsHelper.retryClick(getSubmitButton(),10);
        ActionsHelper.waitVisibility(getConfirmButton(), 60);
        ActionsHelper.retryClick(getConfirmButton(),10);
        System.out.println("Trying to click application section");
        ActionsHelper.retryClick(getCloseFeedback(),10);
        ActionsHelper.retryClick(getApplicationsSection(),10);
        System.out.println("Clicked application section successfully");
        ActionsHelper.waitVisibility(getCurrentProgram(), 60);
        System.out.println("Found damn program area");
        ReadWriteHelper.writeCSVFirstCell(getCurrentProgram().getText()); //Write this to a CSV file
    }
}
