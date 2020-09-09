package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrnekHotelOlusturma extends TestBase {

    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void hotelCreate(){
        WebElement codeKutusu = driver.findElement(By.id("Code"));
        WebElement nameKutusu = driver.findElement(By.id("Ali"));
        WebElement adresKutusu= driver.findElement(By.id("Babiali Yokusu"));
        WebElement phoneKutusu= driver.findElement(By.id("78763452"));
        WebElement emailKutusu= driver.findElement(By.id("ali@gmail"));
        WebElement idGroup     = driver.findElement(By.id("IDGroup"));
        WebElement saveButonu = driver.findElement(By.id("btnSubmit"));

        codeKutusu.sendKeys("553434");
        nameKutusu.sendKeys("Hamza Yılmaz");
        adresKutusu.sendKeys("Çıkmaz Sk. 34/20");
        phoneKutusu.sendKeys("022222222222");
        emailKutusu.sendKeys("merhaba@dunya.com");

        Select select = new Select(idGroup);
        select.selectByIndex(2);
        saveButonu.click();

        // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(basariliYazisi.isDisplayed());
    }
}




