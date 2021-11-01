package com.telran.contact.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends HelperBase{

    public HomeHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return ApplicationManager.driver.findElements(By.cssSelector("div:nth-child(2) >div >div")).size() > 0;
    }

    public boolean isHomeComponentPresent2(){
        try {
            ApplicationManager.driver.findElement(By.cssSelector("div:nth-child(2) >div >div"));
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
