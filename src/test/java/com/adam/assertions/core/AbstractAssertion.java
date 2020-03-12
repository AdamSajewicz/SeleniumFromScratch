package com.adam.assertions.core;

import com.adam.pages.core.CorePage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Enable the separation of the assertions from the Test.
 *
 * @param <T>
 */
public abstract class AbstractAssertion<T extends CorePage> {

    protected T page;
    protected static final Log logger = LogFactory.getLog(AbstractAssertion.class);

    public T endAssertion(){
        return page;
    }

    public void setPage (T page){
        this.page = page;
    }
}
