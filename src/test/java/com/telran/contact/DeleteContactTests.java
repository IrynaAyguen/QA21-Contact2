package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DeleteContactTests extends TestBase {

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
        addNewContact("Karl", "Adam", "2222222", "adam" + i + "@dm.com", "Koblenz", "torwart");

    }


    @Test
    public void deleteContact() throws InterruptedException {
        click(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]"));

        click(By.xpath("//button[contains(., 'Remove')]"));
        //Assert.assertTrue(isNoContactsFormPresent() || isContactsListFormPresent());

// from Book - wait
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'1234567')]")));

        Thread.sleep(2000);  //Thread.sleep-  from teacher Iryna

        // print of result
        if (isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]"))) {
            System.out.println("Contact is not deleted");
        }else{
            System.out.println("Contact is deleted");
        }
        Assert.assertTrue(!isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'2222222')]")));
    }
}