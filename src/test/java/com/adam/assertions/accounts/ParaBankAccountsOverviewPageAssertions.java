package com.adam.assertions.accounts;


import com.adam.assertions.core.AbstractAssertions;
import com.adam.pages.accounts.ParaBankAccountsOverviewPage;

import static org.testng.Assert.assertTrue;

public class ParaBankAccountsOverviewPageAssertions extends AbstractAssertions<ParaBankAccountsOverviewPage> {
    public ParaBankAccountsOverviewPageAssertions assertThatListOfAccountsIsNotEmpty(){
        assertTrue(page.getListOfAccountIdentifiers().isEmpty(), "Unfortunately at this moment the list of accounts is empty");
        logger.info("Successfully verified that there are still some open accounts");
        return this;
    }
}
