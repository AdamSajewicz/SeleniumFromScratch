package com.adam.tests;

import com.adam.assertions.HomePageAssertions;
import com.adam.pages.HomePage;
import com.adam.tests.core.CoreTest;
import org.testng.annotations.Test;

public class MappHomePageTest extends CoreTest {

    private static final String MAPP_DIGITAL_HOME_URL = "https://mapp.com";

    @Test
    public void loadMappHomePage(){
        new HomePage(super.driver, MAPP_DIGITAL_HOME_URL)
                .waitForHomePageToLoad()
                .check(HomePageAssertions.class)
                .assertThatMappHomePageLoaded()
                .endAssertion();
    }
}
