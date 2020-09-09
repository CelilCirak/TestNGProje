package com.deneme;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class Day14Deneme01 {

     @BeforeClass
    public static void setUp() {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
     }

    static WebDriver driver ;
    @Test
    public void softwareGo() {

        driver.get("http://amazon.com");

        WebElement menu = driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));
        menu.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement computer = driver.findElement(By.xpath("//a[@data-menu-id='14']"));
        computer.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement software = driver.findElement(By.partialLinkText("Software"));
        software.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement miniBox = driver.findElement(By.id("low-price"));
        miniBox.sendKeys("10");

        WebElement maxBox = driver.findElement(By.id("high-price"));
        maxBox.sendKeys("20");
        maxBox.submit();


            System.out.println(driver.getCurrentUrl());

        }
    }



    
