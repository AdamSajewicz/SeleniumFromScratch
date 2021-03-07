package com.adam.pages.core;

//import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Initializer of a page. Uses the AjaxElementLocatorFactory for lazy initialization of elements.
     * WebElements are initialized only when needed.
     *
     * @param driver
     * @param url
     */
    protected Page(WebDriver driver, String url){
        this.driver = driver;
        //AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 10);
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 5);
    }

//    public void waitForPageToLoad(){
//        WaitForPageToLoad wait = new WaitForPageToLoad();
//        wait.setTimeToWait(15000);
//    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public WebDriverWait getWait() {
        return wait;
    }
}

