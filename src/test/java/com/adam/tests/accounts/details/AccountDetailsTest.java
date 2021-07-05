package com.adam.tests.accounts.details;

import com.adam.assertions.accounts.ParaBankAccountsOverviewPageAssertions;
import com.adam.assertions.accounts.details.AccountDetailsPageAssertions;
import com.adam.pages.login.ParaBankLoginPage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class AccountDetailsTest extends RootTest {
    
    private String declaredAccountType;
    
    @Test
    public void displayDetailsOfSelectedAccount() {
        new ParaBankLoginPage(getDriver(), CONFIG.getParaBankHome())
                .fillInUserLogin(CONFIG.getParaBankUser())
                .fillInUserPassword(CONFIG.getParaBankPass())
                .clickLogIn()
                .waitForHomePageToLoad()
                .openAccountsOverviewPage()
                .check(ParaBankAccountsOverviewPageAssertions.class)
                .assertThatListOfAccountsIsNotEmpty()
                .endAssertion()
                .enterIntoTheFirstAccount()
                .check(AccountDetailsPageAssertions.class)
                .assertThatAccountDetailsPageIsDisplayed()
                .endAssertion()
                .retrieveAccountType(declaredAccountType);
    }
}
