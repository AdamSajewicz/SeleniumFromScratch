package com.adam.pages;

import com.adam.pages.core.PageSupportAssertion;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class HomePage extends PageSupportAssertion {

    @FindBy(xpath = "//a[@title = 'REQUEST FREE DEMO'][2]")
    public WebElement requestFreeDemoButton;

    @FindBy(xpath = "//img[@alt = 'Break Away from the Pack']")
    public WebElement breakAwayImg;

    @FindBy(xpath = "//a[contains(@href, 'mapp-cloud')]")
    public WebElement learnMoreAboutMappCloudButton;

    public HomePage(WebDriver driver, String url){
        super(driver, url);
    }

    public MappCloudPage navigateToMappCloudPage(){
        learnMoreAboutMappCloudButton.click();
        //waitForPageToLoad();
        return new MappCloudPage(getDriver(), null);
    }

    public HomePage waitForHomePageToLoad(){
        getWait().until(ExpectedConditions.visibilityOf(breakAwayImg));
        return this;
    }
}
