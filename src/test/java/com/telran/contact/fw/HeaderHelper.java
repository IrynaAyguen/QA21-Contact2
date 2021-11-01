package com.telran.contact.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{

    public HeaderHelper(WebDriver driver) {
        super (driver);
    }

    public void isLogoPresent() {
        driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }

    public boolean isNoContactsFormPresent() {
        return isElementPresent(By.cssSelector(".contact-page_message__2qafk"));
    }

    public boolean isContactsListFormPresent() {
        return isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke"));
    }
}
