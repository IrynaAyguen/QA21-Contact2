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

        if (!isLoginTabPresent()) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void headerLogoTest() {
        driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }

    @Test
    public void headerTabAboutTest() {
        click(By.xpath("//a[contains(.,'ABOUT')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".about_main__2Uv5W")));
    }

    @Test
    public void headerTabHomeTest() {
        click(By.xpath("//a[contains(.,'HOME')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div:nth-child(2) >div >div")));
    }

    @Test
    public void headerTabLoginTest() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

    }

    @Test
    public void headerTabAddTest() {
        userLogin();  //user should be logged in
        click(By.xpath("//a[contains(.,'ADD')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".add_form__2rsm2")));
    }

    @Test
    public void headerTabContactsTest() {
        userLogin();   //user should be logged in
        click(By.xpath("//a[contains(.,'CONTACTS')]"));
        Assert.assertTrue(isNoContactsFormPresent());
    }

    @Test
    public void headerTabSignOutTest() {
        userLogin();   //user should be logged in
        click(By.xpath("//button[contains(.,'Sign Out')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
    }

}