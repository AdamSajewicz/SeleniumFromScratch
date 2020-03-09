package com.adam.tests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class CoreTest {
    protected WebDriver driver;
    private Log log = LogFactory.getLog(getClass());
    private static final String GECKO_DRIVER_PATH = "c:\\geckodriver\\geckodriver.exe";

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(){
        if(driver != null){
            stopSelenium();
        }
        startSelenium();
        driver.manage().deleteAllCookies();
        setupTest();
    }

    public void startSelenium(){
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
            //MDC.put("NodePort", "");
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

}
