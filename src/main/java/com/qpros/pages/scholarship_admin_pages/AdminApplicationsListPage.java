package com.qpros.pages.scholarship_admin_pages;

import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

@Getter
public class AdminApplicationsListPage extends Base{

    public AdminApplicationsListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchbox")
    private WebElement searchBox;
    @FindBy(id="btnGroupAddon2")
    private WebElement btnSearch;
    @FindBy(xpath="//*[@id=\"mainDiv\"]/div[3]/div[1]/div[2]/div[1]/div[1]")
    private WebElement lblFirstResultCode;
    //TODO: Locate Status Drop down list
    @FindBy(xpath="//div[@id='filterContainer']/div/div[3]/select")
    private WebElement statusDDL;
    @FindBy(css="div[class='col-md-auto']")
    private List<WebElement> resultsCodes;
    @FindBy(id="btnApply")
    private WebElement btnApply;
    @FindBy(xpath="//input[@type='checkbox']")
    private WebElement cbAssignedToMe;
    @FindBy(css="button[value='StartReview']")
    private List<WebElement> btnStartReviews;



    public void searchByKeyWord_ApplicantCode(String keyWord) throws InterruptedException {
        ActionsHelper.waitVisibility(getSearchBox(), 20);
        getSearchBox().sendKeys(keyWord);
        ActionsHelper.waitVisibility(getBtnApply(), 20);
        ActionsHelper.waitVisibility(getBtnSearch(), 20);
        getBtnSearch().click();


    }

    public void searchByStatus(String statusText, Boolean isAssignedToMe){
        ActionsHelper.waitVisibility(getSearchBox(), 90);
        ActionsHelper.selectByValue(getStatusDDL(), statusText);
        ActionsHelper.waitVisibility(getBtnApply(), 90);
        ActionsHelper.waitToBeClickable(getBtnApply(), 90);
        ActionsHelper.waitForSeconds(90);
        if (isAssignedToMe){
            getCbAssignedToMe().click();
        }
        getBtnApply().click();

    }

}
