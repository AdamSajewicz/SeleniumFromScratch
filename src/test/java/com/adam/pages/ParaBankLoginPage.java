package com.adam.pages;

import com.adam.pages.core.PageSupportAssertions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ParaBankLoginPage extends PageSupportAssertions {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    public ParaBankLoginPage(WebDriver driver, String url){
        super(driver, url);
    }

    public ParaBankLoginPage fillInUserLogin(String login){
        getWait().until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(login);
        return this;
    }
    
    public ParaBankLoginPage fillInUserPassword(String password){
        getWait().until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }
    
    public ParaBankHomePage clickLogIn(){
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new ParaBankHomePage(getDriver());
    }
    
}
