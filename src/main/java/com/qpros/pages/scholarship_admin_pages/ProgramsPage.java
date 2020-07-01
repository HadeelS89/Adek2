package com.qpros.pages.scholarship_admin_pages;

import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ProgramsPage {

    public static String randomName = "";
    public static String createdProgram = "";
   // public static String interviewProgram = "";
    WebElement createdProgramName = null;

    public ProgramsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> programsTab;
    @FindBy(css = "i[class='btn-addon-icon fe fe-plus-circle']")
    private List<WebElement> addProgramButton;
    @FindBy(id = "NameEnglish")
    private WebElement nameEnglishField;
    @FindBy(id = "NameArabic")
    private WebElement nameArabicField;
    @FindBy(id = "StartDate")
    private WebElement startDateField;
    @FindBy(id = "EndDate")
    private WebElement endDateField;
    @FindBy(id = "AcademicYear")
    private WebElement academicYearList;
    @FindBy(id = "DueApplicationDate")
    private WebElement dueApplicationDateField;
    @FindBy(id = "ProjectId")
    private WebElement ERBProjectIDField;
    @FindBy(id = "btnSubmit")
    private WebElement submitButton;
    @FindBy(id = "searchbox")
    private WebElement searchField;
    @FindBy(id = "btnGroupAddon2")
    private WebElement searchButton;
    @FindBy(css = "div[class='col-md-auto']")
    private List<WebElement> programNameLabel;
    @FindBy(css = "li[class='nav-item']")
    private List<WebElement> programTabs; // Select configurations using this locator
    //    @FindBy(xpath = "/html/body/div[5]/div[7]/div/button")
//    private WebElement okButton;
    @FindBy(className = "col-md-auto")
    private List<WebElement> programsDiv;
    @FindBy(id = "home-tab")
    private List<WebElement> programOptions;
    @FindBy(id = "divProgramViewMain")
    private WebElement mainInfoLabels;
    @FindBy(css = "h6[class='mb-0']")
    private List<WebElement> configurationsList;
    @FindBy(xpath = "//span[starts-with(@class,'select2-selection select2-')]")
    private List<WebElement> academicCareersField;
    @FindBy(css = "li[class='select2-results__option']")
    private List<WebElement> academicCareer;
    @FindBy(id = "FieldSelectionId1")
    private WebElement selectionCountField;
    @FindBy(id = "FieldRequiredId1")
    private WebElement mandatoryForApplicantCheckbox;
    @FindBy(css = "input[value='Save']")
    private List<WebElement> saveButton;
    @FindBy(id = "MinFieldId5")
    private WebElement minAgeField;
    @FindBy(id = "MaxFieldId6")
    private WebElement maxAgeField;
    @FindBy(css = "input[class='select2-search__field']")
    private List<WebElement> nationalityField; // use this locator for other fields like Preferred Universities field
    @FindBy(id = "FieldSelectionId7")
    private WebElement nationalitySelectionCount;
    @FindBy(id = "FieldRequiredId7")
    private WebElement nationalityCheckbox;
    @FindBy(id = "FieldId28")
    private WebElement previousEducationCheckbox;
    @FindBy(id = "FieldSelectionId12")
    private WebElement preferredUniSelectionCount;
    @FindBy(id = "FieldRequiredId12")
    private WebElement preferredUniCheckBox;
    @FindBy(name = "LookupSelectionCount")
    private WebElement preferredMajorSelectionCount;
    @FindBy(id = "FieldRequiredId16")
    private WebElement preferredMajorCheckBox;
    @FindBy(id = "FieldId20")
    private WebElement achievementsCheckbox;
    @FindBy(id = "FieldId21")
    private WebElement statementCheckbox;
    @FindBy(id = "FieldId22")
    private WebElement currentAcademicLevelCheckbox;
    @FindBy(id = "FieldId23")
    private WebElement EducationUniAdmissionsCheckbox;
    @FindBy(id = "FieldId24")
    private WebElement familyInfoCheckbox;
    @FindBy(id = "FieldId25")
    private WebElement englishProCheckbox;
    @FindBy(id = "FieldId26")
    private WebElement mathProCheckbox;


    @FindBy(xpath = "//input[starts-with(@id,'FieldSelectionId')]")
    private List<WebElement> selectionCountList;
    @FindBy(xpath = "//input[starts-with(@id,'FieldRequiredId')]")
    private List<WebElement> mandatoryCheckListList;
    @FindBy(xpath = "//li[starts-with(@id,'select2-FieldId')]")
    private List<WebElement> divList;

    @FindBy(xpath = "//label[starts-with(@class,'btn btn-outline')]")
    private List<WebElement> userType;
    @FindBy(id = "select2-ddlADUser-container")
    private WebElement chooseUserField;
    @FindBy(xpath = "//div[starts-with(@class,'ad-item-email')]")
    private List<WebElement> userEmail;
    @FindBy(xpath = "//label[starts-with(@class,'air__utils__control air')]")
    private List<WebElement> ruleCheckbox;
    @FindBy(id = "btnSubmit")
    private WebElement programSubmitButton;
    @FindBy(xpath = "//p[starts-with(@class,'lead ')]")
    private List<WebElement> sucessLabel;
    @FindBy(xpath = "//button[starts-with(@class,'confirm btn ')]")
    private List<WebElement> programOkButton;
    @FindBy(xpath = "//input[starts-with(@class,'select2-search__field')]")
    private List<WebElement> userSearchField;

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary' and contains(text(), 'OK')]")
    private List<WebElement> okButton;
    @FindBy(id = "ProjectId")
    private WebElement erpIDField;


    public void addProgram() {
        ActionsHelper.waitForListExistance(getProgramsTab(), 50);
        ActionsHelper.selectElementFromList(getProgramsTab(), "Programs");
        //getProgramsTab().get( 1 ).click();
        System.out.println("Divs size: " + getProgramsDiv().size());
        ActionsHelper.waitForListExistance(getAddProgramButton(), 30);
        getAddProgramButton().get(0).click();
        //Set unique name for the created program
        randomName = "AUTOMATION TEST " + System.currentTimeMillis() % 100000;
        ActionsHelper.waitForExistance(getNameEnglishField(), 30);
        getNameEnglishField().sendKeys(randomName);
        getNameArabicField().sendKeys(randomName);
        getStartDateField().sendKeys(ActionsHelper.getFutureDate(0,
                0, 0));
        getEndDateField().sendKeys(ActionsHelper.getFutureDate(10,
                0, 0));
        getDueApplicationDateField().sendKeys(ActionsHelper.getFutureDate(3,
                0, 0));
        getErpIDField().sendKeys("811755");
        getSubmitButton().click();
        ActionsHelper.waitForListExistance(getOkButton(), 30);
        System.out.println("OK: " + getOkButton().size());
        //getOkButton().get( 0 ).click();
        ActionsHelper.selectElementFromList(getOkButton(), "OK");
        getCreatedProgram();
        createdProgramName.click();
        //Save created program name for assertion
        try {
            for (int i = 0; i < getProgramsDiv().size(); i++) {
                if (getProgramsDiv().get(i).getText().equalsIgnoreCase(randomName)) {
                    createdProgram = getProgramsDiv().get(i).getText();
                    ReadWriteHelper.writeIntoXMLFile(createdProgram);
                    break;
                }
            }
        } catch (Exception e) {
        }


    }


    public void setProgramConfig() {
        //Select configurations tab
        ActionsHelper.waitForExistance(getMainInfoLabels(), 50);
        ActionsHelper.waitForListExistance(getProgramOptions(), 50);
        ActionsHelper.selectElementFromList(getProgramOptions(), "Configuration");
        //getProgramOptions().get( 7 ).click();

        //Academic Level
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Academic Level");
        ActionsHelper.waitForListExistance(getAcademicCareersField(), 50);
        System.out.println("Fields List size: " + getAcademicCareersField().size());
        getAcademicCareersField().get(0).click();
        ActionsHelper.waitForListExistance(getUserSearchField(), 20);
        getUserSearchField().get(0).sendKeys("Doctorate");
        ActionsHelper.waitForListExistance(getDivList(), 50);
        ActionsHelper.selectElementFromList(getDivList(), "Doctorate");
        getSelectionCountList().get(0).clear();
        getSelectionCountList().get(0).sendKeys("1");
        getMandatoryCheckListList().get(0).click();
        getSaveButton().get(0).click();

        //Age range
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Age Range");
        ActionsHelper.waitForExistance(getMinAgeField(), 50);
        getMinAgeField().clear();
        getMinAgeField().sendKeys("16");
        getMaxAgeField().clear();
        getMaxAgeField().sendKeys("40");
        getSaveButton().get(1).click();

        //Nationality
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Nationality Selection");
        ActionsHelper.waitForListExistance(getAcademicCareersField(), 50);
        getAcademicCareersField().get(1).click();
        ActionsHelper.waitForListExistance(getUserSearchField(), 20);
        getUserSearchField().get(1).sendKeys("United Arab Emirates");
        ActionsHelper.waitForListExistance(getDivList(), 30);
        ActionsHelper.selectElementFromList(getDivList(), "United Arab Emirates");
        getSelectionCountList().get(1).clear();
        getSelectionCountList().get(1).sendKeys("1");
        getMandatoryCheckListList().get(1).click();
        getSaveButton().get(2).click();

        //Previous Education
        //Thread.sleep( 2000 );
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Previous Education");
        ActionsHelper.waitForExistance(getPreviousEducationCheckbox(), 50);
        getPreviousEducationCheckbox().click();
        getSaveButton().get(3).click();

        //Preferred University
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Preferred University");
        ActionsHelper.waitForListExistance(getAcademicCareersField(), 50);
        getAcademicCareersField().get(2).click();
        ActionsHelper.waitForListExistance(getUserSearchField(), 20);
        getUserSearchField().get(2).sendKeys("Aarhus University");
        ActionsHelper.waitForListExistance(getDivList(), 30);
        ActionsHelper.selectElementFromList(getDivList(), "Aarhus University");
        getAcademicCareersField().get(2).click();
        getUserSearchField().get(2).sendKeys("Boston University");
        ActionsHelper.selectElementFromList(getDivList(), "Boston University");
        getAcademicCareersField().get(2).click();
        getUserSearchField().get(2).sendKeys("Brown University");
        ActionsHelper.selectElementFromList(getDivList(), "Brown University");
        getSelectionCountList().get(2).clear();
        getSelectionCountList().get(2).sendKeys("1");
        getMandatoryCheckListList().get(2).click();
        getSaveButton().get(4).click();

        //Preferred Major
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Preferred Major");
        ActionsHelper.waitForListExistance(getAcademicCareersField(), 50);
        getAcademicCareersField().get(3).click();
        getUserSearchField().get(3).sendKeys("Accounting");
        ActionsHelper.waitForListExistance(getDivList(), 20);
        ActionsHelper.selectElementFromList(getDivList(), "Accounting");
        getAcademicCareersField().get(3).click();
        getUserSearchField().get(3).sendKeys("Biology");
        ActionsHelper.selectElementFromList(getDivList(), "Biology");
        getAcademicCareersField().get(3).click();
        getUserSearchField().get(3).sendKeys("Software Engineering");
        ActionsHelper.selectElementFromList(getDivList(), "Software Engineering");
        getSelectionCountList().get(3).clear();
        getSelectionCountList().get(3).sendKeys("1");
        getMandatoryCheckListList().get(3).click();
        getSaveButton().get(5).click();

        //Achievements
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Achievements");
        ActionsHelper.waitForExistance(getAchievementsCheckbox(), 50);
        getAchievementsCheckbox().click();
        getSaveButton().get(6).click();

        //StatementOfPurpose
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Statement of Purpose for Scholarship");
        ActionsHelper.waitForListExistance(getSaveButton(), 50);
        getSaveButton().get(7).click();

        //Current Academic Level
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Current Academic Level");
        ActionsHelper.waitForExistance(getCurrentAcademicLevelCheckbox(), 50);
        getCurrentAcademicLevelCheckbox().click();
        getSaveButton().get(8).click();

        //Education University Admissions
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Education/University Admissions");
        ActionsHelper.waitForListExistance(getSaveButton(), 50);
        getSaveButton().get(9).click();

        //Family Information
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Relatives/Family Information");
        ActionsHelper.waitForExistance(getFamilyInfoCheckbox(), 50);
        getFamilyInfoCheckbox().click();
        getSaveButton().get(10).click();

        //English Proficiency
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "English Proficiency");
        ActionsHelper.waitForListExistance(getSaveButton(), 50);
        getSaveButton().get(11).click();

        //Math Proficiency
        ActionsHelper.waitForListExistance(getConfigurationsList(), 50);
        ActionsHelper.selectElementFromList(getConfigurationsList(), "Math Proficiency");
        ActionsHelper.waitForListExistance(getSaveButton(), 50);
        getSaveButton().get(12).click();

    }


    public void setProgramTeam() throws Exception {
        //select Program Team tab
        ActionsHelper.waitForListExistance(getProgramOptions(), 50);
        ActionsHelper.selectElementFromList(getProgramOptions(), "Program Team");
        //getProgramOptions().get( 8 ).click();

        //User Type
        ActionsHelper.waitForListExistance(getUserType(), 50);
        ActionsHelper.selectElementFromList(getUserEmail(), "ADEK User");
        //getUserType().get( 0 ).click();
        Thread.sleep(2000);
        ActionsHelper.waitForExistance(getChooseUserField(), 30);
        getChooseUserField().click();
        ActionsHelper.waitForListExistance(getUserSearchField(), 20);
        getUserSearchField().get(0).sendKeys(ReadWriteHelper.readCredentialsXMLFile("recruiterCredentials3",
                "username"));
        ActionsHelper.waitForListExistance(getUserEmail(), 20);
        ActionsHelper.selectElementFromList(getUserEmail(),
                ReadWriteHelper.readCredentialsXMLFile("interviewer1", "username"));
        ActionsHelper.waitForListExistance(getRuleCheckbox(), 20);
        getRuleCheckbox().get(1).click();
        getRuleCheckbox().get(2).click();
        getProgramSubmitButton().click();
        Thread.sleep(1000);
        ActionsHelper.waitForListExistance(getProgramOkButton(), 50);
        //ActionsHelper.selectElementFromList( getProgramOkButton(), "OK" );
        getProgramOkButton().get(0).click();

    }

    public void getCreatedProgram() {
        ActionsHelper.waitForExistance(getSearchField(), 30);
        getSearchField().sendKeys(randomName);
        ActionsHelper.waitForExistance(getSearchButton(), 30);
        getSearchButton().click();
        ActionsHelper.waitForListExistance(getProgramsDiv(), 50);
        createdProgramName = ActionsHelper.getElementFromList(getProgramsDiv(), randomName);
    }


    public void createFullProgram() throws Exception {
        //Create new program
        addProgram();
        //Set program configurations
        setProgramConfig();
        //Set program team
        setProgramTeam();
    }
    public void addProgramToFile() throws Exception {

            for (int i = 0; i < getProgramsDiv().size(); i++) {
                if (getProgramsDiv().get(i).getText().equalsIgnoreCase(randomName)) {
                    createdProgram = getProgramsDiv().get(i).getText();
                    ReadWriteHelper.writeIntoXMLFileInterview(createdProgram);
                    break;
                }
            }



    }

}
