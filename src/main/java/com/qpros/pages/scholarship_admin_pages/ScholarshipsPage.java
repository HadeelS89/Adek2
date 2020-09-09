package com.qpros.pages.scholarship_admin_pages;

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
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

@Getter
public class ScholarshipsPage extends Base {

    ReadFromExcel1 excelFile = new ReadFromExcel1("src/main/resources/DataProvider/Scholarships.xlsx");

    public ScholarshipsPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);

    }

    String Indecator = ReadWriteHelper.readFromExcel
            ("Scholarships", "Transcript", "Indecator");
    int RowNumber = excelFile.GetRowCount("Enrollment");

    String termValue = "";
    public static String title = "Automation subject" + System.currentTimeMillis() % 1000;

    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> scholarshipsTab;
    @FindBy(id = "btnApply")
    private WebElement applyFilterBtn;
    @FindBy(xpath = "//label[@class='filter-container-label' and contains(text(), 'Programs')]")
    private WebElement programsLabel;
    @FindBy(xpath = "//span[starts-with(@class,'select2-selection')]")
    private List<WebElement> programsList1;
    @FindBy(css = "li[class='select2-results__option']")
    private List<WebElement> programsIndex;
    @FindBy(css = ".font-weight-bold > .col-md-auto:nth-child(1)")
    private WebElement lblFirstResultCode;
    @FindBy(css = "div[class='col-md-auto']")
    private List<WebElement> resultsCodes;
    @FindBy(id = "home-tab")
    private List<WebElement> applicationTabs;
    @FindBy(id = "btnClear")
    private WebElement clearFiltersButton;
    @FindBy(id = "timeline")
    private WebElement timeLine;
    @FindBy(css = "input[value='Add Pay Element']")
    private List<WebElement> addPayElementBtn;
    @FindBy(css = ".sorting_disabled > condition-scholarship-recruter-afterassignadviser-permission > .btn")
    private WebElement addPayElementBtnn;
    @FindBy(id = "EffectiveDate")
    private WebElement effectiveDate;
    @FindBy(id = "select2-ErpPayrollElementId-container")
    private WebElement payrollElement;
    @FindBy(id = "Amount")
    private WebElement amount;
    @FindBy(id = "btnSubmitPayrole")
    private WebElement submitBtn;
    @FindBy(xpath = "//p[contains(.,'Success')]")
    private WebElement success;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement btnOK;
    @FindBy(css = "input[value='Add']")
    private List<WebElement> addBankDetailsBtn;
    @FindBy(css = ".dtr-title .btn")
    private WebElement addBankDetailsBtnn;
    @FindBy(css = "td[class='sorting_1']")
    private List<WebElement> firstBankRecord;
    @FindBy(xpath = "//th[contains(.,'Bank Branch')]")
    private WebElement recordHeader;
    @FindBy(id = "Country")
    private WebElement countryDDL;
    @FindBy(id = "BankId")
    private WebElement bankName;
    @FindBy(id = "BeneficiaryAddressLine1")
    private WebElement addressLine1;
    @FindBy(id = "BeneficiaryAddressLine2")
    private WebElement addressLine2;
    @FindBy(id = "btnSubmitBankBranches")
    private WebElement submitBankDetailsBtn;
    @FindBy(id = "ErpBankBranchId")
    private WebElement bankBranchName;
    @FindBy(id = "IBAN")
    private WebElement IABN;
    @FindBy(xpath = "//button[contains(.,'Yes')]")
    private WebElement yesButton;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement programNameInput;
    @FindBy(id = "btnApply")
    private WebElement btnApply;
    @FindBy(css = "input[class='select2-search__field']")
    private List<WebElement> payElementNameInput;
    @FindBy(xpath = "//p[starts-with(@class,'lead')]")
    private List<WebElement> sucessLabel;
    @FindBy(xpath = "//*[@id='scholarEnrolmentTable']/tbody/tr")
    private List<WebElement> enrollmentList;
    @FindBy(css = ".btn-primary")
    private WebElement addEnrollmentBtn;
    @FindBy(css = "#TermId")
    private WebElement termField;
    @FindBy(id = "PlannedCreditHours")
    private WebElement plannedCreditField;
    @FindBy(id = "OnlineCreditHours")
    private WebElement onlineCreditField;
    @FindBy(css = ".adek-upload-div")
    private WebElement studyPlanField;
    @FindBy(css = ".adek-upload-popup-btn")
    private WebElement uploadBtn;
    @FindBy(css = "input[type='file']")
    private List<WebElement> uploadPdf;
    @FindBy(id = "btnSubmitBankBranches")
    private WebElement submitEnrollBtn;
    @FindBy(css = ".confirm")
    private WebElement yesBtn;
    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addTransBtn;
    @FindBy(id = "selectERPpayrollprocessingType")
    private WebElement termTypeFiled;
    @FindBy(id = "termId")
    private WebElement termIdField2;
    @FindBy(css = "#selectERPpayrollprocessingType > option:nth-child(2)")
    private WebElement termTypeField;
    @FindBy(css = "#GpaTypeId")
    private WebElement gpaFiled;
    @FindBy(css = "#SemesterGpa")
    private WebElement semesterGPAField;
    @FindBy(css = "#semesterCreditHours")
    private WebElement semesterCDTHourField;
    @FindBy(css = "#inputYearCreditHours")
    private WebElement yearCDTHour;
    @FindBy(css = "#yearGpa")
    private WebElement yearGPAField;
    @FindBy(css = "#TranscriptDetails_CumulativeGpa")
    private WebElement cumulativeGPA;
    @FindBy(css = "#TranscriptDetails_CumulativeCreditHours")
    private WebElement cumulativeCreditHours;
    @FindBy(css = "#TranscriptDetails_TransferCreditHours")
    private WebElement transferCreditHours;
    @FindBy(css = "#TranscriptDetails_OnlineCreditHours")
    private WebElement onlineCDTHrsField;
    @FindBy(css = ".adek-upload-div")
    private WebElement uploadField;
    @FindBy(id = "btnSubmitSemisterTranscripts")
    private WebElement submitTransBtn;
    @FindBy(css = "#GetCalculatedPoint")
    private WebElement calculatePointBtn;
    @FindBy(id = "checkboxSkipCreditHours")
    private WebElement skipCdtHours;
    @FindBy(id = "labelQualityPoints")
    private WebElement qualityPointField;
    @FindBy(id = "labelyearQualityPoints")
    private WebElement yearQualityPointField;
    @FindBy(id = "btnGenerateLetter")
    private WebElement generateLettersBtn;
    @FindBy(id = "subject")
    private WebElement subject;
    @FindBy(id = "btnSendLetter")
    private WebElement sendLetterBtn;
    @FindBy(xpath = "//tbody/tr/td[6]")
    private WebElement indecatorArea;
    @FindBy(css = ".note-editable")
    private WebElement letterTemplateField;
    @FindBy(css = ".row:nth-child(4) > .col-md-auto:nth-child(1)")
    private WebElement emailContent;

    @FindBy(xpath = "//a[starts-with(@class, 'nav-link')]")
    private List<WebElement> educationalSubTab;

    @FindBy(xpath = "//*[@id=btnGenerateLetter]")
    private List<WebElement> testBtn;

    public void clearFilters() {
        ActionsHelper.waitVisibility(getClearFiltersButton(), 90);
        getClearFiltersButton().click();
    }

    public void findProgram(String programName) throws InterruptedException {


        ActionsHelper.waitForListExistance(getScholarshipsTab(), 100);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");

        ActionsHelper.waitForExistance(getProgramsLabel(), 100);
        sleep(3000);
        ActionsHelper.waitForListExistance(getProgramsList1(), 100);
        getProgramsList1().get(0).click();
        getProgramNameInput().sendKeys(programName);
        getProgramNameInput().sendKeys(Keys.ENTER);
        ActionsHelper.waitForExistance(getBtnApply(), 100);
        getBtnApply().click();
    }

    public void addPayElement() throws InterruptedException {

        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getTimeLine(), 60);
        ActionsHelper.waitForListExistance(getApplicationTabs(), 60);
        System.out.println("check 1 " + getApplicationTabs().size());
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Financials");
        Thread.sleep(2000);
        ActionsHelper.selectElementFromList(getEducationalSubTab(),
                "Pay Elements");
        Thread.sleep(2000);

        ActionsHelper.waitForListExistance(getAddPayElementBtn(), 60);
        System.out.println("text2 " + getAddPayElementBtnn().getTagName());
        driver.getPageSource();
        ActionsHelper.click(getAddPayElementBtnn());
        ActionsHelper.waitForExistance(getEffectiveDate(), 60);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(2, 0, 1));//error when add days =10
        getPayrollElement().click();
        getPayElementNameInput().get(0).sendKeys(ReadWriteHelper.readFromExcel(
                "programData", "PayElement", "PayElementNameInput") + Keys.ENTER);
        getAmount().sendKeys(ReadWriteHelper.readFromExcel(
                "programData", "PayElement", "Amount"));
        ActionsHelper.waitForExistance(getSubmitBtn(), 30);
        getSubmitBtn().click();
        ActionsHelper.waitForListExistance(getSucessLabel(), 60);
        //
        // Thread.sleep( 1000 );
    }


    //this method for find program is scholar ship page
    public void findProgram1(String programName) throws Exception {
        ActionsHelper.waitForListExistance(getScholarshipsTab(), 50);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");
        System.out.println("program Name:" + programName);
        ActionsHelper.waitForListExistance(getProgramsList1(), 50);
        System.out.println("List size:" + getProgramsList1().size());
        sleep(3000);
        getProgramsList1().get(0).click();
        ActionsHelper.waitForListExistance(getProgramsIndex(), 50);
        sleep(3000);
        System.out.println("List: " + getProgramsIndex().size());
        //System.out.println("program list size:" + getProgramsIndex().size());
        for (int i = 0; i < getProgramsIndex().size(); i++) {
            if (getProgramsIndex().get(i).getText().equalsIgnoreCase(programName)) {
                getProgramsIndex().get(i).click();
                System.out.println("program Name1:" + programName);
            }
            sleep(3000);
            ActionsHelper.waitForExistance(getApplyFilterBtn(), 30);
            // getApplyFilterBtn().click();
        }


    }

    public void addBankDetails() throws InterruptedException {

        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getTimeLine());
        ActionsHelper.waitForListExistance(getApplicationTabs(), 100);
        System.out.println("check 1 " + getApplicationTabs().size());
        System.out.println("BankDetails  " + getApplicationTabs().get(4).getText());

        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Financials");
        Thread.sleep(2000);
        ActionsHelper.selectElementFromList(getEducationalSubTab(),
                "Bank Details");

        Thread.sleep(2000);
        ActionsHelper.waitForExistance(getRecordHeader(), 100);
        if (getAddBankDetailsBtn().get(0).isDisplayed()) {
            ActionsHelper.waitForListExistance(getAddBankDetailsBtn(), 100);
            getAddBankDetailsBtn().get(0).click();

        } else {
            ActionsHelper.waitForListExistance(getFirstBankRecord(), 100);
            System.out.println("record size  " + getFirstBankRecord().size());
            getFirstBankRecord().get(0).click();
            System.out.println("button size  " + getFirstBankRecord().size());
            ActionsHelper.retryClick(getAddBankDetailsBtnn(), 30);
        }
        ActionsHelper.waitForExistance(getEffectiveDate(), 100);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(1, 0, 0));
        getCountryDDL().sendKeys(ReadWriteHelper.readFromExcel(
                "programData", "BankDetails", "Country"));
        ActionsHelper.waitForExistance(getBankName(), 50);
        System.out.println(ReadWriteHelper.readFromExcel("programData", "BankDetails", "Country"));
        getBankName().click();
        getBankName().sendKeys(ReadWriteHelper.readFromExcel
                ("programData", "BankDetails", "BankName") + Keys.ENTER);
        getBankName().click();
        ActionsHelper.waitForExistance(getBankBranchName(), 50);
        getBankBranchName().click();
        getBankBranchName().sendKeys(ReadWriteHelper.readFromExcel
                ("programData", "BankDetails", "BranchName") + Keys.ENTER);
        getAddressLine1().sendKeys(ReadWriteHelper.readFromExcel
                ("programData", "BankDetails", "AddressLine1"));
        getAddressLine2().sendKeys(ReadWriteHelper.readFromExcel
                ("programData", "BankDetails", "AddressLine2"));
        getIABN().sendKeys(ReadWriteHelper.readFromExcel
                ("programData", "BankDetails", "IABN"));
        getSubmitBankDetailsBtn().click();
        ActionsHelper.waitForExistance(getYesButton(), 100);
        getYesButton().click();
        ActionsHelper.waitForExistance(getSuccess(), 100);
    }

    public void selectAdvisor(String advisorName, String programName) throws InterruptedException {


        ActionsHelper.waitForListExistance(getScholarshipsTab(), 100);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");
        ActionsHelper.waitForExistance(getBtnApply(), 40);
        ActionsHelper.waitForExistance(getProgramsLabel(), 100);
        sleep(3000);
        ActionsHelper.waitForListExistance(getProgramsList1(), 100);
        ActionsHelper.waitForExistance(getProgramsList1().get(5), 50);
        System.out.println("size" + getProgramsList1().size());
        getProgramsList1().get(0).click();
        getProgramNameInput().sendKeys(programName);
        getProgramNameInput().sendKeys(Keys.ENTER);
        getProgramsList1().get(5).click();
        getProgramNameInput().sendKeys(advisorName);
        getProgramNameInput().sendKeys(Keys.ENTER);
        ActionsHelper.waitForExistance(getBtnApply(), 100);
        getBtnApply().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getTimeLine());
        ActionsHelper.waitForListExistance(getApplicationTabs(), 60);

    }

    public void addEnrollment() throws InterruptedException {
        //get enrollment tab

        ActionsHelper.waitForListExistance(getApplicationTabs(), 50);
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Educational");
        Thread.sleep(2000);
        ActionsHelper.selectElementFromList(getEducationalSubTab(),
                "Enrolments");

        termValue = finalCompare("scholarEnrolmentTable", 0);
        ActionsHelper.waitForExistance(getAddEnrollmentBtn(), 40);
        getAddEnrollmentBtn().click();
        ActionsHelper.waitForExistance(getTermField(), 20);
        //getTermField().click();
        getTermField().sendKeys(termValue + Keys.ENTER);
        getOnlineCreditField().sendKeys("2");
        getPlannedCreditField().sendKeys("3");
        getStudyPlanField().click();
        ActionsHelper.waitForListExistance(getUploadPdf(), 20);
        getUploadPdf().get(0).sendKeys(ActionsHelper.getImagePath("Amending.pdf"));
        getUploadBtn().click();
        ActionsHelper.waitForExistance(getSubmitEnrollBtn(), 30);
        getSubmitEnrollBtn().click();
        ActionsHelper.waitForExistance(getYesBtn(), 30);
        getYesBtn().click();
        ActionsHelper.waitForListExistance(getSucessLabel(), 30);

    }


    public void addTranscript() throws Exception {
        //get transcript tab
        ActionsHelper.waitForListExistance(getApplicationTabs(), 50);
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Educational");
        Thread.sleep(2000);
        ActionsHelper.selectElementFromList(getEducationalSubTab(),
                "Semester Transcripts");

        termValue = finalCompare("dtTranscript", 0);
        ActionsHelper.waitForExistance(getAddTransBtn(), 60);
        ActionsHelper.scrollTo(getAddTransBtn());
        getAddTransBtn().click();
        Thread.sleep(3000);
        System.out.println("size h = " + getTermIdField2().getText());
        getTermIdField2().sendKeys(termValue);
        getTermTypeFiled().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "TermType") + Keys.ENTER);
        getGpaFiled().click();
        getGpaFiled().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "GPAType") + Keys.ENTER);
        getSemesterGPAField().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "SemesterGPA"));
        getSemesterCDTHourField().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "SemesterCreditHours"));
        getYearCDTHour().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "YearCreditHours"));
        getYearGPAField().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "YearGpa"));
        getCumulativeGPA().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "CumulativeGpa"));
        getCumulativeCreditHours().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "CumulativeCreditHours"));
        getTransferCreditHours().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "TransferredCreditHours"));
        getOnlineCDTHrsField().sendKeys(ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "OnlineCreditHours"));
        ActionsHelper.waitForExistance(getUploadField(), 20);
        getUploadField().click();
        ActionsHelper.waitForListExistance(getUploadPdf(), 30);
        getUploadPdf().get(0).sendKeys(ActionsHelper.getImagePath("Amending.pdf"));
        getUploadBtn().click();
        ActionsHelper.waitForExistance(getCalculatePointBtn(), 40);
        getCalculatePointBtn().click();
        ActionsHelper.waitForExistance(getQualityPointField(), 50);
        String quality_points = ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "QualityPoints");
        Assert.assertTrue(quality_points.equals(getQualityPointField().getText()));
        String yearQuality_points = ReadWriteHelper.readFromExcel
                ("Scholarships", "Transcript", "YearQualityPoints");
        //Assert.assertTrue(yearQuality_points.equals(getYearQualityPointField().getText()));
        ActionsHelper.waitForExistance(getSubmitTransBtn(), 50);
        ActionsHelper.retryClick(getSubmitTransBtn(), 50);
        ActionsHelper.waitForExistance(getSuccess(), 60);
    }

    public void addBankDetails1() throws InterruptedException {

        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getTimeLine(), 100);
        ActionsHelper.waitForListExistance(getApplicationTabs(), 100);
        System.out.println("check 1 " + getApplicationTabs().size());
        System.out.println("BankDetails  " + getApplicationTabs().get(4).getText());
        getApplicationTabs().get(12).click();
        ActionsHelper.waitForExistance(getRecordHeader(), 100);
        if (getAddBankDetailsBtn().get(0).isDisplayed()) {
            ActionsHelper.waitForListExistance(getAddBankDetailsBtn(), 100);
            getAddBankDetailsBtn().get(0).click();

        } else {
            ActionsHelper.waitForListExistance(getFirstBankRecord(), 100);
            System.out.println("record size  " + getFirstBankRecord().size());
            getFirstBankRecord().get(0).click();
            System.out.println("button size  " + getFirstBankRecord().size());
            ActionsHelper.retryClick(getAddBankDetailsBtnn(), 30);
        }
        ActionsHelper.waitForExistance(getEffectiveDate(), 100);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(1, 0, 0));
        getCountryDDL().sendKeys("United Arab Emirates");
        ActionsHelper.waitForExistance(getBankName(), 50);
        getBankName().click();
        getBankName().sendKeys("ABU DHABI ISLAMIC BANK" + Keys.ENTER);
        ActionsHelper.waitForExistance(getBankBranchName(), 50);
        getBankBranchName().click();
        getBankBranchName().sendKeys("AL AIN SANAIYA" + Keys.ENTER);
        getAddressLine1().sendKeys("ABU DHABI");
        getAddressLine2().sendKeys("ABU DHABI Area 2");
        getIABN().sendKeys("AE320500000000028353371");
        getSubmitBankDetailsBtn().click();
        ActionsHelper.waitForExistance(getYesButton(), 100);
        getYesButton().click();
        ActionsHelper.waitForExistance(getSuccess(), 100);
    }


    public String finalCompare(String tableID, int ColumnID) throws InterruptedException {


        HashMap<Integer, String> excelMap
                = new HashMap<>();

        for (int j = 1; j < getRowNumber(); j++) {
            String termTitle = ReadWriteHelper.readFromExcel(
                    "Scholarships", "Enrollment", "Terms", j);
            excelMap.put(j, termTitle);

            System.out.println("termTitle from excel: " + termTitle);
        }

        String finalCompare = "";
        String record = "";
        String newRecord = "";
        int x = 0;

        HashMap table = ActionsHelper.getWebColumnIndex(tableID, ColumnID);
        for (int i = 1; i <= excelMap.size(); i++) {
            x = 0;
            record = excelMap.get(i);
            //dtTranscript
            for (int j = 2; j <= table.size(); j++) {
                newRecord = (String) table.get(j);
                if (record.equalsIgnoreCase(newRecord)) {
                    x += 1;
                    break;
                }

            }

            if (x == 0) {
                finalCompare = record;
            }

            if (!finalCompare.equals("")) {
                break;
            }
        }

        System.out.println("finalCompare " + finalCompare);
        return finalCompare;
    }

    public void generateLetter() throws InterruptedException {
        ActionsHelper.waitForListExistance(getApplicationTabs(), 50);
        ActionsHelper.selectElementFromList(getApplicationTabs(),
                "Educational");
        //Thread.sleep(2000);
        ActionsHelper.selectElementFromList(getEducationalSubTab(),
                "Semester Transcripts");
        ActionsHelper.waitForExistance(getGenerateLettersBtn());
       getGenerateLettersBtn().click();

        ActionsHelper.waitForExistance(getSubject(), 30);
        getSubject().sendKeys(title);
        getLetterTemplateField().clear();
        getLetterTemplateField().sendKeys(" Tags Needed\tKeys\n" +
                "        Applicant Id\t{{Applicant Id}}\n" +
                "        Application Number\n" +
                "        {{Application Number}}\n" +
                "        Student Name EN\t{{Student Name EN}}\n" +
                "        Student Name AR\t{{Student Name AR}}\n" +
                "        First Name EN\t{{First Name EN}}\n" +
                "        First Name AR\t{{First Name AR}}\n" +
                "        Middle Name EN\t{{Middle Name EN}}\n" +
                "        Middle Name AR\t{{Middle Name AR}}\n" +
                "        Last Name EN\t{{Last Name EN}}\n" +
                "        Last Name AR\t{{Last Name AR}}\n" +
                "        Program Name EN\t{{Program Name EN}}\n" +
                "        Program Name AR\t{{Program Name AR}}\n" +
                "        Current Date\t{{Current Date}}\n" +
                "        Academic Year\t{{Academic Year}}\n" +
                "        Academic Term EN\t{{Academic Term EN}}\n" +
                "        Academic Term AR\t{{Academic Term AR}}\n" +
                "        Semester GPA\t{{Semester GPA}}\n" +
                "        Semester Credit Hour\t{{Semester Credit Hour}}\n" +
                "        Cumulative GPA\t{{Cumulative GPA}}\n" +
                "        Cumulative Credit Hour\t{{Cumulative Credit Hour}}\n" +
                "        Year GPA\t{{Year GPA}}\n" +
                "        Year Credit Hour\t{{Year Credit Hour}}\n" +
                "        Indicator\t{{Indicator}}\n" +
                "        University En\t{{University En}}\n" +
                "        University Ar\t{{University Ar}}\n" +
                "        Major En\t{{Major En}}\n" +
                "        Major Ar\t{{Major Ar}}\n" +
                "        Scholarship Activation Date\t{{Scholarship Activation Date}}\n" +
                "        Academic Level En\t{{Academic Level En}}\n" +
                "        Academic Level Ar\t{{Academic Level Ar}}\n" +
                "        Academic Program En\t{{Academic Program En}}\n" +
                "        Academic Program Ar\t{{Academic Program Ar}}\n" +
                "        Expected Graduation Date\t{{Expected Graduation Date}}");
        getSendLetterBtn().click();
        ActionsHelper.waitForExistance(getBtnOK(), 30);
        getBtnOK().click();
        ActionsHelper.waitForExistance(getSuccess(), 40);
        getEmailContent().getText();

    }

    public void checkLetterEmail() {


    }


    public static void main(String[] args) {
        String x = "abcd@123.com";
        System.out.println(x.length());
        String email = "emailtest@123.com";

        System.out.println(email.substring(0, email.indexOf("@")));
    }

}

