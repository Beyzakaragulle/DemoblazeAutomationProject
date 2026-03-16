package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    // Sepetteki ürünlerin isimlerinin bulunduğu genel bir locator
    // Bu, tablodaki ürün isimlerini yakalar
    private final By productNameInCart = By.xpath("//td[2]");

    public CartPage() {
        super();
    }

    // Sepetteki ilk ürünün ismini metin olarak verir
    public String getFirstProductName() {
        return getText(productNameInCart);
    }
}