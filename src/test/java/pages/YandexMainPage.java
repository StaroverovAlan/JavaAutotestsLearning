package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class YandexMainPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String yandexWebPage = "https://www.yandex.ru/";

    public YandexMainPage(WebDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a/div[contains(text(), \"Войти\")]")
    private WebElement enterButton;

    @FindBy(xpath = "//span[@class=\"username__first-letter\"]")
    private WebElement loggedAccount;

    @Step("Переход на главную страницу яндекаса")
    public void openYandexPage() {
        driver.get(yandexWebPage);
    }

    @Step("Переход на страницу логина")
    public void goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.click();
    }

    @Step("Провека на успешность входа в аккаунт")
    public void isLoggedIn(String userLogin) {
        String loggedAccountText = loggedAccount.getText();
        Assert.assertEquals(loggedAccountText.charAt(0), userLogin.charAt(0),
                "\"Что-то точно пошло не так, неуспешный вход в аккаунт\", "
                        + loggedAccountText.charAt(0) + " != " + userLogin.charAt(0));
    }
}
