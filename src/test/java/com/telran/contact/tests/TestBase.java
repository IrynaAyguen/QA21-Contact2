package com.telran.contact.tests;

import com.telran.contact.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()){
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        }else{
            logger.error("FAILED: test method " + result.getMethod().getMethodName()
            + "Screenshot: "+app.getContact().takeScreenshot());
        }
        logger.info("==========================");
    }
}
