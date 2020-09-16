package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GlbKitTest {
    //2. ÖRNEK : Yazldızlı Çay Bardağı
    //a ) https://www.glbtrader.com/listing/Home-Garden-Kitchen--Dining-Bar/60/67
    //	Bu sayfaya gidelim. Bu sayfaya gitmek için;
    //	1- Driver class'ını kullanın.
    //	2- Sayfa adresini properties dosyasına ekleyin ve oradan alın.
    //		glb_kitchen = https://www.glbtr...
    //b ) Pages paketinin altında GlbKitPage isminde bir tane class oluşturun.
    //	İçerisinde "Yaldızlı Çay Bardağı" ürününü webelemtent şeklinde bulun.
    //		@FindBy (partialLinkText = "..")
    //	ürünün başlığını webelement şeklinde bulun.
    //	ürünün fiyatını webelement şeklinde bulun.
    //	ürünün açıklamasını webelement şeklinde bulun.
    //c ) Bu webelementlerin içerdiği yazıları ekrana yazdırın.

    @Test (groups = "glbtest")
    public void test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_kitchen"));

        GlbKitPage glbKitPage = new GlbKitPage();

        glbKitPage.urunLinki.click();
        String aciklama = glbKitPage.aciklama.getText();
        String baslik = glbKitPage.baslik.getText();
        String fiyat = glbKitPage.fiyat.getText();

        System.out.println(baslik);
        System.out.println(aciklama);
        System.out.println(fiyat);

    }
}
