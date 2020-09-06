package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrnekAmazonKayitSayfasi extends TestBase {

    //Day14


    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement button = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();
        WebElement startHere = driver.findElement(By.partialLinkText("Start here."));
        startHere.click();

        String title=driver.getTitle();
        Assert.assertEquals("Amazon Registration",title);

        // String sayfaTitle = driver.getTitle();
       // System.out.println(sayfaTitle);
       // Assert.assertEquals("Amazon Registration", sayfaTitle);
    }

    @Test(dependsOnMethods = "test")

    public void test02(){
        WebElement isim = driver.findElement(By.id("ap_customer_name"));
        isim.sendKeys("Hamza Yılmaz");
        driver.findElement(By.id("ap_email")).sendKeys("hamzayilmaz2020@protonmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Amazon06.");
        driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06.");
        driver.findElement(By.id("continue")).click();


    }

    }
