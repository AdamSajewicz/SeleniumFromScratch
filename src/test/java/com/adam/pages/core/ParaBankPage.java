package com.adam.pages.core;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ParaBankPage extends PageSupportAssertions{
    protected ParaBankPage(WebDriver driver, String url) {
        super(driver, url);
    }
    
    protected ParaBankPage(WebDriver driver) {
        super(driver, null);
    }
    
    @FindBy(css = "li.home a[href*='index.htm']")
    private WebElement goToHomePageButton;
    
}
