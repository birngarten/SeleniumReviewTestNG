package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.manage().window().maximize();

    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        Alert'e switchTo() ile girilir...
// *****  Alert'in 4 tane method'u var:
//        .alert().getText();
//        .alert().sendKeys("BU BIR ALERT");
//        .alert().accept();
//        .alert().dismiss();

        WebElement button = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        button.click();
        String alertMesaj = driver.switchTo().alert().getText();
        System.out.println(alertMesaj);
        driver.switchTo().alert().sendKeys("BU BIR ALERT");
        driver.switchTo().alert().accept();

    }
}
