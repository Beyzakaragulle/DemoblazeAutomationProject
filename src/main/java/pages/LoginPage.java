package pages;

import org.openqa.selenium.By;
import utilities.ConfigReader;

public class LoginPage extends BasePage {

    // 1. Element Locator'ları (By objeleri)
    private final By loginLink = By.id("login2");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[text()='Log in']");

    // 2. Constructor (Yapıcı Metod)
    public LoginPage() {
        super(); // BasePage'deki PageFactory ve Wait kurulumunu tetikler
    }

    // 3. Sayfa Aksiyonları (Metodlar)
    public void loginAction() {
        // Verileri , ConfigReader ile dosyadan çekiyoruz
        click(loginLink);
        sendKeys(usernameField, ConfigReader.getProperty("username"));
        sendKeys(passwordField, ConfigReader.getProperty("password"));
        click(loginButton);
    }
}