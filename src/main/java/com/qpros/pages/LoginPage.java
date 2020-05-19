package com.qpros.pages;


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

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "u_0_b")
    private WebElement LoginButton;
    @FindBy(xpath = "//*[@id=\"globalContainer\"]/div[3]/div/div/div")
    private WebElement alertMessage;


    public void signIn(String email, String password){
        ActionsHelper.waitVisibility( getEmail(), 5 );
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        ActionsHelper.waitVisibility( getLoginButton(), 5 );
        getLoginButton().click();
        ActionsHelper.waitVisibility( getAlertMessage(), 10 );
    }



}
