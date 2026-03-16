package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import utilities.Driver;

public class HomePage extends BasePage {

    // 1. Element Locator'ları
    private final By welcomeMessage = By.id("nameofuser");
    private final By productList = By.className("card-title");

    // 2. Constructor
    public HomePage() {
        super();
    }

    // 3. Sayfa Aksiyonları

    // Welcome mesajını almak için (Assertion'da kullanacağız)
    public String getWelcomeMessageText() {
        return getText(welcomeMessage);
    }

    // Java Streams kullanarak ürün isimlerini listeleme
    public List<String> getProductNames() {
        List<WebElement> elements = Driver.getDriver().findElements(productList);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickProduct(String productName) {
        click(org.openqa.selenium.By.linkText(productName));
    }
    public void goToCart() {
        click(By.id("cartur")); // Üst menüdeki Cart linkinin ID'si
    }
    public void clickCategory(String categoryName) {
        // Kategori ismine göre linke tıklar (Phones, Laptops, Monitors)
        click(By.linkText(categoryName));
    }

    // Belirli bir ürün listede var mı kontrolü
    public boolean isProductAvailable(String productName) {
        return getProductNames().contains(productName);
    }
}