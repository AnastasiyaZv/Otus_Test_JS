package ru.otus.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxDriverSettings implements IWebDriverSettings{

    @Override
    public AbstractDriverOptions settings() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-headless");

        return firefoxOptions;
    }
}
