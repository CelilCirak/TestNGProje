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

public class Otel2 extends TestBase {
    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);


    }
    @Test
    public void otel(){
        WebElement code = driver.findElement(By.id("Code"));
        code.sendKeys("hello");
        WebElement name = driver.findElement(By.id("Name"));
        name.sendKeys("Cabbar");
        WebElement address = driver.findElement(By.id("Address"));
        address.sendKeys("Karga sekmez kavsagi. Kizilcahamam");
        WebElement phone = driver.findElement(By.id("Phone"));
        phone.sendKeys("+141256488976");
        WebElement mail = driver.findElement(By.id("Email"));
        mail.sendKeys("cabbar@gmail.com");
        WebElement idGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(idGroup);
        select.selectByIndex(2);
        WebElement save = driver.findElement(By.id("btnSubmit"));
        save.click();


        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement successfuly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(successfuly.isDisplayed());


    }

}
