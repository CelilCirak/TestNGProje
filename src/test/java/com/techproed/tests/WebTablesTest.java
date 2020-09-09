package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {


    public void giris() {
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void table() throws InterruptedException {
        giris();
        Thread.sleep(3000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement w : basliklar) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void tumSatirlar() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w : tumSatirlar) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void tumHucreler() throws InterruptedException {
        giris();

        Thread.sleep(3000);

        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement w : tumHucreler) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void dorduncuSutun() throws InterruptedException {
        giris();

        Thread.sleep(3000);

        List<WebElement> dorduncuSutun = driver.findElements(By.xpath("//tbody//tr/td[4]"));
        for (WebElement w : dorduncuSutun) {
            System.out.println(w.getText());

        }

    }
    @Test
    public void istedigimizHucre() throws InterruptedException {
        giris();

        Thread.sleep(3000);

        List<WebElement> istedigimizHucre = driver.findElements(By.xpath("//tbody/tr[4]/td[6]"));
        for (WebElement w : istedigimizHucre) {
            System.out.println(w.getText());
        }

}
        @Test
        public void calistir(){
        giris();
        hucreYazdir(3,5);
            hucreYazdir(5,6);
            hucreYazdir(2,5);
            hucreYazdir(9,8);
            hucreYazdir(7,3);
            hucreYazdir(6,9);
        }
        public void hucreYazdir(int satir, int sutun){
        // "//tbody/tr[4]/td[6]"
        // "//tbody/tr[satir]/td[sutun]"

        String xpathDegeri = "//tbody/tr["+ satir +"]/td[" + sutun + "]";
        WebElement hucre = driver.findElement(By.xpath((xpathDegeri)));
            System.out.println(hucre.getText());

        }


}