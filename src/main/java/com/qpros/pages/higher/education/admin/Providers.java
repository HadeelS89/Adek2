package com.qpros.pages.higher.education.admin;

import com.github.javafaker.Faker;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class Providers {

    public static String randomName = "";
    public static String createdProvider = "";
    WebElement createdProviderName = null;

    public Providers(WebDriver driver) {
        PageFactory.initElements( driver, this );
    }
    @FindBy(css = "a[class='air__menuLeft__link']")
    private List<WebElement> providerTab;
    @FindBy(className = "col-md-auto")
    private List<WebElement> providerDiv;
    @FindBy(css = "i[class='btn-addon-icon fe fe-plus-circle']")
    private List<WebElement> addProviderButton;
    @FindBy(id = "NameEnglish")
    private WebElement nameEnglishField;
    @FindBy(id = "NameArabic")
    private WebElement nameArabicField;
    @FindBy(id = "RegNumber")
    private WebElement referenceNumberField;
    @FindBy(id = "ProviderTypeId")
    private List<WebElement> providerTypeIdList;
    @FindBy(id = "ProviderCategoryId")
    private List<WebElement> providerCategoryIdList;
    @FindBy(id = "ProviderUnitId")
    private List<WebElement> providerUnitIdList;
    @FindBy(id = "ProviderZoneId")
    private List<WebElement> ProviderZoneIdList;
    @FindBy(id = "Website")
    private WebElement website;
    @FindBy(id = "ProviderStatusId")
    private List<WebElement> ProviderStatusId;
    @FindBy(id = "AuthorizationReference")
    private WebElement authorizationReference;
    @FindBy(id = "AuthorizationIssuancediv")
    private WebElement issuanceOn;
    @FindBy(id = "AuthorizationExpirydiv")
    private WebElement expiryOn;
    @FindBy(id = "ProviderZoneId")
    private WebElement providerZoneId;
    @FindBy(id = "AddressEnglish")
    private WebElement addressEnglish;
    @FindBy(id = "AddressArabic")
    private WebElement addressArabic;
    @FindBy(id = "Longitude")
    private WebElement longitude;
    @FindBy(id = "Latitude")
    private WebElement latitude;
    @FindBy(xpath = "//a[contains(text(),'Save')]")
    private WebElement providerSaveButton;
    @FindBy(xpath = "//button[contains(.,'Yes')]")
    private WebElement providerYesButton;
    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    private WebElement providerCancelButton;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement providerOKButton;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement providerTokenSearch;
    @FindBy(xpath = "xpath=//input[contains(text(),'Send']")
    private WebElement providerTokenSend;
    @FindBy(xpath = "//button[contains(.,' Send Token for Existing Provider')]")
    private WebElement providerTokenSendTokenExistingButton;
    @FindBy(id = "TokenProviderRegNumberDLL")
    private List<WebElement> providerTokenRegNumber;
    @FindBy(id = "select2-TokenProviderRegNumberDLL-container")
    private List<WebElement> providerTokenRegNumberContainer;
    @FindBy(id = "TokenEmailAddress")
    private WebElement providerTokenEmail;
    @FindBy(css = ".select2-container--below .select2-selection__arrow")
    private WebElement providerTokenSelectFromList;
    @FindBy(css = ".select2-search__field")
    private WebElement providerTokenSelectFromListSearchBox;
    @FindBy(id = "searchbox")
    private WebElement searchBox;
    @FindBy(id = "ddlPageSize")
    private WebElement ddlPageSize;

    Faker faker= new Faker();

    public void addProvider() throws InterruptedException {
        ActionsHelper.waitForListExistance( getProviderTab(), 50 );
        ActionsHelper.selectElementFromList( getProviderTab(), "Providers");
        System.out.println( "Divs size: " + getProviderTab().size() );
        ActionsHelper.waitForListExistance( getAddProviderButton(), 50 );
        getAddProviderButton().get(0).click();
        randomName = "AUTOMATION TEST " + System.currentTimeMillis() % 100000;
        ActionsHelper.waitForListExistance( getProviderTypeIdList(), 30 );
        getProviderTypeIdList().get(0).sendKeys("Federal");
        //ActionsHelper.selectElementFromList(getProviderTypeIdList(),"Federal");

        ActionsHelper.waitForExistance( getNameEnglishField(), 30 );
        getNameEnglishField().sendKeys( randomName );
        getNameArabicField().sendKeys( randomName );
        getReferenceNumberField().sendKeys(randomName);
        getProviderCategoryIdList().get(0).sendKeys("University");
        getProviderUnitIdList().get(0).sendKeys("College");
        getWebsite().sendKeys(faker.company().url());
        getProviderStatusId().get(0).sendKeys("Active");
        getAuthorizationReference().sendKeys(randomName);
        getIssuanceOn().click();
        try {
            ActionsHelper.HandleKendoDateTimePicker("24","Jul","2020");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ( ActionsHelper.getFutureDate( 0, 0, 0 ));
        getExpiryOn().click();
        try {
            ActionsHelper.HandleKendoDateTimePicker("24","Jul","2021");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getProviderZoneId().sendKeys("Abu Dhabi");
        getAddressEnglish().sendKeys(randomName);
        getAddressArabic().sendKeys(randomName);
        getLatitude().sendKeys("24.466667");
        getLongitude().sendKeys("54.366669");
        getProviderSaveButton().click();
        getProviderYesButton().click();
        ActionsHelper.waitForExistance(getProviderOKButton(),30);
        getProviderOKButton().click();
        ActionsHelper.waitForListExistance( getProviderTab(), 50 );
        ActionsHelper.selectElementFromList( getProviderTab(), "Providers Token");
        ActionsHelper.waitForExistance(getProviderTokenSendTokenExistingButton(),30);
        getProviderTokenSendTokenExistingButton().click();
        ActionsHelper.waitForListExistance(getProviderTokenRegNumberContainer(),30);
        getProviderTokenRegNumberContainer().get(0).click();
        ActionsHelper.waitForExistance(getProviderTokenSearch(),30);
        getProviderTokenSearch().sendKeys(randomName+ Keys.ENTER);
        getProviderTokenEmail().sendKeys(String.format("qprosautomation+%s@gmail.com",randomName.substring(16)));
        Thread.sleep(3000);
        ActionsHelper.waitForExistance(getProviderTokenSend(),30);
        getProviderTokenSend().click();




    }

    public void createFullProvider() throws Exception {
        //Create new program
        addProvider();
        //Set program configurations
        //setProgramConfig();
        //Set program team
        //setProgramTeam();
    }
}
