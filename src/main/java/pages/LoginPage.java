package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // 1. Element Tanımlamaları (Locators)
    @FindBy(id = "loginusername")
    public WebElement usernameInput;

    @FindBy(id = "loginpassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;

    // 2. Constructor (BasePage'den driver'ı devralır)
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // 3. Login Aksiyonu
    public void login(String user, String pass) {
        // Kullanıcı adı ve şifre gönderimi
        sendKeys(usernameInput, user);
        sendKeys(passwordInput, pass);

        // Login butonuna tıkla
        click(loginButton);

        // --- KRİTİK ALERT YÖNETİMİ ---
        // Demoblaze bazen "Wrong password" veya "User does not exist" uyarısı verir.
        // Eğer bir alert çıkarsa onu kabul edip (OK) yolumuza devam etmeliyiz.
        try {
            // 2 saniye boyunca bir alert çıkıp çıkmadığını kontrol et
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("🚨 Siteden bir uyarı mesajı geldi: " + alert.getText());
            alert.accept(); // Alert'teki 'Tamam' butonuna basar
        } catch (Exception e) {
            // Alert çıkmazsa (yani login başarılıysa) sessizce devam eder
        }
    }
}