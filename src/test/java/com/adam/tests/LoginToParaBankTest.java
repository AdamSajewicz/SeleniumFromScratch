package com.adam.tests;

import com.adam.assertions.ParaBankHomePageAssertions;
import com.adam.pages.ParaBankLoginPage;
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
                .assertThatParaBankHomePageLoaded(TITLE_LABEL_TEXT)
                .endAssertion();
    }
}

