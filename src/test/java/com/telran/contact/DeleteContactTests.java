package com.telran.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        // log in
        if (!isSingOutTabPresent()) {
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "iryna.a@web.de");
            type(By.cssSelector("[placeholder='Password']"), "Iryna111_");
            click(By.xpath("//button[contains(., ' Login')]"));
        }
        // add a contact
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return 4 nubmer
        click(By.cssSelector("a:nth-child(5)"));
        pause(1000);
        type(By.cssSelector("[placeholder='Name']"), "Iryna");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        //type(By.cssSelector("input:nth-child(3)"), "+49-0175-852-" + i);
        type(By.cssSelector("input:nth-child(3)"), "+49-0111-111-1112");
        //System.out.println("new contact has telephon number: " + "+49-0175-852-" + i); //print for control
        type(By.cssSelector("input:nth-child(4)"), "adam" + i + "@dm.com");
        type(By.cssSelector("input:nth-child(5)"), "Koblenz");
        type(By.cssSelector("input:nth-child(6)"), "QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void deleteContact() {
        click(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'+49-0111-111-1112')]"));

        click(By.xpath("//button[contains(., 'Remove')]"));
        //Assert.assertTrue(isNoContactsFormPresent());         // if no contacts more
        //Assert.assertTrue(isContactsListFormPresent());     // if other contacts present
        pause(9000);
        //Assert.assertTrue(isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'+49-0111-111-1112')]")));     // if other contacts present

        if (isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'+49-0111-111-1112')]"))) {
            System.out.println("Contact is not deleted");
        }else{
            System.out.println("Contact is deleted");
        }
    }
}