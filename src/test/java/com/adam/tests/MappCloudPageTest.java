package com.adam.tests;

import com.adam.assertions.MappCloudPageAssertions;
import com.adam.pages.HomePage;
import com.adam.tests.core.CoreTest;
import org.testng.annotations.Test;

public class MappCloudPageTest extends CoreTest {

    private static final String MAPP_DIGITAL_HOME_URL = "https://mapp.com";
    private static final String WELCOM_TEXT = "Mapp Cloud brings customer acquisition and customer engagement together in one simple marketing cloud infused with data intelligence.";

    @Test
    public void navigateToMappCloudPage(){
        new HomePage(super.driver, MAPP_DIGITAL_HOME_URL)
        .navigateToMappCloudPage()
        .check(MappCloudPageAssertions.class)
                .assertThatMappCloudPageLoaded(WELCOM_TEXT)
        .endAssertion();
    }
}

