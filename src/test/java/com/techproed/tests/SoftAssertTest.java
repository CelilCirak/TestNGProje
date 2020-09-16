package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*Assert.assertTrue
      Assert.assertFalse
      Assert.assertEquals

      SoftAssert kullaniminin HardAssert kullanimindan farklari:
      1. SofAssert'te eger test basarisiz olursa, kalan kisim calistirilir.
      2. SoftAssert clasindan obje olusturmak zorundayiz.
      Assert=>
      Verify=>

     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void test01(){
        driver.get("http://amazon.com");

        String baslik = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);
        softAssert.assertAll(); // yukarıdaki yaptığımız tüm doğrulamalar
        // başarılı ise testimiz başarılı, değilse
        // testimiz başarısız.
        // HardAssert gibi


    }

    @Test
    public void test02(){
        driver.get("http://a.testaddressbook.com/sign_in");

        SoftAssert softAssert = new SoftAssert();

        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("testtechproed@gmail.com");
        softAssert.assertTrue(email.getText().equals("testtechproed@gmail.com"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertTrue(driver.getTitle().equals("Deneme"));


        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");
        softAssert.assertTrue(sifreKutusu.getText().equals("testtechproed@gmail.com"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        softAssert.assertTrue(driver.getTitle().equals("Address book"));

        WebElement signInLinki = driver.findElement(By.name("commit"));
        signInLinki.click();

        WebElement signOutLinki = driver.findElement(By.partialLinkText("Sign Out"));
        boolean varMi = signOutLinki.isDisplayed();

       softAssert.assertAll();
    }


    @AfterClass
    public void tearDown(){
       driver.quit();

    }
}

