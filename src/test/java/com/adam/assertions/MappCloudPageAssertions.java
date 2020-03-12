package com.adam.assertions;

import com.adam.assertions.core.AbstractAssertion;
import com.adam.pages.MappCloudPage;

import static org.testng.AssertJUnit.assertEquals;

public class MappCloudPageAssertions extends AbstractAssertion<MappCloudPage> {

    public MappCloudPageAssertions assertThatMappCloudPageLoaded(String welcomeText){
        assertEquals(page.welcomText.getText(), welcomeText, "Suprisingly the welcome text is different than expected");
        logger.info("Successfully verified that MappCloud page loaded");
        return this;
    }
}
