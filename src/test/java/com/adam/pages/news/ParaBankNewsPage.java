package com.adam.pages.news;

import com.adam.pages.core.ParaBankPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ParaBankNewsPage extends ParaBankPage {
    public ParaBankNewsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "div[@id = rightPanel]//h1[. = 'ParaBank News']")
    private WebElement paraBankNewsLabel;
    
}
