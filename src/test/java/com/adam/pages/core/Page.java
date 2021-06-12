package com.adam.pages.core;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    @Getter
    private final WebDriver driver;
    @Getter
    private final WebDriverWait wait;
    
    protected Page(WebDriver driver, String url){
        this.driver = driver;
        if(url != null) {
            driver.navigate().to(url);
        }
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 5);
    }
}

