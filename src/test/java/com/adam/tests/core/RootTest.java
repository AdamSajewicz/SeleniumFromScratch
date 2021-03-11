package com.adam.tests.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class RootTest {
    private WebDriver driver;
    private final Log log = LogFactory.getLog(getClass());
    private static final String GECKO_DRIVER_PATH = "/home/adam/Selenium/geckodriver";
    private static final String CONFIGURATION_PATH = "/home/adam/Selenium/SeleniumFromScratch/src/test/java/com/adam";
    
    protected static TestConfiguration getTestConfig() {
        XmlMapper xmlMapper = new XmlMapper();
        TestConfiguration deserializedData = new TestConfiguration();
        try {
            String readContent = new String(Files.readAllBytes(Paths.get(CONFIGURATION_PATH, "configuration/testconfiguration.xml")));
            deserializedData = xmlMapper.readValue(readContent, TestConfiguration.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deserializedData;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(){
        if(driver != null){
            stopSelenium();
        }
        startSelenium();
        driver.manage().deleteAllCookies();
        maximizeBrowser();
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
