package com.adam.pages.accounts.details;

import com.adam.pages.core.ParaBankPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountDetailsPage extends ParaBankPage {
    
    @FindBy(xpath = "//h1[. = 'Account Details']")
    private WebElement accountDetailsLabel;
    
    @FindBy(id = "accountType")
    private WebElement accountTypeDeclaration;
    
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
    
    public AccountDetailsPage retrieveAccountType(String declaredAccountType){
        declaredAccountType = accountTypeDeclaration.getText();
        return this;
    }
}
