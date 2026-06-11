package ru.otus.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbsCommon {
    protected WebDriver driver;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
