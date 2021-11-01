package com.telran.contact.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase {

    @Test
    public void homePageTest() {
        System.out.println("Site opened");
        //System.out.println("HomeComponent:" + isHomeComponentPresent2());
        //System.out.println("HomeComponent:" + isElementPresent(By.cssSelector("div:nth-child(2) >div >div")));
        System.out.println("HomeComponent:" + app.getHome().isElementPresent2(By.cssSelector("div:nth-child(2) >div >div")));
    }


}
