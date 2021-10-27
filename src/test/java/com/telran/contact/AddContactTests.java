package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (!isSingOutTabPresent()){
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "iryna.a@web.de");
            type(By.cssSelector("[placeholder='Password']"), "Iryna111_");
            click(By.xpath("//button[contains(., ' Login')]"));
        }
    }
    @Test
    public void addContactPositiveTest(){
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // return secunds of current time
        //click on tab Add

        pause(1000);
        //fill all fields
        type(By.cssSelector("[placeholder='Name']"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"12345" + i );
        type(By.cssSelector("input:nth-child(4)"),"adam" + i + "@dm.com");
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        type(By.cssSelector("input:nth-child(6)"),"torwart");

        //click on the Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //1 variant, if window is small and Save button is not displaied
        //jump();

        // 2 variant, if window is small and Save button is not displaied
        //clickWithAction(".add_form__2rsm2 button");


        //Assert contact created

    }

}
