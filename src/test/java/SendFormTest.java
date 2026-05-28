import org.junit.jupiter.api.Test;

public class SendFormTest extends AbsTest {
    private final String NAME = "Kate";
    private final String EMAIL = "Kate@mail.com";
    private final String PASS = "qweRt";
    private final String CONF_PASS = "qweRt";
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
