package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButon = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButon.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));

        Assert.assertTrue(element.isDisplayed());

    }
    @Test
    public void explicitWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //ExplicitWait kullanmak icin, WebDriverWait class'indan obje uretmek gerekiyor.
        WebDriverWait wait = new WebDriverWait(driver, 30); //max 30


        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

//         <p id"message">It's gone!</p>
//        WebElement message = driver.findElement(By.id("message"));
//        System.out.println(message.getText());



    }

}
