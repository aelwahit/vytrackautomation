package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {


    WebDriver driver;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }

//    public void explicitWait(){
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }


    @Test
   public void MenuOptionsDriver() {
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("user165");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        Library.sleep(2);
        //driver.findElement(By.xpath("//*[text()='Vehicles']")).click();
        driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
        driver.findElement(By.cssSelector("span[class='title title-level-2']")).click();
        Library.sleep(2);
        String expected = "Car - Entities - System - Car - Entities - System";
        String actual = driver.getTitle();
        //  Library.verifyEquals(expected,actual);
        Assert.assertEquals(expected, actual);


        Library.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        Library.sleep(2);
        driver.findElement(By.xpath("//*[text()='Accounts']")).click();
        Library.sleep(2);
        String actualAccounts = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String expectedAccounts = "Accounts";
        Assert.assertEquals(expectedAccounts, actualAccounts);
        Library.sleep(2);


        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//*[text()='Contacts']")).click();
        Library.sleep(2);
        String actualContacts = driver.findElement(By.xpath("//h1[text()='Contacts']")).getText();
        String expectedContacts = "Contacts";
        Assert.assertEquals(expectedContacts, actualContacts);
        Library.sleep(2);


        Library.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//*[text()='Calendar Events']")).click();
        Library.sleep(1);
        String actualCalendarEvents = driver.findElement(By.xpath("//h1[text()='Calendar Events']")).getText();
        String expectedCalendarEvents = "Calendar Events";
        Assert.assertEquals(expectedCalendarEvents, actualCalendarEvents);
        Library.sleep(1);

    }

@Test
    public void MenuOptionsStoreManager(){

        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager99");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        Library.sleep(5);

        driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Dashboards')]")).click();
        String actualDashboard = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
        String expectedDashboard = "Dashboard";
         Assert.assertEquals(expectedDashboard,actualDashboard);
         Library.sleep(2);

         driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]")).click();
        Library.sleep(4);
        driver.findElement(By.xpath("//span[text()='Vehicles']")).click();
       Library.sleep(4);
        Assert.assertEquals("Car - Entities - System - Car - Entities - System", driver.getTitle());

    Library.sleep(4);
    driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Customers')]")).click();
    Library.sleep(3);
    driver.findElement(By.xpath("//*[text()='Accounts']")).click();
    Library.sleep(2);
    String actualAccounts = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
    String expectedAccounts = "Accounts";
    Assert.assertEquals(expectedAccounts, actualAccounts);
    Library.sleep(2);












    }




































@AfterMethod
    public void close() {
    Library.sleep(2);
    driver.close();
}


}
