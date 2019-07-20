package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Deneme2 {

     WebDriver driver;
    @Test
    public  void main(String[] args) {
     WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("[name='_username']")).sendKeys("storemanager99");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("[name='_submit']")).click();
        Library.sleep(5);
         WebElement mouse=  driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Dashboards')]"));
      //  Actions mousetrack = new Actions(mouse);

        String actualDashboard = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
        String expectedDashboard = "Dashboard";
        Assert.assertEquals(expectedDashboard, actualDashboard);
        Library.sleep(2);

        driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]")).click();
        Library.sleep(4);
        driver.findElement(By.xpath("//span[text()='Vehicles']")).click();
    }
}