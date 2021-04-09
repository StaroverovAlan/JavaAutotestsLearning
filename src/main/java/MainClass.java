import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {

     static WebDriver driver;
     static String ChromeDriverProperty = "webdriver.chrome.driver";
     static String ChromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
     static WebDriverWait wait;


    public static void main(String[] args) {
        System.setProperty(ChromeDriverProperty, ChromeDriverPath);
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 5));
        GoogleMainPage googleMainPage = new GoogleMainPage();
        GoogleLoginPage googleLoginPage = new GoogleLoginPage();
        String login = "TestUserForSeleniumWD@gmail.com";
        String password = "Qwerty$4";
        String userFirstName = "Test";
        String userSecondName = "User";

        googleMainPage.openGooglePage();
        googleMainPage.goToLoginPage();
        googleLoginPage.enterLogin(login);
        googleLoginPage.enterPassword(password);
        googleMainPage.isLoggedIn(userFirstName, userSecondName, login.toLowerCase());
        System.out.println("Успешно!!!!");
        driver.quit();
    }
}
