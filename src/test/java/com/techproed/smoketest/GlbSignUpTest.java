package com.techproed.smoketest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GlbSignUpTest {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glblogin"));
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();

        glbSignUpPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("glbemail"));
        glbSignUpPage.nameKutusu.sendKeys(ConfigurationReader.getProperty("glbname"));
        glbSignUpPage.mobileKutusu.sendKeys(ConfigurationReader.getProperty("glbmobile"));
        glbSignUpPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("glbpsw"));
        glbSignUpPage.rePasswordKutusu.sendKeys(ConfigurationReader.getProperty("glbrpsw"));
        glbSignUpPage.signUpButonu.click();

        System.out.println(glbSignUpPage.successKutusu.getText());

        boolean dogruMu = glbSignUpPage.successKutusu.getText().contains("Success");
        Assert.assertTrue(dogruMu);
    }

    @AfterClass
    public void tearDown(){
       // Driver.closeDriver();

    }
}





