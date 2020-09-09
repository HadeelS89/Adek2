package com.qpros.pages.sholarship_applicant_pages;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadFromExcel1;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Getter
public class ActiveScholarshipsPage extends Base {

    ReadFromExcel1 excelFile = new ReadFromExcel1("src/main/resources/DataProvider/Scholarships.xlsx");

    public void ScholarshipsPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

    int RowNumber = excelFile.GetRowCount("Enrollment");

    public static String termTitleLabel = "";
    static String termValue = "";

    public ActiveScholarshipsPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String termType = "";
    public String GPAType = "";

    @FindBy(xpath = "//span[starts-with(@class,'menu-title')]")
    private List<WebElement> activeScholarships;
    @FindBy(xpath = "//button[contains(.,'Add New Term')]")
    private WebElement addNewTerm;
    @FindBy(css = "div[class='card-body']")
    private List<WebElement> termDiv;
    @FindBy(css = "h5[class='card-title']")
    private List<WebElement> termTitle;
    @FindBy(css = "input")
    private WebElement termField;
    @FindBy(xpath = "//button[starts-with(@class,'btn btn-raised')]")
    private List<WebElement> fillEnrollmentBtn;
    @FindBy(xpath = "//span[starts-with(@class,'ng-value-label ng-star')]")
    private List<WebElement> termsListSelection;
    @FindBy(css = ".row:nth-child(3) .form-control")
    private WebElement creditHoursField;
    @FindBy(css = ".row:nth-child(4) .form-control")
    private WebElement onlineCreditHoursField;
    @FindBy(css = ".adek-upload-div")
    private WebElement studyPlanField;
    @FindBy(css = "input[type='file']")
    private List<WebElement> uploadLetter;
    @FindBy(xpath = "//button[contains(.,'Upload')]")
    private WebElement uploadBtn;
    @FindBy(xpath = "//button[contains(.,'Submit')]")
    private WebElement submitBtn;
    @FindBy(xpath = "//button[contains(.,'Confirm')]")
    private WebElement confirmBtn;
    @FindBy(xpath = "//div[@id='toast-container']/div/div[2]")
    private WebElement successMsg;
    @FindBy(xpath = "//button[contains(.,'Add Transcript')]")
    private WebElement addNewTranscript;
    @FindBy(xpath = "(//input[@type='text'])")
    private List<WebElement> transTermField;


    public void addNewEnrollment() throws InterruptedException {
        ActionsHelper.waitForListExistance(getActiveScholarships(), 100);

        ActionsHelper.selectElementFromList(getActiveScholarships(), "Active Scholarships");
        ActionsHelper.waitForListExistance(getActiveScholarships(), 100);
        ActionsHelper.selectElementFromList(getActiveScholarships(), "Enrollments");
        // ActionsHelper.waitForExistance(getAddNewTerm(),20);
        termValue = checkTerms();
        ActionsHelper.waitForExistance(getAddNewTerm(), 30);
        ActionsHelper.retryClick(getAddNewTerm(), 15);
        getTermField().sendKeys(termValue + Keys.ENTER);

        ActionsHelper.waitForListExistance(getFillEnrollmentBtn(), 30);
        getFillEnrollmentBtn().get(0).click();
        ActionsHelper.waitForExistance(getCreditHoursField(), 30);
        getCreditHoursField().sendKeys("3");
        getOnlineCreditHoursField().sendKeys("4");
        getStudyPlanField().click();
        ActionsHelper.waitForListExistance(getUploadLetter(), 30);

        getUploadLetter().get(0).sendKeys(ActionsHelper.getImagePath("Amending.pdf"));
        ActionsHelper.highlightElement(getUploadLetter().get(0));
        ActionsHelper.highlightElement(getUploadBtn());
        getUploadBtn().click();
        ActionsHelper.waitForExistance(getSubmitBtn(), 40);
        getSubmitBtn().click();
        ActionsHelper.waitForExistance(getConfirmBtn(), 50);
        getConfirmBtn().click();
        ActionsHelper.waitForExistance(getSuccessMsg(), 50);


    }


    public void checkTermsDiv() throws InterruptedException {
        ActionsHelper.waitForListExistance(getTermDiv(), 30);
        //ActionsHelper.selectElementFromList(getTermDiv(), "Programs");
        System.out.println("Program Size: " + getTermDiv().size());
        System.out.println("Title Size: " + getTermTitle().size());
        HashMap<String, Integer> divMap
                = new HashMap<>();
        HashMap<String, Integer> excelMap
                = new HashMap<>();
        //  map.forEach();
        for (int i = 0; i < getTermDiv().size(); i++) {


            divMap.put(getTermTitle().get(i).getText(), i);
            termTitleLabel = getTermTitle().get(i).getText();
            System.out.println("Program Title div: " + termTitleLabel);
        }
        for (int j = 1; j < getRowNumber(); j++) {
            String termTitle = ReadWriteHelper.readFromExcel(
                    "Scholarships", "Enrollment", "Terms", j);
            excelMap.put(termTitle, j);

            System.out.println("termTitle from excel: " + termTitle.toUpperCase().replace(" ", ""));
        }


        HashSet<String> union = new HashSet<>(divMap.keySet());
        union.addAll(excelMap.keySet());
        union.removeAll(divMap.keySet());

        List<String> termsList = new ArrayList<>(union);
        termsList.get(0);
        System.out.println("termTitle from compare: " + termsList.get(0));
        ActionsHelper.waitForExistance(getAddNewTerm(), 30);
        ActionsHelper.retryClick(getAddNewTerm(), 15);
        getTermField().sendKeys(termsList.get(0) + Keys.ENTER);

        ActionsHelper.waitForListExistance(getFillEnrollmentBtn(), 30);
        getFillEnrollmentBtn().get(0).click();
        ActionsHelper.waitForExistance(getCreditHoursField(), 30);
        getCreditHoursField().sendKeys("3");
        getOnlineCreditHoursField().sendKeys("4");
        getStudyPlanField().click();
        ActionsHelper.waitForListExistance(getUploadLetter(), 30);

        getUploadLetter().get(0).sendKeys(ActionsHelper.getImagePath("Amending.pdf"));
        getUploadBtn().click();
        ActionsHelper.waitForExistance(getSubmitBtn(), 40);
        getSubmitBtn().click();
        ActionsHelper.waitForExistance(getConfirmBtn(), 50);
        getConfirmBtn().click();
        ActionsHelper.waitForExistance(getSuccessMsg(), 50);
    }


    public void addNewTranscript() throws InterruptedException {

        ActionsHelper.waitForListExistance(getActiveScholarships(), 100);
        ActionsHelper.waitForListExistance(getActiveScholarships(), 100);
        ActionsHelper.selectElementFromList(getActiveScholarships(), "Active Scholarships");
        ActionsHelper.waitForListExistance(getActiveScholarships(), 100);
        ActionsHelper.selectElementFromList(getActiveScholarships(), "Upload Transcripts");
        ActionsHelper.waitForExistance(getAddNewTranscript(), 50);
        checkTerms();
        termValue = checkTerms();
        getAddNewTranscript().click();
        ActionsHelper.waitForListExistance(getTransTermField(), 30);
        getTransTermField().get(1).sendKeys(termValue + Keys.ENTER);
        termType = ReadWriteHelper.readFromExcel(
                "Scholarships", "Transcript", "TermType");
        getTransTermField().get(2).sendKeys(termType + Keys.ENTER);
        GPAType = termType = ReadWriteHelper.readFromExcel(
                "Scholarships", "Transcript", "GPAType");
        getTransTermField().get(3).sendKeys(GPAType + Keys.ENTER);

        if (GPAType.equalsIgnoreCase("Pass/Fail")) {
            getTransTermField().get(4).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "SemesterGPA") + Keys.ENTER);

        } else {

            getTransTermField().get(4).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "SemesterGPA"));
            getTransTermField().get(5).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "SemesterCreditHours"));
            getTransTermField().get(6).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "CumulativeCreditHours"));
            getTransTermField().get(7).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "CumulativeGPA"));
            getTransTermField().get(8).sendKeys(ReadWriteHelper.readFromExcel(
                    "Scholarships", "Transcript", "TransferredCreditHours"));

        }


        getStudyPlanField().click();
        getUploadLetter().get(0).sendKeys(ActionsHelper.getImagePath("Amending.pdf"));
        ActionsHelper.retryClick(getUploadBtn(), 20);
        ActionsHelper.waitForExistance(getSubmitBtn(), 30);
        getSubmitBtn().click();
        ActionsHelper.waitForExistance(getConfirmBtn(), 50);
        getConfirmBtn().click();
        ActionsHelper.waitForExistance(getSuccessMsg(), 50);
    }

    public String checkTerms() throws InterruptedException {
        ActionsHelper.waitForExistance(getAddNewTerm(), 50);
        //ActionsHelper.selectElementFromList(getTermDiv(), "Programs");
        System.out.println("Program Size: " + getTermDiv().size());
        System.out.println("Title Size: " + getTermTitle().size());
        HashMap<Integer, String> divMap
                = new HashMap<>();
        HashMap<Integer, String> excelMap
                = new HashMap<>();
        for (int i = 0; i < getTermDiv().size(); i++) {

            divMap.put(i, getTermTitle().get(i).getText());
            termTitleLabel = getTermTitle().get(i).getText().toUpperCase();
            System.out.println("Program Title div: " + termTitleLabel);
        }
        // to get results from excel :
        for (int j = 1; j < getRowNumber(); j++) {
            String termTitle = ReadWriteHelper.readFromExcel(
                    "Scholarships", "Enrollment", "Terms", j).toUpperCase();
            excelMap.put(j, termTitle);

            System.out.println("termTitle from excel: " + termTitle);
        }


        String finalCompare = "";
        String record = "";
        String newRecord = "";
        int x = 0;

        for (int i = 1; i <= excelMap.size(); i++) {
            x = 0;
            record = excelMap.get(i);
            for (int j = 0; j <= divMap.size(); j++) {
                newRecord = divMap.get(j);
                if (record.equalsIgnoreCase(newRecord)) {
                    x+=1;
                    break;
                }

            }

            if(x==0){
                finalCompare = record;
            }

            if (!finalCompare.equals("")) {
                break;
            }
        }


        return finalCompare;
    }


}