package com.adam.pages.news;

import com.adam.pages.core.ParaBankPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ParaBankNewsPage extends ParaBankPage {
    public ParaBankNewsPage(WebDriver driver, String url) {
        super(driver, url);
    }
    
    public ParaBankNewsPage(WebDriver driver) {
        super(driver, null);
    }
    
    @FindBy(xpath = "//h1[normalize-space()='ParaBank News']")
    private WebElement paraBankNewsLabel;
    
}
