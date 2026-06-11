package ru.otus.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import ru.otus.factory.WebDriverFactory;
import ru.otus.pages.MainPage;

public class PagesModule extends AbstractModule {
    private WebDriver driver;

    public PagesModule(WebDriver driver){
        this.driver = driver;
    }

    @Provides
    @Singleton
    public MainPage mainPage(){
        return new MainPage(driver);
    }
}
