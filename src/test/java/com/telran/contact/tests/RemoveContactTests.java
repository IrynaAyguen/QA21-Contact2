package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isLoginTabPresent()) {
            // click on Logout button
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginTab();
        app.getUser().login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return 4 nubmer
        app.getContact().addNewContact(new Contact().setName("Karl"). setSurName("Adam").setPhone( "1234567"+1).setEmail("adam" + i + "@dm.com"). setAddress("Koblenz").setDescription("torwart"));
    }

    @Test
    public void removeContactTest() throws InterruptedException {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);  //for control
        app.getContact().removeContact();
        Thread.sleep(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);   //for control

        Assert.assertEquals(sizeBefore, sizeAfter + 1);
    }

}

