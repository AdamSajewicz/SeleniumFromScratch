package com.adam.pages.core;

import com.adam.assertions.core.AbstractAssertions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

public class PageSupportAssertions extends Page {
    
    protected final Log logger = LogFactory.getLog(getClass().getSimpleName());
    
    protected PageSupportAssertions(WebDriver driver, String url) {
        super(driver, url);
    }
    
    protected PageSupportAssertions(WebDriver driver){
        super(driver, null);
    }
    
    /**
     * Enables switching between Test class and the Assertion class.
     * Within the Assertion class, we can use all the available methods defined within the referenced page class G
     *
     * @param assertionClazz - Name of the assertionClass, which contains assertions related to the elements on Page class G
     * @param <G> - Represents the Page class, on which the assertions will operate
     * @param <T> - Represents the Class which actually be returned
     * @return - an instance of the Assertion class, which will have access to the elements from the page G
     */
    @SuppressWarnings("unchecked")
    public <G extends Page, T extends AbstractAssertions<G>> T check(Class<T> assertionClazz) {
        T assertion = null;
        try{
            logger.info("Switching to the assertion class for: " + assertionClazz.getSimpleName() + " ...");
            assertion = assertionClazz.newInstance();
            assertion.setPage((G) this);
        }
        catch(InstantiationException e) {
            logger.error("Instantiation Exception! ", e);
        }
        catch(IllegalAccessException e) {
            logger.error("IllegalAccess Exception! ", e);
        }
        logger.info("Success!");
        return assertion;
    }
    
    /**
     * Method to wait for page document to have ready state.
     */
    public void waitForPageToLoad() {
        getWait().until(driver -> ("complete".equals(String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")))));
    }
    
    /**
     * Waiting 30 seconds for an element to be present on the page, checking
     * for its presence once every 5 seconds.
     */
    private Wait<WebDriver> fluentWait = new FluentWait<>(getDriver())
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
    
    /**
     * This is a tricky method. 
     * It's using the fluentWait object to wait until the 'condition' to be fulfilled. But is does the wait the way
     * the fluentWait does it. So refreshing the page a couple of times, and after each refresh it check the 'condition'.
     *
     * The usage of this method is for instance as follows:
     * >>>>> refreshPageWaitingForCondition(() -> button.isDisplayed())
     * In this case, the method will refresh the page several times, until the button will become visible (so displayed).
     *
     * @param condition - a condition of type Boolean to be fulfilled
     */
    public void refreshPageWaitingForCondition(Callable<Boolean> condition){
        fluentWait.until(driver -> {
            try {
                driver.navigate().refresh();
                waitForPageToLoad();
                return condition.call();
            }
            catch(StaleElementReferenceException e) {
                logger.error("Element no longer in DOM: ", e);
            }
            catch(NoSuchElementException e){
                logger.error("Unable to localize the element: ", e);
            }
            catch(Exception e){
                logger.error("Exception when checking the condition: ", e);
            }
            return false;
        });
        logger.info("Successfully got the searched WebElement");
    }
}
