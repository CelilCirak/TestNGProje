package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

    public void giris() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void test() {
        giris();

        FhcTripHotelCreatePage fhcTripHotelCreatePage = new FhcTripHotelCreatePage(driver);
        fhcTripHotelCreatePage.codeKutusu.sendKeys("12345");
        fhcTripHotelCreatePage.nameKutusu.sendKeys("Berkay");
        fhcTripHotelCreatePage.addressKutusu.sendKeys("Kara Duvar Yolu");
        fhcTripHotelCreatePage.phoneKutusu.sendKeys("423637837");
        fhcTripHotelCreatePage.emailKutusu.sendKeys("ali@gmail.com");
        
        Select select = new Select(fhcTripHotelCreatePage.selectKutusu);
        select.selectByIndex(2);
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());
        fhcTripHotelCreatePage.saveKutusu.click();



    }

}