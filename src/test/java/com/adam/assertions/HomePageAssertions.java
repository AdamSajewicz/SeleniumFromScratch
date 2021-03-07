package com.adam.assertions;

import com.adam.assertions.core.AbstractAssertion;
import com.adam.pages.HomePage;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class HomePageAssertions extends AbstractAssertion<HomePage> {

    public HomePageAssertions assertThatMappHomePageLoaded(){
        assertTrue(page.getDriver().findElement(By.xpath("//a[@title = 'REQUEST FREE DEMO']")).isDisplayed(), "Warning!, there is no 'Request Free Demo' buton!");
        logger.info("Mapp HomePage loaded successfully");
        return this;
    }
}
