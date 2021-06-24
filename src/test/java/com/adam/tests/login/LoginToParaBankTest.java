package com.adam.tests.login;

import com.adam.assertions.home.ParaBankHomePageAssertions;
import com.adam.pages.login.ParaBankLoginPage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class LoginToParaBankTest extends RootTest {

    private static final String TITLE_LABEL_TEXT = "Accounts Overview";

    @Test
    public void shouldLoginAnUser(){
        new ParaBankLoginPage(getDriver(), CONFIG.getParaBankHome())
                .fillInUserLogin(CONFIG.getParaBankUser())
                .fillInUserPassword(CONFIG.getParaBankPass())
                .clickLogIn()
                .waitForHomePageToLoad()
                .check(ParaBankHomePageAssertions.class)
                .assertThatLoginPanelIsGone()
                .assertThatWelcomeUserTextVisible(CONFIG.paraBankUserFirstName, CONFIG.paraBankUserLastName)
                .assertThatAccountsOverviewVisible(TITLE_LABEL_TEXT)
                .endAssertion();
    }
}

