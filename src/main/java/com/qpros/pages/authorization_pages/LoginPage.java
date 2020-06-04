package com.qpros.pages.authorization_pages;


import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class LoginPage extends Base {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Input_Email")
    private WebElement email;
    @FindBy(id = "Input_Password")
    private WebElement password;
    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/form/div[5]/button")
    private WebElement LoginButton;
    @FindBy(name = "provider")
    private WebElement LoginAsAdekEmployee;
    @FindBy(id = "i0116")
    private WebElement msEmail;
    @FindBy(id = "i0118")
    private WebElement msPassword;
    @FindBy(id = "idSIButton9")
    private WebElement msNextButton;
    @FindBy(id = "idBtn_Back")
    private WebElement staySignedInNoButton;
    @FindBy(id = "Address")
    private WebElement addressTab;



    public void signIn(String email, String password){
        ActionsHelper.waitVisibility( getEmail(), 20);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        ActionsHelper.waitVisibility( getLoginButton(), 10 );
        getLoginButton().click();
        ActionsHelper.waitVisibility( getAddressTab(), 20 );

    }

    public void signInAsADEKEmployee(String email, String password){
        ActionsHelper.waitVisibility( getLoginAsAdekEmployee(), 20);
        getLoginAsAdekEmployee().click();
        ActionsHelper.waitVisibility( getMsEmail(), 20);
        getMsEmail().sendKeys( email );
        getMsNextButton().click();
        ActionsHelper.waitVisibility( getMsPassword(), 20);
        getMsPassword().sendKeys( password );
        getMsNextButton().click();
        if (ActionsHelper.waitVisibility( getStaySignedInNoButton(), 30)){
            getStaySignedInNoButton().click();
        }

    }



}