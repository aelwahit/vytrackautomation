package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {



        WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }
    @Test
    public void Test1(){
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("user165");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        Library.sleep(5);
       //driver.findElement(By.xpath("//*[text()='Vehicles']")).click();
        driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
       driver.findElement(By.cssSelector("span[class='title title-level-2']")).click();
        Library.sleep(2);
       String expected="Car - Entities - System - Car - Entities - System";
       String actual=driver.getTitle();
       Library.verifyEquals(expected,actual);

       Library.sleep(3);
       driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
       driver.findElement(By.xpath("//*[text()='Accounts']")).click();

       Library.sleep(2);
        System.out.println("=============");
        System.out.println( driver.getTitle());
        System.out.println(  driver.getTitle().contains("Accounts")? "PASSED":"FAILED"   );
        System.out.println("=============");


        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//*[text()='Contacts']")).click();
        Library.sleep(2);
        System.out.println("=============");
        System.out.println( driver.getTitle());
        System.out.println(  driver.getTitle().contains("Contacts")? "PASSED":"FAILED"   );
        System.out.println("=============");

Library.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//*[text()='Calendar Events']")).click();
        Library.sleep(2);
        System.out.println("=============");
        System.out.println( driver.getTitle());
        System.out.println(  driver.getTitle().contains("Calendar Events")? "PASSED":"FAILED"   );
        System.out.println("=============");





    }
@AfterClass
    public void close(){
    Library.sleep(2);
        driver.close();
}


}
