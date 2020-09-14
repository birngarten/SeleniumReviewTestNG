package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase{

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        /*
    1. Adım : the-internet.herokuapp.com/windows sayfasinın WindowHandle'ını alalım.
    2. Adım : Click Here linkine tıklayalım.
    3. Adım : Gittiğimiz sayfadan, the-internet.herokuapp.com/windows sayfasına
              window handle'ını kullanarak geçiş yapalım. */

//        1. Adım : the-internet.herokuapp.com/windows sayfasinın WindowHandle'ını alalım.
        String anaSayfaWindowHandle = driver.getWindowHandle();
        System.out.println(anaSayfaWindowHandle); // sayfanin WindowHandle'i => CDwindow-42F54D21863121EB494242EED370FA24

//      2. Adım : Click Here linkine tıklayalım.
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//       3. Adım : Gittiğimiz sayfadan, the-internet.herokuapp.com/windows sayfasına
//              window handle'ını kullanarak geçiş yapalım.
        driver.switchTo().window(anaSayfaWindowHandle); //yukarida aldigimiz ve String'e atadigimiz windowHandle'i kullandik

        String ikinciSayfaWindowHandle="";
//        *** Acik olan tum pencerelerin window handle'larini alamak:
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String w: allWindowHandles){
            if (!w.equals(anaSayfaWindowHandle)){
                ikinciSayfaWindowHandle = w;
            }
            System.out.println(w);
        }

//        tekrar ikinci sayfaya windowHandle ile gecmek;
        driver.switchTo().window(ikinciSayfaWindowHandle);

        ///////////////// Set<String> i Array'e çevirme /////////////////
//        Array'e cevirerek kullanma:
        Object[] windowHandleDegerleri = allWindowHandles.toArray();
        System.out.println(windowHandleDegerleri[0].toString());
        System.out.println(windowHandleDegerleri[1].toString());


    }

}
