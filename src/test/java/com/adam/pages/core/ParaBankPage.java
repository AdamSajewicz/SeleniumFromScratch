package com.adam.pages.core;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ParaBankPage extends PageSupportAssertions{
    protected ParaBankPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "li.home a[href*='index.htm']")
    private WebElement goToHomePageButton;
    
}
