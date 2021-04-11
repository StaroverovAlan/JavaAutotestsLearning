import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMainPage  {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String yandexWebPage = "https://www.yandex.ru/";
    private static By enterButtonLocator = By.xpath("//a/div[contains(text(), \"Войти\")]");
    private static By findTitle = By.xpath("//title[contains(text(), \"Яндекс\")]");

    public YandexMainPage(WebDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }

    public void openYandexPage() {
        driver.get(yandexWebPage);
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(enterButtonLocator));
        driver.findElement(enterButtonLocator).click();
    }

    public void isLoggedIn(String userLogin) {
        By checkLoggedInAccount = By.xpath("//span[@class=\"username__first-letter\"][contains(text(), \"" + userLogin.charAt(0) + "\")]");
        wait.until(ExpectedConditions.presenceOfElementLocated(findTitle));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkLoggedInAccount));
    }

}
