package com.telran.contact.tests;

import com.telran.contact.fw.DataProviders;
import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddContactTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getUser().isSingOutTabPresent()) {
            app.getUser().clickOnLoginTab();
            app.getUser().login(new User()
                    .setEmail("ira@web.de")
                    .setPassword("Ira123123_"));
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return secunds of current time
        app.getContact().addNewContact(new Contact().setName("Karl").setSurName("Adam").setPhone("5555555").setEmail("adam" + i + "@dm.com").setAddress("Koblenz").setDescription("torwart"));
        // phone and email should be U N I Q U E ! ! ! ! ! ! ! ! !

        //Assert contact created
        Assert.assertTrue(app.getContact().isContactCreated("5555555"));
        app.getContact().removeContact(); //delete of new contact
        //1 variant, if window is small and Save button is not displaied
        //jump();

        // 2 variant, if window is small and Save button is not displaied
        //clickWithAction(".add_form__2rsm2 button");
    }

    @Test(dataProvider = "newContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String sName, String ph, String email, String address, String des) throws InterruptedException {

        app.getContact().addNewContact(new Contact().setName(name).setSurName(sName).setPhone(ph)
                .setEmail(email).setAddress(address).setDescription(des));

        app.getContact().removeContact();  //delete
        Thread.sleep(2000);
    }

    @Test(dataProvider = "newContactFromCSV",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromCSVTest(Contact contact) throws InterruptedException {

        app.getContact().addNewContact(contact);

        app.getContact().removeContact();  //delete
        Thread.sleep(2000);
    }

}
