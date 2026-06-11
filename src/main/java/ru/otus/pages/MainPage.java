package ru.otus.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.otus.annotations.Path;

import static org.assertj.core.api.Assertions.assertThat;

@Path("/form.html")
public class MainPage extends AbsPage {

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "email")
    private WebElement userEmail;

    @FindBy(id = "password")
    private WebElement userPass;

    @FindBy(id = "confirm_password")
    private WebElement userConfPass;

    @FindBy(id = "birthdate")
    private WebElement userBirthday;

    @FindBy(id = "language_level")
    private WebElement userLevel;

    @FindBy(css = "[type= 'submit']")
    private WebElement button;

    @FindBy(id = "output")
    private WebElement userOutput;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void inputFieldForm(String name, String email, String pass, String confPass, String birthday, String level) {
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        userPass.sendKeys(pass);
        userConfPass.sendKeys(confPass);
        userBirthday.sendKeys(birthday);
        userLevel.sendKeys(level);
    }

    public void clickButton() {
        try {
            button.click();
            // если пароли не совпадают, то переключаемся на окно
            Alert alert = driver.switchTo().alert();
            // Принять алерт (нажать "ОК")
            alert.accept();
            System.out.println("Алерт появился и был принят.");
        } catch (NoAlertPresentException e) {
            System.out.println("Алерта нет, продолжаем выполнение.");
        }
    }

    public String expectedText(String name, String email) {
        return String.format("Имя пользователя: %s\n" +
                        "Электронная почта: %s\n" +
                        "Дата рождения: %s\n" +
                        "Уровень языка: %s",
                name, email, userBirthday.getAttribute("value"), userLevel.getAttribute("value"));
    }

    public boolean isTextOutput(String name, String email) {
        String expectedText = expectedText(name, email);
        String textOutput = userOutput.getText();
        return textOutput.equals(expectedText);
    }

    public void isAssert(String name, String email) {
        //сравнение значений полей userPass и userConfPass
        assertThat(userPass.getAttribute("value"))
                .as("Значения полей не совпадают")
                .isEqualTo(userConfPass.getAttribute("value"));

        //сравнение вывода данных и введенных данных
        assertThat(userOutput.getText())
                .as("Текст не соответствует ожидаемому")
                .isEqualTo(expectedText(name, email));
    }
}
