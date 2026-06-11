import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ru.otus.extensions.UIExtension;
import ru.otus.factory.WebDriverFactory;
import ru.otus.pages.MainPage;

@ExtendWith(UIExtension.class)
public class SendFormTest {

    @Inject
    private MainPage mainPage;

    private final String NAME = "Kate";
    private final String EMAIL = System.getProperty("login");
    private final String PASS = System.getProperty("pass");
    private final String CONF_PASS = System.getProperty("pass");
    private final String BIRTHDAY = "12/11/2025";
    private final String LEVEL = "Продвинутый";

    @Test
    public void sendForm() {
        mainPage
                .open()
                .inputFieldForm(NAME, EMAIL, PASS, CONF_PASS, BIRTHDAY, LEVEL)
                .clickButton()
                .isAssert(NAME, EMAIL);
    }
}
