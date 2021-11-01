package com.telran.contact.tests;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase {

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
        app.getContact().addNewContact(new Contact().setName("Karl"). setSurName("Adam").setPhone( "2222222").setEmail("adam" + i + "@dm.com"). setAddress("Koblenz").setDescription("torwart"));

    }


    @Test
    public void deleteContact() throws InterruptedException {

        app.getUser().click(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]"));

        app.getUser().click(By.xpath("//button[contains(., 'Remove')]"));

        //Assert.assertTrue(isNoContactsFormPresent() || isContactsListFormPresent());

// from Book - wait
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'1234567')]")));

        Thread.sleep(2000);  //Thread.sleep-  from teacher Iryna

        // print of result
        if (app.getUser().isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]"))) {
            System.out.println("Contact is not deleted");
        }else{
            System.out.println("Contact is deleted");
        }
        Assert.assertTrue(!app.getUser().isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]")));
    }
}