package com.adam.pages.accounts;

import com.adam.pages.accounts.details.AccountDetailsPage;
import com.adam.pages.core.ParaBankPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class ParaBankAccountsOverviewPage extends ParaBankPage {
    @FindBy(xpath = "//h1[. = 'Accounts Overview']")
    private WebElement accountsOverviewLabel;
    
    @FindBy(css = "a.ng-binding")
    private List<WebElement> listOfAccountIdentifiers;
    
    public ParaBankAccountsOverviewPage(WebDriver driver) {
        super(driver);
    }
    
    public AccountDetailsPage enterIntoTheFirstAccount(){
        getWait().until(ExpectedConditions.visibilityOf(accountsOverviewLabel));
        listOfAccountIdentifiers.get(0).click();
        return new AccountDetailsPage(getDriver());
    }
}
