package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

  public class JSAlertTest {

      private WebDriver driver;

      @BeforeClass
      public void setUp() {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

      }

      @Test()
      public void jsAlertTest() {
          driver.get("https://the-internet.herokuapp.com/javascript_alerts");

          // <button onclick="jsAlert()">Click for JS Alert</button>
          // xpath, cssSelector, tagName,
          WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
          button.click();

          // Alert'in icerdigi mesaji almalk icin .getText() kullaniriz.
          String alertMesaji = driver.switchTo().alert().getText();
          System.out.println(alertMesaji);

          //alert butonuna tiklamak icin.
          driver.switchTo().alert().accept();

      }

      @Test()
      public void jsAConfirmTest() {
          driver.get("https://the-internet.herokuapp.com/javascript_alerts");
          WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
          button.click();

          // Alert'in icerdigi mesaji almalk icin .getText() kullaniriz.
          String alertMesaji = driver.switchTo().alert().getText();
          System.out.println(alertMesaji);

          //alert butonuna tiklamak icin.
          driver.switchTo().alert().accept();

        //  String mesaj = driver.switchTo().alert().getText();
        //  System.out.println(mesaj);

          // alert icindeki cancel butonuna tiklar.
        //  driver.switchTo().alert().dismiss();

      }

      @Test()
      public void jsAPromptTest() {
          driver.get("https://the-internet.herokuapp.com/javascript_alerts");
          WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
          button.click();

          // Alert'in icerdigi mesaji almalk icin .getText() kullaniriz.
          String mesaj = driver.switchTo().alert().getText();
          System.out.println(mesaj);

          //alert prompt a mesaj gondermek icin.
          driver.switchTo().alert().sendKeys("Merhaba TestNG");

          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          driver.switchTo().alert().accept();

          //  String mesaj = driver.switchTo().alert().getText();
          //  System.out.println(mesaj);

          // alert icindeki cancel butonuna tiklar.
          // driver.switchTo().alert().dismiss();

      }

  }