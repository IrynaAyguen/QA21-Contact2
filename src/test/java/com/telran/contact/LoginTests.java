package com.telran.contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        // login not present
        if (!isLoginTabPresent()) {
            // click on Logout button
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }
    @Test
    public void loginRegisteredUserPositiveTest(){
        //click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "iryna.a@web.de");

        type(By.cssSelector("[placeholder='Password']"), "Iryna111_");

        //submit Login
        click(By.xpath("//button[contains(., ' Login')]"));

        //Assert user loggedIn
        Assert.assertTrue(isSingOutTabPresent());
    }

    @Test
    public void loginRegisteredUserNegativeWithWrongPasswordTest(){
        //click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());

        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), "iryna.a@web.de");

        type(By.cssSelector("[placeholder='Password']"), "iryna111");

        //submit Login
        click(By.xpath("//button[contains(., ' Login')]"));

        //Assert user loggedIn
        Assert.assertTrue(isAlertPresent());

    }

}
