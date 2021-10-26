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
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            // click on Logout button
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }

    @Test
    public void registrationPositiveTest() {
        // click on Login
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        // fill registration form
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("iryna.a@web.de");

        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Iryna111_");

        // click on regisration button
        driver.findElement(By.xpath("//button[contains(., ' Registration')]")).click();
        // check Logout button displied
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

//    [placeholder='Email']
//    [placeholder='Password']
//    //button[contains(., ' Registration')]

}
