package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMainPage  {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String yandexWebPage = "https://www.yandex.ru/";
    private static By findTitle = By.xpath("//title[contains(text(), \"Яндекс\")]");

    public YandexMainPage(WebDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a/div[contains(text(), \"Войти\")]")
    private WebElement enterButton;

    public void openYandexPage() {
        driver.get(yandexWebPage);
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.click();
    }

    public boolean isLoggedIn(String userLogin) {
        By checkLoggedInAccount = By.xpath("//span[@class=\"username__first-letter\"][contains(text(), \"" + userLogin.charAt(0) + "\")]");
        try {
            driver.findElement(checkLoggedInAccount);
        }
        catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
