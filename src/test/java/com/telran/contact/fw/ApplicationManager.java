package com.telran.contact.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    static WebDriver driver;


    UserHelper user;  // declaration of helpers
    ContactHelper contact;
    HomeHelper home;
    HeaderHelper header;

    public UserHelper getUser() {  //initialisation of Helpers
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomeHelper getHome() {
        return home;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        user= new UserHelper(driver); // difination of helpers
        contact = new ContactHelper(driver);
        home = new HomeHelper(driver);
        header = new HeaderHelper(driver);
    }

    public void stop() {
        driver.quit();
    }



}
