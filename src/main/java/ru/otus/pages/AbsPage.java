package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsPage {
    private final String baseUrl = System.getProperty("base.url");
    private final String path;
    protected WebDriver driver;

    public AbsPage(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(baseUrl + path);
    }
}
