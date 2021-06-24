package com.adam.assertions.home;

import com.adam.assertions.core.AbstractAssertions;
import com.adam.pages.home.ParaBankHomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ParaBankHomePageAssertions extends AbstractAssertions<ParaBankHomePage> {

    public ParaBankHomePageAssertions assertThatAccountsOverviewVisible(String expectedTitleText){
        assertEquals(page.getTitleLabel().getText(), expectedTitleText, "Suprisingly the titleLabel text is different than expected");
        logger.info("Successfully verified that used logged In");
        return this;
    }
    
    public ParaBankHomePageAssertions assertThatWelcomeUserTextVisible(String firstName, String lastName){
        assertEquals(page.getWelcomeTextElement().getText(), "<b>Welcome</b> " + firstName + ' ' + lastName, "Welcome small text is different!");
        logger.info("Successfully verified that the welcome text is OK");
        return this;
    }
    
    public ParaBankHomePageAssertions assertThatLoginPanelIsGone(){
        assertTrue(page.getLoginPanel().isEmpty(), "Suprisingly the test user has troubles with login");
        logger.info("Successfully navigated to the HomePage");
        return this;
    }
    
    public ParaBankHomePageAssertions assertThatThereIsTheLatestNewsPane(){
        assertTrue(page.getLatestNewsPanel().isDisplayed(), "There is no 'Latest News' panel!");
        logger.info("Successfully verified that the 'Latest News' panel is in place");
        return this;
    }
}
