package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List; // List için import ekledik

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nameofuser")
    public WebElement welcomeMessage;

    @FindBy(id = "login2")
    public WebElement loginLink;



    @FindBy(id = "cartur")
    public WebElement cartLink;

    @FindBy(linkText = "Samsung galaxy s6")
    public WebElement firstProduct;


    @FindBy(className = "card-title")
    public List<WebElement> allProductTitles;

    // Aksiyon: Login linkine tıkla
    public void clickLogin() {
        click(loginLink);
    }
}