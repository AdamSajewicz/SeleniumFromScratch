package com.adam.assertions.core;

import com.adam.pages.core.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Enable the separation of the assertions from the Test.
 *
 * @param <T>
 */
public abstract class AbstractAssertions<T extends Page> {

    protected T page;
    protected final Log logger = LogFactory.getLog(getClass().getSimpleName());

    public T endAssertion(){
        return page;
    }

    public void setPage (T page){
        this.page = page;
    }
}
