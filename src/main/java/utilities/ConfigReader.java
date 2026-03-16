package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // 1. Properties objesi oluşturdum
    private static Properties properties;

    // 2. Static blok: Sınıf çalıştırıldığında ilk burası çalışır ve dosyayı okur
    static {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream); // Dosyayı Properties objesine yüklüyoruz
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration dosyası bulunamadı: " + path);
        }
    }

    // 3. getProperty Metodu: Anahtar kelimeyi verince bize karşılığındaki değeri döner
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}