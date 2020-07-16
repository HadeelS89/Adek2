package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ScholarshipsPage extends Base {


    public ScholarshipsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

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
    //    @FindBy(xpath = "//input[starts-with(@class,'select2-selection')]")
//    private List<WebElement> programsIndex;
    @FindBy(css= ".font-weight-bold > .col-md-auto:nth-child(1)")
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
    private List <WebElement> payElementNameInput;
    @FindBy(xpath = "//p[starts-with(@class,'lead ')]")
    private List<WebElement> sucessLabel;


    public void clearFilters() {
        ActionsHelper.waitVisibility(getClearFiltersButton(), 90);
        getClearFiltersButton().click();
    }
    public void findProgram(String programName) throws InterruptedException {
        if (isHeadless) {
            ActionsHelper.navigateTo("https://apps-tst.adek.gov.ae/ScholarshipNew/ScholarshipAdminUI/Scholarship");
        } else {


        ActionsHelper.waitForListExistance(getScholarshipsTab(), 100);
        ActionsHelper.selectElementFromList(getScholarshipsTab(), "Scholarships");
    }
        ActionsHelper.waitForExistance( getProgramsLabel(), 100 );
        Thread.sleep( 3000 );
        ActionsHelper.waitForListExistance( getProgramsList1(), 100 );
        getProgramsList1().get( 0 ).click();
        getProgramNameInput().sendKeys(programName);
        getProgramNameInput().sendKeys(Keys.ENTER);
        ActionsHelper.waitForExistance( getBtnApply(), 100 );
        getBtnApply().click();
    }
    public void addPayElement() throws InterruptedException {

        ActionsHelper.waitForExistance(getLblFirstResultCode(), 100);
        getLblFirstResultCode().click();
        ActionsHelper.waitForExistance(getTimeLine(), 60);
        ActionsHelper.waitForListExistance(getApplicationTabs(), 60);
        System.out.println("check 1 " + getApplicationTabs().size());
        getApplicationTabs().get(13).click();
        System.out.println("pay element tab " + getApplicationTabs().get(13).getText());
        ActionsHelper.waitForListExistance(getAddPayElementBtn(), 60);
        System.out.println("text2 " + getAddPayElementBtnn().getTagName());
        driver.getPageSource();
        ActionsHelper.click(getAddPayElementBtnn());
        ActionsHelper.waitForExistance(getEffectiveDate(), 60);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(2, 0, 1));//error when add days =10
        getPayrollElement().click();
        getPayElementNameInput().get(0).sendKeys("Scholarship Earning Adj AED"+ Keys.ENTER);
        getAmount().sendKeys("500");
        ActionsHelper.waitForExistance(getSubmitBtn(), 30);
        getSubmitBtn().click();
        ActionsHelper.waitForListExistance( getSucessLabel(), 60 );
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
        Thread.sleep(3000);
        getProgramsList1().get(0).click();
        ActionsHelper.waitForListExistance(getProgramsIndex(), 50);
        Thread.sleep(3000);
        System.out.println("List: " + getProgramsIndex().size());
        //System.out.println("program list size:" + getProgramsIndex().size());
        for (int i = 0; i < getProgramsIndex().size(); i++) {
            if (getProgramsIndex().get(i).getText().equalsIgnoreCase(programName)) {
                getProgramsIndex().get(i).click();
                System.out.println("program Name1:" + programName);
            }
            Thread.sleep(3000);
            ActionsHelper.waitForExistance(getApplyFilterBtn(), 30);
            // getApplyFilterBtn().click();
        }


    }

    public void addBankDetails() throws InterruptedException {

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
//            ActionsHelper.waitForListExistance(getAddBankDetailsBtn(), 100);
//            getAddBankDetailsBtn().get(1).click();
            ActionsHelper.waitForExistance(getAddBankDetailsBtnn(), 100);
            getAddBankDetailsBtnn().click();


        }
        ActionsHelper.waitForExistance(getEffectiveDate(), 100);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(1, 0, 0));
        getCountryDDL().sendKeys("United Arab Emirates");
        ActionsHelper.waitForExistance(getBankName(), 50);
        getBankName().click();
        getBankName().sendKeys("ABU DHABI ISLAMIC BANK"+ Keys.ENTER);
        ActionsHelper.waitForExistance(getBankBranchName(), 50);
        getBankBranchName().click();
        getBankBranchName().sendKeys("AL AIN SANAIYA"+ Keys.ENTER);
        getAddressLine1().sendKeys("ABU DHABI");
        getAddressLine2().sendKeys("ABU DHABI Area 2");
        getIABN().sendKeys("AE320500000000028353371");
        getSubmitBankDetailsBtn().click();
        ActionsHelper.waitForExistance(getYesButton(),100);
        getYesButton().click();
        ActionsHelper.waitForExistance(getSuccess(), 100);
    }
}

