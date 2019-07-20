package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DenemeBrowser {
    public static void main(String[] args) {


        WebDriver driver = Library.ademBrowser();
        driver.navigate().to("http://amazon.com");
        driver.findElement(By.linkText("Gift Cards")).click();




        Library.sleep(2);
         driver.close();
    }
}
