package com.adam.assertions;

import com.adam.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class HomePageAssertions extends AbstractAssertion<HomePage> {

    public void assertThatMappHomePageLoaded(){
        assertTrue(page.requestFreeDemoButton.isDisplayed());
        logger.info("Mapp HomePage loaded successfully");
    }
}
