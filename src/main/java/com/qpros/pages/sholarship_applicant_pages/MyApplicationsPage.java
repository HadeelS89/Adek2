package com.qpros.pages.sholarship_applicant_pages;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Getter
public class MyApplicationsPage extends Base {

    public MyApplicationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(.,'My Applications')]")
    private WebElement myApplication;



    @FindBy(css = "div[class='card shadow-sm']")
    private List<WebElement> programDiv;
    @FindBy(css = "h4[class='card-title']")
    private List<WebElement> programTilte;
//    @FindBy(css = "p[class='card-text text-muted']")
//    private List<WebElement> programDate;
    @FindBy(xpath = "//div[2]/div/div[2]/div[2]/div/div[3]/button/i")
    private WebElement editAdmission;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement editMajor;
    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement editSaveBtn;
    @FindBy(xpath = "//div[2]/div/div[2]/div[2]/div/div[3]/button[2]/i")
    private WebElement editProfDetails;
    @FindBy(xpath = "//input[@placeholder='IELTS - UKVI Score']")
    private WebElement editIELTS;
    @FindBy(xpath = "//div[@id='docUp74']/div/div")
    private WebElement uploadIELTSField;
    @FindBy(css = "input[type='file']")
    private WebElement uploadIELTS;
    @FindBy(xpath = "//div[3]/div[2]/button")
    private WebElement uploadButton;
    @FindBy(xpath = "(//button[@type='button'])[11]")
    private WebElement goToMyApp;


    public void myApplication() throws InterruptedException{
        ActionsHelper.waitVisibility( getMyApplication(), 5 );
        getMyApplication().click();



    }

    public void checkProgramName(String programTitle) throws Exception {
        System.out.println("Current Date: "+ ActionsHelper.getTodayDate());
        ActionsHelper.waitVisibility( getMyApplication(), 15 );
        getMyApplication().click();
        Thread.sleep(10000);
        System.out.println("Program Size: "+ getProgramDiv().size());
        System.out.println("Title Size: "+ getProgramTilte().size());
        //System.out.println("Button Size: "+ getApplicationButton().size());
        for (int i = 0; i < getProgramDiv().size(); i++){
            String programTilte = getProgramTilte().get( i ).getText();

            System.out.println("Program Title: "+ programTilte);

            if(programTilte.equalsIgnoreCase(programTitle)
                    && getEditAdmission().isEnabled()){
                System.out.println("Program Title inside if: "+ programTilte);
                getEditAdmission().click();
                ActionsHelper.waitVisibility(getEditMajor(),5);
            getEditMajor().clear();
                getEditMajor() .sendKeys("edit 1");
            ActionsHelper.waitVisibility(getEditSaveBtn(),5);
                getEditSaveBtn().click();
                ActionsHelper.waitVisibility(getEditProfDetails(),10) ;
            getEditProfDetails().click();
                ActionsHelper.waitVisibility(getEditIELTS(),10);
                getEditIELTS().sendKeys("5");
                ActionsHelper.waitVisibility(getUploadIELTSField(),15);
                getUploadIELTSField().click();
                ActionsHelper.waitVisibility(getUploadIELTS(),15);
                getUploadIELTS().sendKeys("C:\\Users\\HadeelSalameh\\" +
                        "Pictures\\image.PNG");
                ActionsHelper.safeJavaScriptClick(getUploadButton());
                ActionsHelper.waitVisibility(getEditSaveBtn(),15);
                getEditSaveBtn().click();
               // ActionsHelper.waitVisibility(getGoToMyApp(),15);


                break;

            }

        }



    }

}
