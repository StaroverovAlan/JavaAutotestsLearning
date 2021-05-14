package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class YandexLoginPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static By enterButtonLocator = By.xpath("//button[@type=\"submit\"]");
    private static By loginFieldLocator = By.xpath("//input[@id=\"passp-field-login\"]");
    private static By passwordFieldLocator = By.xpath("//input[@id=\"passp-field-passwd\"]");

    public YandexLoginPage(WebDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }

    public void isEnterButtonEnabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(enterButtonLocator));
        WebElement enterButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        Assert.assertTrue("Кнопка \"Войти\" недоступна!", enterButton.isEnabled());
    }

    public void isloginFieldDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(loginFieldLocator));
        WebElement loginField = driver.findElement(By.xpath("//input[@id=\"passp-field-login\"]"));
        Assert.assertTrue("Поле для ввода логина не оботражается на странице", loginField.isDisplayed());
    }

    public void enterLogin(String login) {
        driver.findElement(loginFieldLocator).sendKeys(login);
        driver.findElement(enterButtonLocator).click();
    }

    public void isPasswordFieldEnabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"passp-field-passwd\"]"));
        Assert.assertTrue("Кнопка \"Войти\" недоступна!", passwordField.isEnabled());
    }

    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(enterButtonLocator).click();
    }

}
