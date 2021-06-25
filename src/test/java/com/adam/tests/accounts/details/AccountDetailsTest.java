package com.adam.tests.accounts.details;

import com.adam.pages.login.ParaBankLoginPage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class AccountDetailsTest extends RootTest {
    
    @Test
    public void displayDetailsOfSelectedAccount() {
        new ParaBankLoginPage(getDriver(), CONFIG.getParaBankHome())
                .fillInUserLogin(CONFIG.getParaBankUser())
                .fillInUserPassword(CONFIG.getParaBankPass())
                .clickLogIn()
                .waitForHomePageToLoad();
    }
}
