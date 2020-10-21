package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforMethod calisti.");
    }

    @Test (dataProvider = "urunler")
    public void amazonAramaTesti(String string){
        Driver.getDriver().get("http://amazon.com");

        AmazonNewPage amazonNewPage = new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys(string + Keys.ENTER);

    }

    @DataProvider( name = "urunler")
    public Object[] getUrunler() {
        Object[] urunler = new Object[8];
        urunler[0] = "java";
        urunler[1] = "selenium";
        urunler[2] = "mouse";
        urunler[3] = "keyboard";
        urunler[4] = "laptop";
        urunler[5] = "usb flash drive";
        urunler[6] = "imac";
        urunler[7] = "sticky notes";

        return urunler;


    }
}
