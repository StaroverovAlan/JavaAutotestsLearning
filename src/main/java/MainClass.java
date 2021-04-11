import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {

     static WebDriver driver;
     static WebDriverWait wait;
     static String ChromeDriverProperty = "webdriver.chrome.driver";
     static String ChromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty(ChromeDriverProperty, ChromeDriverPath);
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 5));
        YandexMainPage yandexMainPage = new YandexMainPage(driver, wait);
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver, wait);
        String login = "TestUserJavaSelenium";
        String password = "Qwerty$4";

        yandexMainPage.openYandexPage();
        yandexMainPage.goToLoginPage();
        yandexLoginPage.enterLogin(login);
        yandexLoginPage.enterPassword(password);
        yandexMainPage.isLoggedIn(login);
        System.out.println("Успешно!");
        driver.quit();
    }
}
