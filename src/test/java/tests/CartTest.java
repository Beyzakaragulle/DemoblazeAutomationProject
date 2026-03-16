package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CartTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void guestUserCartTest() {
        // 1. Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.clickCategory("Laptops");
        // 2. Bir ürüne tıkla
        homePage.clickProduct("MacBook air");

        // 3. Sepete ekle ve Alert'ü bekle (Daha önce yazdığımız wait'li metod)
        productPage.clickAddToCart();
        productPage.acceptAlert();

        // 4. Sepete git ve ürün ismini kontrol et
        homePage.goToCart();
        Assert.assertTrue(cartPage.getFirstProductName().contains("MacBook air"));
    }
    }