package com.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Day14Deneme02 {

     static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);


    }

    @Test
    public void iframeTest1() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Iframe senmisin?");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void iframeTest3(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void iframeTest4(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        // index ile iframe'e geçiş yapabiliyoruz.
        driver.switchTo().frame(0);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Nasilsin Iframe?");
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     @AfterClass
    public static void tearDown(){
         System.out.println("Masallah bu TEST basarili oldu!");

     }
}
