package com.adam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import java.util.concurrent.TimeUnit;

public abstract class CorePage {
    protected WebDriver driver;


    protected CorePage(WebDriver driver, String url){
        this.driver = driver;
        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 10);
        driver.navigate().to(url);
        PageFactory.initElements(ajaxFactory, this);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }

    public void waitForPageToLoad(){
        WaitForPageToLoad wait = new WaitForPageToLoad();
        wait.setTimeToWait(15000);
    }

}

