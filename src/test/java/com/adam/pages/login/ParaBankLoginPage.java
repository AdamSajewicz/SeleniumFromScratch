package com.adam.pages.login;

import com.adam.pages.core.ParaBankPage;
import com.adam.pages.home.ParaBankHomePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ParaBankLoginPage extends ParaBankPage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    public ParaBankLoginPage(WebDriver driver, String url){
        super(driver, url);
    }

    public ParaBankLoginPage fillInUserLogin(String login){
        waitForPageToLoad();
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
