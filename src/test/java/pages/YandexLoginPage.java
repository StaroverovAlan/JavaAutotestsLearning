package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class YandexLoginPage {

    public YandexLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement enterButton;

    @FindBy(xpath = "//title[contains(text(), \"Авторизация\")]")
    private WebElement authorizationTitle;

    @FindBy(xpath = "//input[@id=\"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id=\"passp-field-passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-t=\"button:pseudo\"]")
    private WebElement skipButton;

    @FindBy(xpath = "//input[@data-t=\"field:input-additional_email\"]")
    private WebElement additionalEmailFiled;

    @FindBy(xpath = "//div[@class=\"Textinput-Hint Textinput-Hint_state_error\"]")
    private WebElement loginWarning;

    @Step("Провекра на достпуность кнопки ввода.")
    public void isEnterButtonEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.isDisplayed();
        Assert.assertTrue(enterButton.isEnabled(), "Кнопка \"Войти\" недоступна!");
    }

    @Step("Проверка на наличие поля логина")
    public void isLoginFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginField));
        Assert.assertTrue(loginField.isDisplayed(), "Поле для ввода логина не оботражается на странице");
    }

    @Step("Ввод логина {login}.")
    public void enterLogin(String login) {
        loginField.sendKeys(login);
        enterButton.click();
    }

    @Step("Проверка на наличие поля паролья")
    public void isPasswordFieldEnabled() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        Assert.assertTrue(passwordField.isEnabled(), "Поле для ввода пароля не оботражается на странице!");
    }

    @Step("Ввод пароля {password}.")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        enterButton.click();
    }

    @Step("Проверка корректности введеного логина")
    public void checkLoginWarning(String textWarning) {
        loginWarning.isDisplayed();
        String warningMessage = loginWarning.getText();
        Assert.assertEquals(warningMessage, textWarning, "Сообщение об ошибке не соотвествует! " + warningMessage + " != " + textWarning);
        enterButton.click();
        try {
            Assert.assertTrue(loginField.isDisplayed(), "Проверка на корректный логин не отработала!");
        }
        catch (Exception e) {
            Assert.assertFalse(passwordField.isEnabled(), "Проверка на корректный логин не отработала!");
        }
    }

    @Step("Пропуск ввода дополнительного имейла")
    public void isSkipButtonDisplayed() {
        try {
            By yandexTitle = By.xpath("//title[contains(text(), \"Яндекс\")]");
            driver.findElement(yandexTitle);
        }
        catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(additionalEmailFiled));
            skipButton.click();
        }
    }
}
