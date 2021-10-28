package com.telran.contact;

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
            clickOnSignOutButton();
        }
    }

    @Test
    public void registrationPositiveTest() {
//        // click on Login
//        clickOnLoginTab();
//        Assert.assertTrue(isLoginRegistrationFormPresent());
//        createNewAccount(new User()
//                .setEmail("ira@web.de")
//                .setPassword("Ira123123_"));
//        // check Logout button displied
//        Assert.assertTrue(isSingOutTabPresent());
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        // click on Login
        clickOnLoginTab();
        Assert.assertTrue(isLoginRegistrationFormPresent());
        createNewAccount(new User()
                .setEmail("ira@web.de"));
        // check Logout button displied
        Assert.assertTrue(isAlertPresent());
    }

}
