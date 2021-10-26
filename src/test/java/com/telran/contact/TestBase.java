package com.telran.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
    public void userLogin() {

        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("iryna.a@web.de");
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Iryna111_");
        driver.findElement(By.xpath("//button[contains(., ' Login')]")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
