package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void sagTiklama(){

     driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);

        WebElement rightClickMe = driver.findElement(By.xpath("//span[.='right click me']"));
        actions.contextClick(rightClickMe).perform(); // *** contextClick() SAGA TIKLAR

        WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        actions.doubleClick(doubleClick).perform();

        driver.switchTo().alert().accept(); // cikan alert'i ok'ledik.

    }
    @Test
    public void hoverOver(){ // mouse'u bir webelementin üzerine götürme ==> actions.moveToElement()
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void asagiYukariGitme(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

//        web sayfasinin en altina inmek
        actions.sendKeys(Keys.END).perform();

//        web sayfasinda yukari cikmak icin:
//        1.YONTEM : PAGE_UP
//        2.YONTEM : ARROW_UP (PAGE_UP'a gore daha az cikar)
        actions.sendKeys(Keys.PAGE_UP).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.sendKeys(Keys.ARROW_UP).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        web sayfasinda asagi inmek icin:
//        1.YONTEM : PAGE_DOWN
//        2.YONTEM : ARROW_DOWN (PAGE_DOWN'a gore daha az iner)
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_DOWN).perform();

//        web sayfasinda en yukariya cikmak icin:
        actions.sendKeys(Keys.HOME).perform();
    }

    @Test
    public void keyUpKeyDown(){
        // MERHABA nasılsınız
        // shift'e basılı tutarak merhaba               -> MERHABA
        // shift'ten elimizi kaldıracağız nasılsınız    -> nasılsınız
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        // aramaKutusu.sendKeys("merhaba nasılsınız");
        actions.moveToElement(aramaKutusu)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasılsınız")
                .perform();
    }

    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://google.com");
        Actions actions = new Actions(driver);

// ALT + F4 : sayfayı kapatması gerekiyor
        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();
    }
}
