package com.adam.assertions;

import com.adam.assertions.core.AbstractAssertions;
import com.adam.pages.ParaBankHomePage;

import static org.testng.Assert.assertEquals;


public class ParaBankHomePageAssertions extends AbstractAssertions<ParaBankHomePage> {

    public ParaBankHomePageAssertions assertThatParaBankHomePageLoaded(String expectedTitleText){
        assertEquals(page.titleLabel.getText(), expectedTitleText, "Suprisingly the titleLabel text is different than expected");
        logger.info("Successfully verified that used logged In");
        return this;
    }
}
