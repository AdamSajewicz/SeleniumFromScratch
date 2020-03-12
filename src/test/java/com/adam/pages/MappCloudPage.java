package com.adam.pages;

import com.adam.pages.core.PageSupportAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MappCloudPage extends PageSupportAssertion {

    @FindBy(xpath = "//div[@class = 'confident-welcomtext']/div/h1")
    public WebElement welcomText;

    MappCloudPage(WebDriver driver, String url){
        super(driver, url);
    }
}
