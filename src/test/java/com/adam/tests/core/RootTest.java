package com.adam.tests.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public abstract class RootTest {
    protected final Log logger = LogFactory.getLog(getClass().getSimpleName());
    private static final Log LOG = LogFactory.getLog(RootTest.class);
    
    @Getter
    private WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    private static final String CONFIGURATION_FILE_NAME = "testconfiguration.xml";
    
    protected static final TestConfiguration CONFIG = getTestConfig();
    
    private static TestConfiguration getTestConfig() {
        XmlMapper xmlMapper = new XmlMapper();
        TestConfiguration deserializedTestConfiguration = new TestConfiguration();
        try {
            ClassLoader classLoader = RootTest.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(CONFIGURATION_FILE_NAME)).getFile());
            String readContent = new String(Files.readAllBytes(file.toPath()));
            LOG.info("Reading from the configuration XML ...");
            deserializedTestConfiguration = xmlMapper.readValue(readContent, TestConfiguration.class);
        } catch (JsonMappingException e) {
            LOG.error("Problems with JSON mapings !", e);
            e.printStackTrace();
        } catch(JsonProcessingException e){
            LOG.error("Problems with parsing the XML !", e);
            e.printStackTrace();
        }
        catch(IOException e) {
            LOG.error("Unable to read from the config XML !", e);
            e.printStackTrace();
        }
        LOG.info("Success!");
        return deserializedTestConfiguration;
    }
    
    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(){
        if(driver != null){
            logger.info("Killing the previous webDriver instance ...");
            stopSelenium();
        }
        startSelenium();
        driver.manage().deleteAllCookies();
        maximizeBrowser();
        setupTest();
    }
    
    private void startSelenium(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        if((System.getProperty("driver") != null) && "headless".equals(System.getProperty("driver"))){
            logger.info("Running WebDriver in HEADLESS mode ...");
            options.addArguments("--headless");
        }
        else {
            logger.info("Running Webdriver ...");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }
        driver = new ChromeDriver(options);
        logger.info("WebDriver is up and running ...");
    }
    
    protected void maximizeBrowser(){
        logger.info("Maximize the browser's window ...");
        driver.manage().window().maximize();
    }
    
    protected void stopSelenium() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Method that can be overridden in each test-class to provide some custom setup. 
     * The webdriver is already instantiated, so this setup can use iteraction with elements on a page class. 
     */
    protected void setupTest() {
        
    }
    
    /**
     * Method that can be overridden in each test-class to provide some custom cleanup. 
     * This method can be used to clean some test outcomes/artifacts.
     * The WebDriver is still alive, so in this method you can use iteraction with elements on a Page.
     */
    protected void cleanAfterTest(){
        
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDownDriver(){
        cleanAfterTest();
        logger.info("Killing webdriver instance after test method run ...");
        stopSelenium();
    }
}
