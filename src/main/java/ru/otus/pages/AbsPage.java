package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.otus.annotations.Path;
import ru.otus.common.AbsCommon;
import ru.otus.exeptions.PathNotFoundException;

public abstract class AbsPage<T> extends AbsCommon {

    private final String baseUrl = System.getProperty("base.url");
    //protected WebDriver driver;

    public AbsPage(WebDriver driver) {
        super(driver);
    }

    private String getPath(){
        Class clazz = this.getClass();
        if (clazz.isAnnotationPresent(Path.class)){
            Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }
        throw new PathNotFoundException();
    }

    public T open() {
        driver.get(baseUrl + getPath());
        return (T)this;
    }
}
