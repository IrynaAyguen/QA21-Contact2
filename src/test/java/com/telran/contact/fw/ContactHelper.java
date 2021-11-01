package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void addNewContact(Contact contact) {

        //click on tab Add
        click(By.xpath("//a[contains(.,'ADD')]"));
        //fill all fields
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSurName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());

        //click on the Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public Boolean isContactCreated(String text) {
      List<WebElement> contacts = ApplicationManager.driver.findElements(By.xpath("//h3"));
      for (WebElement  el: contacts){
          System.out.println(el.getText());
          if (el.getText().contains(text))
              return true;
      }return false;
    }

    public int sizeOfContacts() {
        if (ApplicationManager.driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            return ApplicationManager.driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else {
            return 0;
        }
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.xpath("//div[@class='contact-item_card__2SOIM']")); // if 1 contact is present
            // click(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'3333333')]"));// if was many contacts
            click(By.xpath("//button[contains(., 'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return ApplicationManager.driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
}
