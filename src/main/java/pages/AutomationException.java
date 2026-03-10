package pages;


public class AutomationException extends RuntimeException {
    public AutomationException(String message) {
        // Gelen hata mesajını anlamak için isim veriyorum.
        super("🚨 [BEYZA-OTOMASYON HATASI]: " + message);
    }
}