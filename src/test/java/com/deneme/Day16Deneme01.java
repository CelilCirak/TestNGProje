package com.deneme;

import com.deneme.motor.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Day16Deneme01 extends MainClass {

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Computers");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("macbook air" + Keys.ENTER);

        WebElement brandApple = driver.findElement(By.xpath("//*[.='a-icon a-icon-checkbox']"));
        brandApple.click();
        Thread.sleep(5000);

        WebElement ram = driver.findElement(By.xpath("//span[@dir='16 GB']"));
        ram.click();
        Thread.sleep(4000);

        WebElement miniBox = driver.findElement(By.id("low-price"));
        miniBox.sendKeys("1200");

        WebElement maxBox = driver.findElement(By.id("high-price"));
        maxBox.sendKeys("1800");
        maxBox.submit();
        Thread.sleep(5000);

        List<WebElement> result = driver.findElements(By.xpath("//span[@dir='auto']"));
        for (WebElement w : result) {
            System.out.println(w.getText());
        }


    }
}
