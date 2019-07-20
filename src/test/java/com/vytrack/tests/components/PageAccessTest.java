package com.vytrack.tests.components;


import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        SeleniumUtils.waitPlease(3);
    }


    @Test
    public void storeManagerLogin() {

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager244");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);

        WebElement vehicle = driver.findElements(By.cssSelector(".title.title-level-1")).get(1);
        vehicle.click();
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        SeleniumUtils.waitPlease(3); //This is important otherwise it gets the Dashboard page title


        String contractsPage = driver.getTitle();
        System.out.println(contractsPage);
        String expectedPage = "Vehicle Contract";
        Assert.assertTrue(contractsPage.contains(expectedPage));

    }

    @Test
    public void salesManagerLogin() {

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("salesmanager251");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);

        WebElement vehicle = driver.findElements(By.cssSelector(".title.title-level-1")).get(1);
        vehicle.click();
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        SeleniumUtils.waitPlease(3); //This is important otherwise it gets the Dashboard page title


        String contractsPage = driver.getTitle();
        System.out.println(contractsPage);
        String expectedPage = "Vehicle Contract";
        Assert.assertTrue(contractsPage.contains(expectedPage));

    }


    @Test
    public void driverLogin() {

        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("user151");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        SeleniumUtils.waitPlease(5);

        WebElement vehicle = driver.findElements(By.cssSelector(".title.title-level-1")).get(0);
        vehicle.click();
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        SeleniumUtils.waitPlease(3); //This is important otherwise it gets the Dashboard page title


        String warningMsg = driver.findElement(By.xpath("(//div[@class='message'])[2]")).getText();
        String expectedMsg = "You do not have permission to perform this action.";
        Assert.assertEquals(warningMsg, expectedMsg);

    }


    @AfterMethod
    public void close() {
        SeleniumUtils.waitPlease(5);
        driver.close();
    }


}
