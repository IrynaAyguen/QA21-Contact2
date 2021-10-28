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
            clickOnSignOutButton();
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
        clickOnLoginTab();
        Assert.assertTrue(isLoginRegistrationFormPresent());

    }

    @Test
    public void headerTabAddTest() {
       //user should be logged in
        clickOnLoginTab();
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        click(By.xpath("//a[contains(.,'ADD')]"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".add_form__2rsm2")));
    }

    @Test
    public void headerTabContactsTest() throws InterruptedException {
        //user should be logged in
        clickOnLoginTab();
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        click(By.xpath("//a[contains(.,'CONTACTS')]"));
        Thread.sleep(2000);
        Assert.assertTrue(isNoContactsFormPresent() || isContactsListFormPresent());
    }

    @Test
    public void headerTabSignOutTest() {
        //user should be logged in
        clickOnLoginTab();
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        clickOnSignOutButton();
        Assert.assertTrue(isLoginRegistrationFormPresent());
    }

}