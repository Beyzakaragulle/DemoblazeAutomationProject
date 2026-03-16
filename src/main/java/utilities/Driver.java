package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // 1. Static WebDriver nesnesi (Tüm projede tek bir driver olması için)
    private static WebDriver driver;

    // 2. Private Constructor (Dışarıdan "new Driver()" yapılmasını engeller)
    private Driver() {
    }

    // 3. getDriver() Metodu (Tarayıcıyı başlatan ve döndüren merkez)
    public static WebDriver getDriver() {
        if (driver == null) {
            // configuration.properties dosyasından "browser" değerini oku
            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    // 4. closeDriver() Metodu (Test bitince tarayıcıyı temiz kapatmak için)
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Belleği tamamen temizle
        }
    }
}