package com.qpros.pages.scholarship_admin_pages;

import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ScholarshipsPage {


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
    @FindBy(xpath = "//*[@id=\"mainDiv\"]/div[3]/div[1]/div[2]/div[1]/div[1]")
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
    @FindBy(id = "EffectiveDate")
    private WebElement effectiveDate;
    @FindBy(id = "ErpPayrollElementId")
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




    public void clearFilters() {
        ActionsHelper.waitVisibility(getClearFiltersButton(), 90);
        getClearFiltersButton().click();
    }

    public void addPayElement() throws InterruptedException {
        getApplyFilterBtn().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 60);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.waitForExistance(getTimeLine(), 60);
        ActionsHelper.waitForListExistance(getApplicationTabs(), 60);
        System.out.println("check 1 " + getApplicationTabs().size());
        System.out.println("text  " + getApplicationTabs().get(4).getText());
        getApplicationTabs().get(10).click();
        ActionsHelper.waitForListExistance(getAddPayElementBtn(), 60);
        System.out.println("text2 " + getAddPayElementBtn().size());
        getAddPayElementBtn().get(0).click();
        ActionsHelper.waitForExistance(getEffectiveDate(), 60);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(0, 0, 1));//error when add days =10
        getPayrollElement().sendKeys("Scholarship Earning Adj AED");
        getAmount().sendKeys("500");
        ActionsHelper.waitForExistance(getSubmitBtn(), 30);
        getSubmitBtn().click();
        ActionsHelper.waitForExistance(getSuccess(), 60);
    }


    //this method for find program is scholar ship page
    public void findProgram(String programName) throws Exception {
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
        getApplyFilterBtn().click();
        ActionsHelper.waitForExistance(getLblFirstResultCode(), 60);
        System.out.println(getResultsCodes().size());
        getResultsCodes().get(0).click();
        ActionsHelper.waitForExistance(getTimeLine(), 60);
        ActionsHelper.waitForListExistance(getApplicationTabs(), 60);
        System.out.println("check 1 " + getApplicationTabs().size());
        System.out.println("text  " + getApplicationTabs().get(4).getText());
        getApplicationTabs().get(9).click();
        ActionsHelper.waitForExistance(getRecordHeader(), 30);
        if (getAddBankDetailsBtn().get(0).isDisplayed()) {
            ActionsHelper.waitForListExistance(getAddBankDetailsBtn(), 30);
            getAddBankDetailsBtn().get(0).click();

        } else {
            ActionsHelper.waitForListExistance(getFirstBankRecord(), 30);
            System.out.println("record size  " + getFirstBankRecord().size());
            getFirstBankRecord().get(0).click();
            System.out.println("button size  " + getFirstBankRecord().size());
            ActionsHelper.waitForListExistance(getAddBankDetailsBtn(), 30);
            getAddBankDetailsBtn().get(1).click();

        }
        ActionsHelper.waitForExistance(getEffectiveDate(), 30);
        getEffectiveDate().sendKeys(ActionsHelper.getFutureDate(1, 0, 0));
        getCountryDDL().sendKeys("United Arab Emirates");
        getBankName().sendKeys("ABU DHABI ISLAMIC BANK");
        getAddressLine1().sendKeys("ewrwe");
        getAddressLine2().sendKeys("erwerferwerf");
        getBankBranchName().sendKeys("AL AIN SANAIYA");
        getIABN().sendKeys("AE320500000000028353371");
        getSubmitBankDetailsBtn().click();
        ActionsHelper.waitForExistance(getYesButton(),30);
        getYesButton().click();
        ActionsHelper.waitForExistance(getSuccess(), 60);
    }
}

