package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriverWait wait;

    public BasePage() {
        // PageFactory: @FindBy notasyonlarını aktive eder
        //PageFactory.initElements(Driver.getDriver(), this);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    // Ortak metod: Tıklama
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Ortak metod: Yazı gönderme
    protected void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    //
    public void acceptAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }
    // Ortak metod: Yazı alma
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}