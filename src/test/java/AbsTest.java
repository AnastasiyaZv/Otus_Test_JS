import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.otus.facrory.WebDriverFactory;
import ru.otus.pages.MainPage;

public abstract class AbsTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    private final String baseUrl = System.getProperty("base.url");


    @BeforeEach
    public void webDriverStart() {
        driver =new WebDriverFactory().create();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void webDriverStop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
