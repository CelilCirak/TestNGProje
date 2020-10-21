package com.techproed.tests;

import com.techproed.pages.FhcTripLoginNewPage;
import com.techproed.utilities.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {

    @Test (dataProvider = "bilgiler")
    public void loginTest( String user, String password){
        Driver.getDriver().get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        FhcTripLoginNewPage loginNewPage = new FhcTripLoginNewPage();
        loginNewPage.userNameKutusu.sendKeys(user);
        loginNewPage.passwordKutusu.sendKeys(password);
        loginNewPage.loginButonu.click();

    }

    @DataProvider ( name = "bilgiler" )
    public Object[][] getBilgiler(){
        Object[][] array = new Object[3][2]; // 2 boyutlu olduğu için, 2 tane
        array[0][0] = "manage";              // parametre gönderecek
        array[0][1] = "sifre";

        array[1][0] = "manager2";
        array[1][1] = "sifre";

        array[2][0] = "manager2";
        array[2][1] = "Man1ager2!";

        return array;
    }
}
