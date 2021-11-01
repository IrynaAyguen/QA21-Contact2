package com.telran.contact.fw;

import com.telran.contact.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginTabPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isSingOutTabPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginRegistrationFormPresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginTab() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void createNewAccount(User user) {
        // fill registration form
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
        // click on registration button
        click(By.xpath("//button[contains(., ' Registration')]"));
    }

    public void login(User user) {
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());

        type(By.cssSelector("[placeholder='Password']"), user.getPassword());

        //submit Login
        click(By.xpath("//button[contains(., ' Login')]"));
    }
}
