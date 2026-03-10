package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager sayesinde Chrome driver dosyasını manuel indirmek gerekmiyor.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Tarayıcı ayarları
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Testin başlayacağı ana adres
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Test bittikten sonra tarayıcıyı kapatır
        if (driver != null) {
            driver.quit();
        }
    }
}