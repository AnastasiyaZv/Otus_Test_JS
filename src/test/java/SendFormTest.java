import org.junit.jupiter.api.Test;

public class SendFormTest extends AbsTest {
    private final String NAME = "Kate";
    private final String EMAIL = System.getProperty("login");
    private final String PASS = System.getProperty("pass");
    private final String CONF_PASS = System.getProperty("pass");
    private final String BIRTHDAY = "12/11/2025";
    private final String LEVEL = "Продвинутый";

    @Test
    public void sendForm() {
        mainPage
                .open();
        mainPage
                .inputFieldForm(NAME, EMAIL, PASS, CONF_PASS, BIRTHDAY, LEVEL);
        mainPage
                .clickButton();
        mainPage.
                isAssert(NAME, EMAIL);
    }
}
