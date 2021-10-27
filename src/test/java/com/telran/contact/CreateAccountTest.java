package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        // login not present
        if (!isLoginTabPresent()) {
            // click on Logout button
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void registrationPositiveTest() {
        // click on Login
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        Assert.assertTrue(isLoginRegistrationFormPresent());
        // fill registration form
        type(By.cssSelector("[placeholder='Email']"), "iryna.a@web.de");
        type(By.cssSelector("[placeholder='Password']"), "Iryna111_");

        // click on regisration button
        click(By.xpath("//button[contains(., ' Registration')]"));
        // check Logout button displied
        Assert.assertTrue(isSingOutTabPresent());
    }


}
