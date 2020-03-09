package com.adam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageSupportAssertion {


    @FindBy(xpath = "//a[@title = 'REQUEST FREE DEMO']")
    public WebElement requestFreeDemoButton;

    @FindBy(xpath = "//a[contains(@href, 'mapp-cloud')]")
    public WebElement learnMoreAboutMappCloudButton;



    public HomePage(WebDriver driver, String url){
        super(driver, url);
    }

    public MappCloudPage navigateToMappCloudPage(){
        learnMoreAboutMappCloudButton.click();
        waitForPageToLoad();
        return new MappCloudPage(driver, null);
    }

}
