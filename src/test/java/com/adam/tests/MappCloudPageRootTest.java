package com.adam.tests;

import com.adam.assertions.MappCloudPageAssertions;
import com.adam.pages.HomePage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class MappCloudPageRootTest extends RootTest {

    private static final String MAPP_DIGITAL_HOME_URL = "https://mapp.com";
    private static final String WELCOME_TEXT = "Mapp Cloud brings customer acquisition and customer engagement together in one simple marketing cloud infused with data intelligence.";

    @Test
    public void navigateToMappCloudPage(){
        new HomePage(super.getDriver(), MAPP_DIGITAL_HOME_URL)
        .navigateToMappCloudPage()
        .check(MappCloudPageAssertions.class)
                .assertThatMappCloudPageLoaded(WELCOME_TEXT)
        .endAssertion();
    }
}

