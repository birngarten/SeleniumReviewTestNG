package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;

public class FhcTripHotelCreateTest extends TestBase {

//    FhcTripHotelCreatePage fhcTripHotelCreatePage = new FhcTripHotelCreatePage(driver);

    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test(){
        // Tüm webelementlere veri göndermeniz göndermeniz gerekiyor.
        // Save butonuna tıklamnız gerekiyor.
        // Assert işlemi ile "Hotel was inserted successfully" yazısını doğrulayın
        FhcTripHotelCreatePage fhcTripHotelCreatePage = new FhcTripHotelCreatePage(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fhcTripHotelCreatePage.codeKutusu.sendKeys("123");
        fhcTripHotelCreatePage.nameKutusu.sendKeys("Ahmet");
        fhcTripHotelCreatePage.addressKutusu.sendKeys("Salzburg");
        fhcTripHotelCreatePage.phoneKutusu.sendKeys("012378463");
        fhcTripHotelCreatePage.emailKutusu.sendKeys("ahmet126@gmail.com");
        Select select = new Select(fhcTripHotelCreatePage.IDGroupKutusu);
        select.selectByIndex(2);
        fhcTripHotelCreatePage.submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver,3);
//      WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
//      Assert.assertTrue(message.isDisplayed());
        boolean esitMi =wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(esitMi);

        }

    }

