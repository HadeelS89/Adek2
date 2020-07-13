package com.qpros.pages.higher.education.admin;

import com.github.javafaker.Faker;
import com.qpros.helpers.ActionsHelper;
import com.qpros.pages.Data;
import com.qpros.pages.higher.education.Locators;
import com.qpros.utils.Month;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.Locale;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Getter
public class Providers {
    protected static Logger LOGGER = Logger.getLogger(Providers.class.getName());

    public static String randomName = "";
    public static String createdProvider = "";
    private int maxWait=150;
    private int minWait=50;

    public Providers(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = Locators.PROVIDER_TAB)
    private List<WebElement> providerTab;
    @FindBy(className = Locators.PROVIDER_DIV)
    private List<WebElement> providerDiv;
    @FindBy(css = Locators.ADD_PROVIDER_BUTTON)
    private List<WebElement> addProviderButton;
    @FindBy(id = Locators.NAME_ENGLISH_FIELD)
    private WebElement nameEnglishField;
    @FindBy(id = Locators.NAME_ARABIC_FIELD)
    private WebElement nameArabicField;
    @FindBy(id = Locators.REFERENCE_NUMBER_FIELD)
    private WebElement referenceNumberField;
    @FindBy(css = Locators.PROVIDER_TYPE_ID_LIST)
    private List<WebElement> providerTypeIdList;
    @FindBy(id = Locators.PROVIDER_TYPE_ID)
    private WebElement providerTypeId;
    @FindBy(id = Locators.PROVIDER_CATEGORY_ID_LIST)
    private List<WebElement> providerCategoryIdList;
    @FindBy(id = Locators.PROVIDER_UNIT_ID_LIST)
    private List<WebElement> providerUnitIdList;
    @FindBy(id = Locators.PROVIDER_ZONE_ID_LIST)
    private List<WebElement> ProviderZoneIdList;
    @FindBy(id = Locators.WEBSITE)
    private WebElement website;
    @FindBy(id = Locators.PROVIDER_STATUS_ID)
    private List<WebElement> ProviderStatusId;
    @FindBy(id = Locators.AUTHORIZATION_REFERENCE)
    private WebElement authorizationReference;
    @FindBy(id = Locators.ISSUANCE_ON)
    private WebElement issuanceOn;
    @FindBy(id = Locators.EXPIRY_ON)
    private WebElement expiryOn;
    @FindBy(id = Locators.PROVIDER_ZONE_ID)
    private WebElement providerZoneId;
    @FindBy(id = Locators.ADDRESS_ENGLISH)
    private WebElement addressEnglish;
    @FindBy(id = Locators.ADDRESS_ARABIC)
    private WebElement addressArabic;
    @FindBy(id = Locators.LONGITUDE)
    private WebElement longitude;
    @FindBy(id = Locators.LATITUDE)
    private WebElement latitude;
    @FindBy(xpath = Locators.PROVIDER_SAVE_BUTTON)
    private WebElement providerSaveButton;
    @FindBy(xpath = Locators.PROVIDER_NEXT_BUTTON)
    private WebElement providerNextButton;
    @FindBy(xpath = Locators.PROVIDER_YES_BUTTON)
    private WebElement providerYesButton;
    @FindBy(xpath = Locators.PROVIDER_CANCEL_BUTTON)
    private WebElement providerCancelButton;
    @FindBy(xpath = Locators.PROVIDER_OK_BUTTON)
    private WebElement providerOKButton;
    @FindBy(xpath = Locators.PROVIDER_TOKEN_SEARCH)
    private WebElement providerTokenSearch;
    @FindBy(xpath = Locators.PROVIDER_TOKEN_SEND)
    private WebElement providerTokenSend;
    @FindBy(xpath = Locators.PROVIDER_TOKEN_SEND_TOKEN_EXISTING_BUTTON)
    private WebElement providerTokenSendTokenExistingButton;
    @FindBy(id = Locators.PROVIDER_TOKEN_REG_NUMBER)
    private List<WebElement> providerTokenRegNumber;
    @FindBy(id = Locators.PROVIDER_TOKEN_REG_NUMBER_CONTAINER)
    private List<WebElement> providerTokenRegNumberContainer;
    @FindBy(id = Locators.PROVIDER_TOKEN_EMAIL)
    private WebElement providerTokenEmail;
    @FindBy(css = Locators.PROVIDER_TOKEN_SELECT_FROM_LIST)
    private WebElement providerTokenSelectFromList;
    @FindBy(css = Locators.PROVIDER_TOKEN_SELECT_FROM_LIST_SEARCH_BOX)
    private WebElement providerTokenSelectFromListSearchBox;
    @FindBy(id = Locators.SEARCH_BOX)
    private WebElement searchBox;
    @FindBy(id = Locators.ddl_Page_Size)
    private WebElement ddlPageSize;
    @FindBy(css = Locators.EMAIL_URL_BODY)
    private WebElement emailUrlBody;
    @FindBy(linkText = Locators.PROVIDER_COLLEGE_TAB)
    private WebElement addProviderCollege;
    @FindBy(css = Locators.PROVIDER_COLLEGE_ADD)
    private WebElement addButtonProviderCollege;
    @FindBy(css = Locators.PROVIDER_COLLEGE_NAME_ENGLISH)
    private WebElement nameEnglishButtonProviderCollege;
    @FindBy(css = Locators.PROVIDER_COLLEGE_NAME_ARABIC)
    private WebElement nameArabicButtonProviderCollege;
    @FindBy(id = Locators.PROVIDER_COLLEGE_IS_ACTIVE)
    private WebElement isActiveButtonProviderCollege;
    @FindBy(xpath = Locators.PROVIDER_COLLEGE_SAVE_BUTTON)
    private WebElement saveButtonProviderCollege;
    @Getter
    @Setter
    WebElement createdProviderName;

    Faker enfaker = new Faker(new Locale("en"));
    Faker arfaker = new Faker(new Locale("ar"));

    public void addProvider() throws InterruptedException {
        LOGGER.info("waiting for get Provider tab");
        ActionsHelper.waitForListExistance(getProviderTab(), maxWait);
        LOGGER.info("success for get Provider tab");
        ActionsHelper.selectElementFromList(getProviderTab(), Data.PROVIDERS);
        Thread.sleep(1000);
        ActionsHelper.waitForListExistance(getAddProviderButton(), maxWait);
        getAddProviderButton().get(0).click();
        randomName = enfaker.university().name();
        ActionsHelper.waitForExistance(getProviderTypeId(), minWait);
        getProviderTypeId().sendKeys("Federal");
        getProviderNextButton().click();
        ActionsHelper.waitForExistance(getNameEnglishField(), minWait);
        getNameEnglishField().sendKeys(randomName);
        getNameArabicField().sendKeys(arfaker.university().name());
        getReferenceNumberField().sendKeys(enfaker.phoneNumber().subscriberNumber());
        getProviderCategoryIdList().get(0).sendKeys("University");
        getProviderUnitIdList().get(0).sendKeys("College");
        getWebsite().sendKeys(enfaker.company().url());
        getProviderStatusId().get(0).sendKeys("Active");
        getAuthorizationReference().sendKeys(randomName);
        Calendar cal = ActionsHelper.getTodayDateFromCalender();
        getIssuanceOn().click();
        try {
            ActionsHelper.HandleKendoDateTimePicker(
                    String.valueOf(cal.get(Calendar.DAY_OF_MONTH)),
                    Month.get(cal.get(Calendar.MONTH)).name(),
                    String.valueOf(cal.get(Calendar.YEAR)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getExpiryOn().click();
        try {
            ActionsHelper.HandleKendoDateTimePicker(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)),
                    Month.get(cal.get(Calendar.MONTH)).name(),
                    String.valueOf(cal.get(Calendar.YEAR) + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getProviderZoneId().sendKeys("Abu Dhabi");
        getAddressEnglish().sendKeys(enfaker.address().fullAddress());
        getAddressArabic().sendKeys(arfaker.address().fullAddress());
        getLatitude().sendKeys(enfaker.address().latitude());
        getLongitude().sendKeys(enfaker.address().longitude());
        getProviderSaveButton().click();
        getProviderYesButton().click();
        ActionsHelper.retryClick(getProviderOKButton(), maxWait);


    }

    public void sendProviderToken() throws Exception {
        ActionsHelper.waitForListExistance(getProviderTab(), maxWait);
        ActionsHelper.selectElementFromList(getProviderTab(), "Providers Token");
        ActionsHelper.retryClick(getProviderTokenSendTokenExistingButton(), minWait);
        ActionsHelper.waitForListExistance(getProviderTokenRegNumberContainer(), minWait);
        getProviderTokenRegNumberContainer().get(0).click();
        ActionsHelper.waitForExistance(getProviderTokenSearch(), maxWait);
        getProviderTokenSearch().sendKeys(randomName + Keys.ENTER);
        getProviderTokenEmail().sendKeys(String.format("qprosautomation+%s@gmail.com", Data.RANDOM_NAME.substring(16)));
        Thread.sleep(3000);
        ActionsHelper.retryClick(getProviderTokenSend(), minWait);
        ActionsHelper.retryClick(getProviderOKButton(), minWait);


    }

    public void AddProviderCollege() throws Exception {
//        getCreatedProviderName().click();
//        ActionsHelper.retryClick(getAddButtonProviderCollege(),minWait);
//        ActionsHelper.retryClick(getAddProviderCollege(),minWait);
//        ActionsHelper.retryClick(getAddProviderCollege(),minWait);
//        ActionsHelper.waitForExistance(getNameEnglishButtonProviderCollege(),minWait);
//        getNameEnglishButtonProviderCollege().sendKeys(enfaker.university().name());
//        getNameEnglishButtonProviderCollege().sendKeys(arfaker.university().name());
//        getIsActiveButtonProviderCollege().click();
//        getSaveButtonProviderCollege().click();


//        ActionsHelper.waitForListExistance(getProviderTab(), minWait);
//        ActionsHelper.selectElementFromList(getProviderTab(), Data.PROVIDERS);
//        ActionsHelper.waitForExistance(getProviderTokenSendTokenExistingButton(), minWait);
//        getProviderTokenSendTokenExistingButton().click();
//        ActionsHelper.waitForListExistance(getProviderTokenRegNumberContainer(), minWait);
//        getProviderTokenRegNumberContainer().get(0).click();
//        ActionsHelper.waitForExistance(getProviderTokenSearch(), minWait);
//        getProviderTokenSearch().sendKeys(randomName + Keys.ENTER);
//        getProviderTokenEmail().sendKeys(String.format("qprosautomation+%s@gmail.com", randomName.substring(16)));
//        Thread.sleep(minWait00);
//        ActionsHelper.waitForExistance(getProviderTokenSend(), minWait);
//        getProviderTokenSend().click();
//        ActionsHelper.waitForExistance(getProviderOKButton(), minWait);
//        getProviderOKButton().click();


    }

    public void getCreatedProvider() throws Exception {
        ActionsHelper.waitForListExistance(getProviderTab(), minWait);
        ActionsHelper.selectElementFromList(getProviderTab(), Data.PROVIDERS);
        ActionsHelper.waitForListExistance(getProviderDiv(), minWait);
        System.out.println(getProviderDiv().size());
        setCreatedProviderName(ActionsHelper.getElementFromList(getProviderDiv(), randomName));
    }

    public void createProviderAccountVerification() throws Exception {

        Thread.sleep(3000);
        ActionsHelper.navigateTo("http://autoserver:8080/externalhelper-email/api/v1/email");
        ActionsHelper.waitForExistance(getEmailUrlBody(), 2);
        ActionsHelper.navigateTo(removeLastCharacter(getEmailUrlBody().getText()));
    }


    public void createFullProvider() throws Exception {
        //Create new provider without partners
        addProvider();
        sendProviderToken();
        getCreatedProvider();
        AddProviderCollege();
    }

    public void createFullProviderWithPartners() throws Exception {
        //Create new provider
        addProvider();
        sendProviderToken();

    }

    public static String removeLastCharacter(String str) {
        return Optional.ofNullable(str)
                .filter(sStr -> sStr.length() != 0)
                .map(sStr -> sStr.substring(0, sStr.length() - 1))
                .orElse(str);
    }
}
