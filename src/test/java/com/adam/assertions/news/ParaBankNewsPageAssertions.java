package com.adam.assertions.news;

import com.adam.assertions.core.AbstractAssertions;
import com.adam.pages.news.ParaBankNewsPage;

import static org.testng.Assert.assertTrue;

public class ParaBankNewsPageAssertions extends AbstractAssertions<ParaBankNewsPage> {
    
    public ParaBankNewsPageAssertions assertThatLatestNewsLabelIsPresentOnPage(){
        assertTrue(page.getParaBankNewsLabel().isDisplayed(), "Surprisingly there is no 'Latest News' labal!");
        logger.info("Successfully verified that the 'Latest News' Label is displayed");
        return this;
    }
}
