package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginTest {

    // Sayfa nesnelerini sınıf seviyesinde tanımlıyoruz
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        // 1. Tarayıcıyı aç ve URL'e git (Veriyi Config'den alıyoruz)
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // 2. Sayfa nesnelerini initialize et
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(priority = 1, description = "Geçerli kullanıcı bilgileriyle başarılı giriş testi")
    public void validLoginTest() {
        // loginAction metodu kendi içinde ConfigReader kullanarak verileri çeker
        loginPage.loginAction();

        // Assertion: Welcome mesajının doğru kullanıcı adını içerdiğini doğrula
        String expectedMessage = "Welcome " + ConfigReader.getProperty("username");
        String actualMessage = homePage.getWelcomeMessageText();

        Assert.assertEquals(actualMessage, expectedMessage, "Login sonrası karşılama mesajı eşleşmedi!");
    }

    @Test(priority = 2, description = "Ürün listesinde Samsung Galaxy S6 var mı kontrolü")
    public void productCheckTest() {
        loginPage.loginAction();

        // Java Streams kullanan metodumuzu çağırıyoruz
        boolean isProductVisible = homePage.isProductAvailable("Samsung galaxy s6");

        Assert.assertTrue(isProductVisible, "Aranan ürün ana sayfada görüntülenemedi!");
    }

    @AfterMethod
    public void tearDown() {
        // Her testten sonra tarayıcıyı kapat ve tertemiz bir sonraki teste geç
        Driver.closeDriver();
    }
}