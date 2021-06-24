package com.adam.tests.news;

import com.adam.assertions.home.ParaBankHomePageAssertions;
import com.adam.assertions.news.ParaBankNewsPageAssertions;
import com.adam.pages.login.ParaBankLoginPage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class CheckLatestParaBankNewsTest extends RootTest {
    @Test
    public void loadParaBankHomePage(){
        new ParaBankLoginPage(getDriver(), CONFIG.getParaBankHome())
                .fillInUserLogin(CONFIG.getParaBankUser())
                .fillInUserPassword(CONFIG.getParaBankPass())
                .clickLogIn()
                .waitForHomePageToLoad()
                .clickOnHomePageNavigationButton()
                .check(ParaBankHomePageAssertions.class)
                .assertThatThereIsTheLatestNewsPane()
                .endAssertion()
                .clickOnReadMoreNewsLink()
                .check(ParaBankNewsPageAssertions.class)
                .assertThatLatestNewsLabelIsPresentOnPage()
                .endAssertion();
                
                
        
    }
    
    
}
