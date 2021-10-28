package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (!isSingOutTabPresent()){
            clickOnLoginTab();
            login(new User()
                    .setEmail("ira@web.de")
                    .setPassword("Ira123123_"));
        }
    }
    @Test
    public void addContactPositiveTest(){
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return secunds of current time
        addNewContact("Karl", "Adam", "1234567" + i, "adam" + i + "@dm.com", "Koblenz", "torwart");
        //1 variant, if window is small and Save button is not displaied
        //jump();

        // 2 variant, if window is small and Save button is not displaied
        //clickWithAction(".add_form__2rsm2 button");


        //Assert contact created
        Assert.assertTrue(isContactCreated("1234567"));

    }

}
