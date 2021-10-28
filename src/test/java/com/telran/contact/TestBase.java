package com.telran.contact;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {

    static WebDriver driver;

    @BeforeSuite

    public void setUp() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2) >div >div")).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isHomeComponentPresent2(){
        try {
            driver.findElement(By.cssSelector("div:nth-child(2) >div >div"));
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isElementPresent2(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
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

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }else{
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void clickWithAction(By save) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(save);
        action.moveToElement(element).build().perform();
        element.click();
    }

    public void pause(int millis){
       new WebDriverWait(driver, Duration.ofSeconds(millis));
    }

    public void jump() {
        driver.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.CONTROL,Keys.ADD);
    }

    public boolean isNoContactsFormPresent() {
        return isElementPresent(By.cssSelector(".contact-page_message__2qafk"));
    }

    public boolean isContactsListFormPresent() {
        return isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke"));
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
        // click on regisration button
        click(By.xpath("//button[contains(., ' Registration')]"));
    }

    public void login(User user) {
        //fill Login form
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());

        type(By.cssSelector("[placeholder='Password']"), user.getPassword());

        //submit Login
        click(By.xpath("//button[contains(., ' Login')]"));
    }

    public void addNewContact(String mane, String surName, String phone, String email, String address, String description) {

        //click on tab Add
        click(By.xpath("//a[contains(.,'ADD')]"));
        //fill all fields
        type(By.cssSelector("[placeholder='Name']"), mane);
        type(By.cssSelector("input:nth-child(2)"), surName);
        type(By.cssSelector("input:nth-child(3)"), phone);
        type(By.cssSelector("input:nth-child(4)"), email);
        type(By.cssSelector("input:nth-child(5)"), address);
        type(By.cssSelector("input:nth-child(6)"), description);

        //click on the Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public Boolean isContactCreated(String text) {
      List<WebElement> contacts = driver.findElements(By.xpath("//h3"));
      for (WebElement  el: contacts){
          System.out.println(el.getText());
          if (el.getText().contains(text))
              return true;
      }return false;
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else {
            return 0;
        }
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.xpath("//div[@class='contact-item_card__2SOIM'] /h3[contains(.,'1111111')]"));
            click(By.xpath("//button[contains(., 'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
}
