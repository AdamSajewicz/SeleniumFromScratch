package com.adam.tests.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class RootTest {
    private WebDriver driver;
    private final Log log = LogFactory.getLog(getClass());
    private static final String GECKO_DRIVER_PATH = "/home/adam/Selenium/geckodriver";

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(){
        if(driver != null){
            stopSelenium();
        }
        startSelenium();
        driver.manage().deleteAllCookies();
        setupTest();
    }

    private void startSelenium(){
        createNewDriverInstance();
    }

    private void createNewDriverInstance(){
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        driver = new FirefoxDriver();
    }

    protected void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    public void stopSelenium() {
        if (driver != null) {
            driver.quit();
            log.info("Killing webdriver instance");
        }
    }

    protected void setupTest() {

    }

    protected void cleanAfterTest(){

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver(){
        cleanAfterTest();
        stopSelenium();
    }
    
    public WebDriver getDriver() {
        return driver;
    }
}
