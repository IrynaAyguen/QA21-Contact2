package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    // precondition: home page should be opened; user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        System.out.println("Site is opened! HomeComponent:" + isElementPresent2(By.cssSelector("div:nth-child(2) >div >div")));

        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void headerLogoTest() {
        driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }

    @Test
    public void headerTabAboutTest() {
        driver.findElement(By.xpath("//a[contains(.,'ABOUT')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".about_main__2Uv5W")));
    }

    @Test
    public void headerTabHomeTest() {
        driver.findElement(By.xpath("//a[contains(.,'HOME')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("div:nth-child(2) >div >div")));
    }

    @Test
    public void headerTabLoginTest() {
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));

    }

    @Test
    public void headerTabAddTest() {
        userLogin();  //user should be logged in
        driver.findElement(By.xpath("//a[contains(.,'ADD')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".add_form__2rsm2")));
    }

    @Test
    public void headerTabContactsTest() {
        userLogin();   //user should be logged in
        driver.findElement(By.xpath("//a[contains(.,'CONTACTS')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".contact-page_message__2qafk")));
    }

    @Test
    public void headerTabSignOutTest() {
        userLogin();   //user should be logged in
        driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
    }

}