package com.telran.contact.tests;

import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        // login not present
        if (!app.getUser().isLoginTabPresent()) {
            // click on Logout button
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(priority=2)
    public void loginRegisteredUserPositiveTest(){
        //click on login tab
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        //Assert user loggedIn
        Assert.assertTrue(app.getUser().isSingOutTabPresent());
    }

    @Test(priority=1)
    public void loginRegisteredUserNegativeWithWrongPasswordTest(){
        //click on login tab
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());

        //fill Login form
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira_"));

        //Assert user loggedIn
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
