package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    //Baska obje olusturulmasini istemedigimiz icin private olarak create ediyoruz.
    private Driver(){

    }
    // WebDriver nesnemizi, static olarak oluşturduk, çünkü program başlar başlamaz
    // hafızada yer almasını istiyoruz.
    //driver instance olusturalim
    static WebDriver driver;
    //driver'i baslatmak icin statik bir metod olusturalim
    public static WebDriver getDriver(){
        //Eger driver nesnesi hafizada bossa, olusturulmamissa yeniden olusturmana gerek yok.
        // Eger null ise, yeniden olusturabilirsin.
        if(driver==null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){  //eger driver chrome'u isaret ediyorsa
            driver.quit();  // driver'i kapat
            driver = null; // driver'in null oldugundan emin olmak icin tekrar null olarak atayalim.
        }               //Boylelikle driver'i tekrar baslatabilirim.
    }                   //Multi Browser Test(chrome, firefox, ie ...) yaparken bu onemli olacaktir.
}

