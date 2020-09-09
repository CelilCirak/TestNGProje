package com.deneme;

import com.deneme.motor.MainClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Day15Deneme01 extends MainClass {


    @Test
    public void test1() throws InterruptedException {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("orhan pamuk beyaz kale" + Keys.ENTER);

        WebElement beyazKale = driver.findElement(By.partialLinkText("Beyaz"));
        beyazKale.click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("beyaz"));
        System.out.println("Test PASSED");

    }
}
