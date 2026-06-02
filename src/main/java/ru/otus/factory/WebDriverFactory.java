package ru.otus.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private final String browser = System.getProperty("browser");

    public WebDriver create() {
        switch (browser){
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
        throw new RuntimeException(String.format("Browser %s not supported", browser));
    }
}
