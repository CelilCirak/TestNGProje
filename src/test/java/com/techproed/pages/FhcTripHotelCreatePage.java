package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {

    /* http://fhctrip-qa.com/admin/HotelAdmin/Create
      1 - FhcTripHotelCreatePage ---- PAGES paketinde
	  code, name, adress, phone, mail, idgroup, save bu webelementleri @FindBy
	  kullanarak locate edelim.
      2 - FhcTripHotelCreateTest ---- TESTS paketinde
	  FhcTripHotelCreatePage class'ından nesne üretelim ve içerisindeki webelementleri
	  kullanarak hotel oluşturalım.
	  */



    WebDriver driver;
    public FhcTripHotelCreatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "Code")
    public WebElement codeKutusu;

    @FindBy(id = "Name")
    public WebElement nameKutusu;

    @FindBy(id = "Address")
    public WebElement addressKutusu;

    @FindBy(id = "Phone")
    public WebElement phoneKutusu;

    @FindBy(id = "Email")
    public WebElement emailKutusu;

    @FindBy(id = "IDGroup")
    public WebElement selectKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement saveKutusu;


}
