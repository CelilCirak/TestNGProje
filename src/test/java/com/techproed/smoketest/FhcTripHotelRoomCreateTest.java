package com.techproed.smoketest;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripHotelRoomCreateTest extends TestBase {

    public void giris(){
        driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }

    @Test
    public void test01(){
        driver.get(ConfigurationReader.getProperty("room_create_url"));

        giris();

        FhcTripHotelRoomCreatePage page = new FhcTripHotelRoomCreatePage(driver);

        Select select = new Select(page.idHotelDropDown);
        select.selectByIndex(3);

        page.codeKutusu.sendKeys("1234");
        page.nameKutusu.sendKeys("Celil Cirak");
        page.locationKutusu.sendKeys("Amerika");
        page.dscKutusu.sendKeys("Day 20'den Selamlar");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(page.price500, page.priceKutusu).perform();
        Select select1 = new Select(page.roomTypeDropDown);
        select1.selectByIndex(2);

        page.maxAdultCnt.sendKeys("2");
        page.maxChildCnt.sendKeys("5");
        page.saveButonu.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(page.basariliYazisi.getText());

        boolean basariliMi = page.basariliYazisi.isDisplayed();
        Assert.assertTrue(basariliMi);



    }



}
