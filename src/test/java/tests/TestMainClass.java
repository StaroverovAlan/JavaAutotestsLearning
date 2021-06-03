package tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.YandexLoginPage;
import pages.YandexMainPage;

public class TestMainClass extends BaseClass {

    @Parameters({"login", "password"})
    @Test (description = "Вход в яндекс")
    public void logInYandex(String login, String password) {
        YandexMainPage yandexMainPage = new YandexMainPage(driver, wait);
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver, wait);
        yandexMainPage.openYandexPage();
        yandexMainPage.goToLoginPage();
        yandexLoginPage.isEnterButtonEnabled();
        yandexLoginPage.isLoginFieldDisplayed();
        yandexLoginPage.enterLogin(login);
        yandexLoginPage.isPasswordFieldEnabled();
        yandexLoginPage.enterPassword(password);
        yandexLoginPage.isSkipButtonDisplayed();
        yandexMainPage.isLoggedIn(login);
    }

    @Parameters({"emptyLogin", "invalidLoginWarning", "invalidLogin", "emptyLoginEnterWarning"})
    @Test
    public void invalidLogin(String emptyLogin, String invalidLoginWarning, String invalidLogin, String emptyLoginEnterWarning) {
        YandexMainPage yandexMainPage = new YandexMainPage(driver, wait);
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver, wait);
        yandexMainPage.openYandexPage();
        yandexMainPage.goToLoginPage();
        yandexLoginPage.isEnterButtonEnabled();
        yandexLoginPage.isLoginFieldDisplayed();
        yandexLoginPage.enterLogin(emptyLogin);
        yandexLoginPage.checkLoginWarning(emptyLoginEnterWarning);
        yandexLoginPage.enterLogin(invalidLogin);
        yandexLoginPage.checkLoginWarning(invalidLoginWarning);
    }
}
