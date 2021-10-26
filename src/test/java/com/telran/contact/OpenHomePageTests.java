package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenHomePageTests extends TestBase{

    @Test
    public void homePageTest() {
        System.out.println("Site opened");
        //System.out.println("HomeComponent:" + isHomeComponentPresent2());
        //System.out.println("HomeComponent:" + isElementPresent(By.cssSelector("div:nth-child(2) >div >div")));
        System.out.println("HomeComponent:" + isElementPresent2(By.cssSelector("div:nth-child(2) >div >div")));
    }


}
