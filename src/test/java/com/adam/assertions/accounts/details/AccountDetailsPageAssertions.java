package com.adam.assertions.accounts.details;

import com.adam.assertions.core.AbstractAssertions;
import com.adam.pages.accounts.details.AccountDetailsPage;

import static org.testng.Assert.assertTrue;

public class AccountDetailsPageAssertions extends AbstractAssertions<AccountDetailsPage> {
    public AccountDetailsPageAssertions assertThatAccountDetailsPageIsDisplayed(){
        assertTrue(page.getAccountDetailsLabel().isDisplayed(), "Account Details page is not loaded!");
        logger.info("Positively verified that account Details page is loaded");
        return this;
    }
}
