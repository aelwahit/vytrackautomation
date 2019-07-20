package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Library {

    public static void main(String[] args) {

    }


        public static WebDriver ademBrowser(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver2 = new ChromeDriver();
            driver2.manage().window().maximize();
            driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver2.get("http://google.com");
             Library.sleep(1);

            return driver2;


        }











        public static void sleep(double a) {

            try {
                Thread.sleep((long) a * 1000);
            } catch (Exception e) {

            }

        }

        public static void verifyEquals (String expected, String actual){

            if(expected.equals(actual)){
                System.out.println("===================================");
                System.out.println("PASSED");
                System.out.println("Expected is ======   "+expected);
                System.out.println("Actual   is ======   "+actual);
                System.out.println("===================================");
            }else{
                System.out.println("===================================");
                System.out.println("FAILED");
                System.out.println("Expected is ======   "+expected);
                System.out.println("Actual   is ======   "+actual);
                System.out.println("===================================");

            }




        }


    }


