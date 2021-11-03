package com.telran.contact.tests;

import com.telran.contact.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    // precondition: home page should be opened; user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        System.out.println("Site is opened! HomeComponent:" + app.getUser().isElementPresent2(By.cssSelector("div:nth-child(2) >div >div")));

        if (!app.getUser().isLoginTabPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void headerLogoTest() {
        app.getHeader().isLogoPresent();
    }



    @Test
    public void headerTabAboutTest() {
        app.getUser().click(By.xpath("//a[contains(.,'ABOUT')]"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".about_main__2Uv5W")));
    }

    @Test
    public void headerTabHomeTest() {
        app.getUser().click(By.xpath("//a[contains(.,'HOME')]"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("div:nth-child(2) >div >div")));
    }

    @Test
    public void headerTabLoginTest() {
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

    }

    @Test
    public void headerTabAddTest() {
       //user should be logged in
        app.getUser().clickOnLoginTab();
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        app.getUser().click(By.xpath("//a[contains(.,'ADD')]"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".add_form__2rsm2")));
    }

    @Test
    public void headerTabContactsTest() throws InterruptedException {
        //user should be logged in
        app.getUser().clickOnLoginTab();
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        app.getUser().click(By.xpath("//a[contains(.,'CONTACTS')]"));
        Thread.sleep(2000);
        Assert.assertTrue(app.getHeader().isNoContactsFormPresent() || app.getHeader().isContactsListFormPresent());
    }

    @Test
    public void headerTabSignOutTest() {
        //user should be logged in
        app.getUser().clickOnLoginTab();
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        app.getUser().clickOnSignOutButton();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
    }

}