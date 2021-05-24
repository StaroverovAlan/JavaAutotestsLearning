package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void isEnterButtonEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.isDisplayed();
        Assert.assertTrue("Кнопка \"Войти\" недоступна!", enterButton.isEnabled());
    }

    public void isLoginFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginField));
        Assert.assertTrue("Поле для ввода логина не оботражается на странице", loginField.isDisplayed());
    }

    public void enterLogin(String login) {
        loginField.sendKeys(login);
        enterButton.click();
    }


    public void isPasswordFieldEnabled() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        Assert.assertTrue("Кнопка \"Войти\" недоступна!", passwordField.isEnabled());
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        enterButton.click();
    }

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
