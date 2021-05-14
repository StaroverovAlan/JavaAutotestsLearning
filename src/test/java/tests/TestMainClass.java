package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.YandexLoginPage;
import pages.YandexMainPage;

public class TestMainClass extends BaseClass {

    @Test
    public void logInYandex() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver, wait);
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver, wait);
        String login = "TestUserJavaSelenium";
        String password = "Qwerty$4";
        yandexMainPage.openYandexPage();
        yandexMainPage.goToLoginPage();
        yandexLoginPage.isEnterButtonEnabled();
        yandexLoginPage.isloginFieldDisplayed();
        yandexLoginPage.enterLogin(login);
        yandexLoginPage.isPasswordFieldEnabled();
        yandexLoginPage.enterPassword(password);
        Assert.assertTrue("Что-то точно пошло не так, неуспешный вход в аккаунт",yandexMainPage.isLoggedIn(login));
    }
}
