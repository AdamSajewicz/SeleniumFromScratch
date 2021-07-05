package com.adam.pages.home;

import com.adam.pages.accounts.ParaBankAccountsOverviewPage;
import com.adam.pages.news.ParaBankNewsPage;
import com.adam.pages.core.ParaBankPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class ParaBankHomePage extends ParaBankPage {

    @FindBy(xpath = "//h2[normalize-space()='Account Services']")
    private WebElement accountServicesLabel;
    
    @FindBy(xpath = "//h1[@class = 'title']")
    private WebElement titleLabel;
    
    @FindBy(css = "div#loginPanel")
    private List<WebElement> loginPanel;
    
    @FindBy(css = "p.smallText")
    private WebElement welcomeTextElement;
    
    @FindBy(xpath = "//div[@id = 'rightPanel']//h4[.='Latest News']")
    private WebElement latestNewsPanel;
    
    @FindBy(xpath = "//div[@id = 'rightPanel']//a[contains(@href, 'news.htm')]")
    private WebElement readMoreNewsLink;
    
    @FindBy(xpath = "//a[. = 'Accounts Overview']")
    private WebElement accountsOverviewMenuOption;        

    ParaBankHomePage(WebDriver driver, String url){
        super(driver, url);
    }
    
    public ParaBankHomePage(WebDriver driver){
        super(driver);
    }
    
    public ParaBankHomePage waitForHomePageToLoad(){
        waitForPageToLoad();
        getWait().until(ExpectedConditions.visibilityOf(accountServicesLabel));
        return this;
    }
    
    public ParaBankHomePage clickOnHomePageNavigationButton(){
        getWait().until(ExpectedConditions.elementToBeClickable(getGoToHomePageButton()));
        getGoToHomePageButton().click();
        return this;
    }
    
    public ParaBankNewsPage clickOnReadMoreNewsLink(){
        getWait().until(ExpectedConditions.elementToBeClickable(readMoreNewsLink));
        readMoreNewsLink.click();
        return new ParaBankNewsPage(getDriver());
    }
    
    public ParaBankAccountsOverviewPage openAccountsOverviewPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(accountsOverviewMenuOption));
        accountsOverviewMenuOption.click();
        return new ParaBankAccountsOverviewPage(getDriver());
    }
}
