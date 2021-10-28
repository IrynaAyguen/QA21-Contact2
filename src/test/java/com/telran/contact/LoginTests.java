package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        // login not present
        if (!isLoginTabPresent()) {
            // click on Logout button
            clickOnSignOutButton();
        }
    }
    @Test(priority=2)
    public void loginRegisteredUserPositiveTest(){
        //click on login tab
        clickOnLoginTab();
        Assert.assertTrue(isLoginRegistrationFormPresent());
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        //Assert user loggedIn
        Assert.assertTrue(isSingOutTabPresent());
    }

    @Test(priority=1)
    public void loginRegisteredUserNegativeWithWrongPasswordTest(){
        //click on login tab
        clickOnLoginTab();
        Assert.assertTrue(isLoginRegistrationFormPresent());

        //fill Login form
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira_"));

        //Assert user loggedIn
        Assert.assertTrue(isAlertPresent());

    }

}
