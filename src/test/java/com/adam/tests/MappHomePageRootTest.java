package com.adam.tests;

import com.adam.assertions.HomePageAssertions;
import com.adam.pages.HomePage;
import com.adam.tests.core.RootTest;

public class MappHomePageRootTest extends RootTest {

    private static final String MAPP_DIGITAL_HOME_URL = "https://mapp.com";

    @org.testng.annotations.Test
    public void loadMappHomePage(){
        new HomePage(super.getDriver(), MAPP_DIGITAL_HOME_URL)
                .waitForHomePageToLoad()
                .check(HomePageAssertions.class)
                .assertThatMappHomePageLoaded()
                .endAssertion();
    }
}
