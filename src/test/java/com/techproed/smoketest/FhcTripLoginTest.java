package com.techproed.smoketest;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    @Test
    public void girisTesti(){
        driver.get(ConfigurationReader.getProperty("fhclogin"));
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userKutusu.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.login.click();

    }





}
