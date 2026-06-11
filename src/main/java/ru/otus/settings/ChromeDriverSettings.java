package ru.otus.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeDriverSettings implements IWebDriverSettings{

    @Override
    public AbstractDriverOptions settings() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-fullscreen");

        return chromeOptions;
    }
}
