package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownLoadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        String  pomXmlDosyasi = kullaniciDosyaYolu + "/pom.xml";
        //DIKKAT Burasi bir Kalip
        boolean varMi = Files.exists((Paths.get(pomXmlDosyasi)));
        Assert.assertTrue(varMi);
        //System.out.println(varMi);
    }
    @Test
    public void dosyaUpLoad(){
        //https://files.slack.com/files-pri/T0155GBAPT2-F01ALJT9TS5/logo.png/
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));
        dosyaSecmeButonu.sendKeys("/Users/cc/Documents/logo.png");

        WebElement upLoadButonu = driver.findElement(By.id("file-submit"));
        upLoadButonu.click();
        WebElement fileUploadYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazisi.isDisplayed());
        }
    @Test
    public void  dosyaDownload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement anmsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        anmsterdamLinki.click();
        Thread.sleep(3000);

        boolean varMi = Files.exists(Paths.get("/Users/cc/Downloads"));
        Assert.assertTrue(varMi);


    }
    }



