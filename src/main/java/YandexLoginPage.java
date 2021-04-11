import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexLoginPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static By enterButtonLocator = By.xpath("//button[@type=\"submit\"]");
    private static By loginField = By.xpath("//input[@id=\"passp-field-login\"]");
    private static By passwordField = By.xpath("//input[@id=\"passp-field-passwd\"]");

    public YandexLoginPage(WebDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }

    public void enterLogin(String login) {
        wait.until(ExpectedConditions.presenceOfElementLocated(enterButtonLocator));
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(enterButtonLocator).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(enterButtonLocator).click();
    }

}
