package com.adam.pages.core;

import com.adam.assertions.core.AbstractAssertion;
import org.openqa.selenium.WebDriver;

public class PageSupportAssertion extends Page {

    protected PageSupportAssertion(WebDriver driver, String url) {
        super(driver, url);
    }

    protected PageSupportAssertion(WebDriver driver){
        super(driver, null);
    }

    /**
     * Enables switching between Test class and the Assertion class.
     * Within the Assertion class, we can use all the available methods defined within the referenced page class G
     *
     * @param clazz
     * @param <G>
     * @param <T>
     * @return
     */
    public <G extends Page, T extends AbstractAssertion<G>> T check(Class<T> clazz) {
        AbstractAssertion<G> assertion = null;
        try{
           assertion = clazz.newInstance();
            assertion.setPage((G) this);
            
        } catch(InstantiationException e) {
            System.out.println("Instantiation Exception! " + e);
        } catch(IllegalAccessException e) {
            System.out.println("IllegalAccess Exception! " + e);
        }

        return (T) assertion;
    }
}
