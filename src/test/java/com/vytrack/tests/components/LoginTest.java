package com.vytrack.tests.components;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {


    WebDriver driver;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }


    @Test
    public void Test1() {
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager244");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);

        WebElement name = driver.findElement(By.cssSelector("#user-menu"));
        String actualName = name.getText();
        String expectedName = "Daniela Lubowitz";
        Assert.assertEquals(actualName, expectedName);

        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Dashboard";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        name.click();
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector("a[href='/user/logout']")).click();
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("salesmanager251");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);


        String actualPageTitle2 = driver.getTitle();
        String expectedPageTitle2 = "Dashboard";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        WebElement name2 = driver.findElement(By.cssSelector(".dropdown-toggle"));
        String actualName2 = name2.getText();
        String expectedName2 = "Elwyn McGlynn";
        Assert.assertEquals(actualName2, expectedName2);
        Assert.assertFalse(actualName2.equals(actualName));


        name2.click();
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector("a[href='/user/logout']")).click();
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("user151");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);


        String actualPageTitle3 = driver.findElement(By.cssSelector(".oro-subtitle")).getText();
        String expectedPageTitle3 = "Quick Launchpad";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        WebElement name3 = driver.findElement(By.cssSelector(".dropdown-toggle"));
        String actualName3 = name3.getText();
        String expectedName3 = "Abdiel Howe";
        Assert.assertEquals(actualName2, expectedName2);
        Assert.assertFalse(actualName3.equals(actualName2));
        Assert.assertFalse(actualName3.equals(actualName));


        name3.click();
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector("a[href='/user/logout']")).click();
        SeleniumUtils.waitPlease(3);


    }


    @Test
    public void test2() {

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager244");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("TigerTiger123");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);

        WebElement name = driver.findElement(By.cssSelector(".alert.alert-error"));
        String actualMsg = name.getText();
        String expectedMsg = "Invalid user name or password.";
        Assert.assertEquals(actualMsg, expectedMsg);

        String title = driver.getTitle();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(title, "Login");
        Assert.assertEquals(URL, "http://qa2.vytrack.com/user/login");

    }


    @AfterMethod
    public void close() {
        SeleniumUtils.waitPlease(5);
        driver.close();
    }


}