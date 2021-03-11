package com.adam.pages;

import com.adam.pages.core.PageSupportAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ParaBankHomePage extends PageSupportAssertion {

    @FindBy(xpath = "//h2[normalize-space()='Account Services']")
    public WebElement accountServicesLabel;
    
    @FindBy(xpath = "//h1[@class = 'title']")
    public WebElement titleLabel;

    ParaBankHomePage(WebDriver driver, String url){
        super(driver, url);
    }
    
    ParaBankHomePage(WebDriver driver){
        super(driver, null);
    }
    
    public ParaBankHomePage waitForHomePageToLoad(){
        getWait().until(ExpectedConditions.visibilityOf(accountServicesLabel));
        return this;
    }
}
