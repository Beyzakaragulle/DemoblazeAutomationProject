package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;

public class ProductPage extends BasePage {

    // 1. Elementlerin yerini (Locators) belirliyoruz
    private final By addToCartButton = By.xpath("//a[text()='Add to cart']");

    // 2. Yapıcı Metod (Constructor)
    public ProductPage() {
        super();
    }

    // 3. Aksiyon Metodları

    // Sepete ekle butonuna tıklar
    public void clickAddToCart() {
        click(addToCartButton);
    }

    // Ürün eklendiğinde çıkan  Alert (Uyarı) mesajını alır
    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        return Driver.getDriver().switchTo().alert().getText();
    }

    // Alert'ü  onaylar ve kapatır
    public void acceptAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }
}