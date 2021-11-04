package com.telran.contact.tests;

import com.telran.contact.fw.DataProviders;
import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        // login not present
        if (!app.getUser().isLoginTabPresent()) {
            // click on Logout button
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test ()
    public void registrationPositiveTest() {
        // click on Login
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        app.getUser().createNewAccount(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));
        // check Logout button displied
        Assert.assertTrue(app.getUser().isSingOutTabPresent());
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        // click on Login
        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        app.getUser().createNewAccount(new User()
                .setEmail("ira@web.de"));
        // check Logout button displied
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test(dataProvider = "registrationNegativeTestFromCSV",dataProviderClass = DataProviders.class)
    public void registrationNegativeFromCSVTest(User user)  {

        app.getUser().clickOnLoginTab();
        Assert.assertTrue(app.getUser().isLoginRegistrationFormPresent());
        app.getUser().createNewAccount(user);
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
