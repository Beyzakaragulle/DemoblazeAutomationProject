package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ProductTest {

    // Sayfalarımızdan nesne üretiyoruz
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Test
    public void addProductToCartTest() {
        // 1. Adım: Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // 2. Adım: Ana sayfadan bir ürüne tıkla

        homePage.clickProduct("Samsung galaxy s6");

        // 3. Adım: Ürün sayfasında "Add to cart" butonuna bas
        productPage.clickAddToCart();

        // 4. Adım: Çıkan uyarı mesajını doğrula (Assertion)
        String expectedMessage = "Product added";
        String actualMessage = productPage.getAlertText();

        Assert.assertEquals(actualMessage, expectedMessage, "Hata: Sepete ekleme uyarısı yanlış!");

        // 5. Adım: Alert'ü kabul et (Kapat)
        productPage.acceptAlert();

        System.out.println("Test Başarıyla Tamamlandı: Ürün sepete eklendi ve alert onaylandı.");
    }
}