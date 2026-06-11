package ru.otus.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.otus.exeptions.DriverNotSupportedException;
import ru.otus.settings.ChromeDriverSettings;
import ru.otus.settings.FirefoxDriverSettings;

public class WebDriverFactory {
    private final String browser = System.getProperty("browser");

    public WebDriver create() {
        switch (browser){
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) new ChromeDriverSettings().settings());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) new FirefoxDriverSettings().settings());
            }
        }
        throw new DriverNotSupportedException(browser);
    }
}
