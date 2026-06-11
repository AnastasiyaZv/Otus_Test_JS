package ru.otus.extensions;

import com.google.inject.Guice;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import ru.otus.factory.WebDriverFactory;
import ru.otus.modules.PagesModule;

public class UIExtension implements BeforeEachCallback, AfterEachCallback {

    WebDriver driver = null;

    @Override
    public void afterEach(ExtensionContext context) {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        driver = new WebDriverFactory().create();
        Guice.createInjector(new PagesModule(driver)).injectMembers(context.getTestInstance().get());
    }
}