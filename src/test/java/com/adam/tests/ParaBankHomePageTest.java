package com.adam.tests;

import com.adam.pages.ParaBankLoginPage;
import com.adam.tests.core.RootTest;
import org.testng.annotations.Test;

public class ParaBankHomePageTest extends RootTest {

    @Test
    public void loadParaBankHomePage(){
        new ParaBankLoginPage(getDriver(), CONFIG.getParaBankHome());
    }
}
