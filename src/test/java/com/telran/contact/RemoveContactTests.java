package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginTabPresent()) {
            // click on Logout button
            clickOnSignOutButton();
        }
        clickOnLoginTab();
        login(new User()
                .setEmail("ira@web.de")
                .setPassword("Ira123123_"));

        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return 4 nubmer
        addNewContact("Karl", "Adam", "3333333", "adam" + i + "@dm.com", "Koblenz", "torwart");
    }

    @Test
    public void removeContactTest() throws InterruptedException {
        int sizeBefore = sizeOfContacts();
        System.out.println(sizeBefore);  //for control
        removeContact();
        Thread.sleep(1000);
        int sizeAfter = sizeOfContacts();
        System.out.println(sizeAfter);   //for control

        Assert.assertEquals(sizeBefore, sizeAfter + 1);
    }

}

