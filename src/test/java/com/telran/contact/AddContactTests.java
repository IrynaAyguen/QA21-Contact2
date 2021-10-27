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
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600; // vozvrashaet tekushee vremy v sekundach
        //click on tab Add
        click(By.cssSelector("a:nth-child(5)"));
        pause(1000);
        //fill all fields
        type(By.cssSelector("[placeholder='Name']"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"12345" + i );
        type(By.cssSelector("input:nth-child(4)"),"adam" + i + "@dm.com");
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        type(By.cssSelector("input:nth-child(6)"),"torwart");

        //click on the Save button
        //jump(); //1 variant, esli ekran malenki i knopka save ne najalasy

        // 2 variant, esli ekran malenki i knopka save ne najalasy
        //clickWithAction();

        click(By.cssSelector(".add_form__2rsm2 button"));

        //Assert contact created

    }

    public void jump() {
        driver.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.CONTROL,Keys.ADD);
    }

}
//  input:nth-child(1)