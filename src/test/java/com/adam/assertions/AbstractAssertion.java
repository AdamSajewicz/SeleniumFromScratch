package com.adam.assertions;

import com.adam.pages.CorePage;
import com.lumesse.tlk.assertion.AbstractAssertions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public abstract class AbstractAssertion<T extends CorePage> {
    protected T page;
    protected static final Log logger = LogFactory.getLog(AbstractAssertions.class);
    public T endAssertion(){
        return page;
    }
    public void setPage (T page){
        this.page = page;
    }
}
