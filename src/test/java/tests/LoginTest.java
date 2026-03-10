package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.util.HashMap;
import java.util.Map;

public class LoginTest extends TestBase {

    @Test
    public void loginWithMapTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // MAP KULLANIMI: Test verilerini anahtar-değer olarak tutuyoruz
        Map<String, String> testData = new HashMap<>();
        testData.put("user", "beyzatest"); // NOT: Sitede bu isimle kayıt olduğundan emin ol!
        testData.put("pass", "12345");
        testData.put("expected", "Welcome beyzatest");

        homePage.clickLogin();
        loginPage.login(testData.get("user"), testData.get("pass"));

        // DOĞRULAMA (Assertion)
        String actualMessage = homePage.getText(homePage.welcomeMessage);
        org.testng.Assert.assertEquals(actualMessage, testData.get("expected"), "Login sonrası mesaj yanlış!");
    }

    @Test
    public void streamsIleUrunKontrolu() {
        HomePage homePage = new HomePage(driver);

        // STREAMS & LAMBDA KULLANIMI: Ürünleri tek satırda filtrele ve say
        long urunSayisi = homePage.allProductTitles.stream()
                .map(el -> el.getText())
                .filter(txt -> !txt.isEmpty())
                .count();

        System.out.println("Sitedeki toplam ürün sayısı: " + urunSayisi);

        // Ürün listesini konsola Lambda ile yazdır
        homePage.allProductTitles.stream()
                .map(el -> el.getText())
                .forEach(name -> System.out.println("📦 Ürün: " + name));
    }
}