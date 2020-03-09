package com.adam.pages;

import com.adam.assertions.AbstractAssertion;
import org.openqa.selenium.WebDriver;

public class PageSupportAssertion extends CorePage {

    protected PageSupportAssertion(WebDriver driver, String url) {
        super(driver, url);
    }

    protected PageSupportAssertion(WebDriver driver){
        super(driver, null);
    }

    public <G extends CorePage, T extends AbstractAssertion<G>> T check(Class<T> clazz) throws RuntimeException {
        AbstractAssertion<G> assertion = null;
        try{
           assertion = clazz.newInstance();
            assertion.setPage((G) this);
            
        } catch(InstantiationException e) {
            System.out.println("Instantiation" + e);
        } catch(IllegalAccessException e) {
            System.out.println("IllegalAccess" + e);
        }

        return (T) assertion;
    }
}
