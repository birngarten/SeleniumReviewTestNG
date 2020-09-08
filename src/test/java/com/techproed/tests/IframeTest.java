package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
//    SENERIO:
//    // https://the-internet.herokuapp.com/iframe
//// 1. Adım : Sayfadaki iframe'i bulacağız.
//// 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
//// 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
//// 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
//// 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.

    @Test
    public void test01(){
//      ***** Iframe'e geçiş yapmak için 3 TANE yöntemimiz var.
//	1. index ile            -> driver.switchTo().frame(0)
//	2. id ya da name ile    -> driver.switchTo().frame("mce_0_ifr")
//	3. webelement ile       -> driver.switchTo().frame(webelement)

//      ***** Iframe'den çıkış yapmak için 2 TANE yöntemimiz var.
//	1. driver.switchTo().defaultContent()  * En dis sayfaya cikar
//	2. driver.switchTo().parentFrame()     * İÇ İÇE IFRAME VARSA

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr"); // id ile

        WebElement iframeTextBox = driver.findElement(By.xpath("//p"));
        iframeTextBox.clear();
        iframeTextBox.sendKeys("Selamlar IFRAME!");
        driver.switchTo().defaultContent();

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();

    }

}

