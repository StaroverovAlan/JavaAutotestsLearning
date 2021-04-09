import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleLoginPage extends MainClass {


    public static By furtherButtonLocator = By.xpath("//button[@jsname=\"LgbsSe\"]");
    public static By loginField = By.xpath("//input[@id=\"identifierId\"]");
    public static By passwordField = By.xpath("//input[@name=\"password\"]");
    public static By restorePasswordLocator = (By.xpath("//span[@class=\"VfPpkd-vQzf8d\"][contains(text(), \"Забыли пароль?\")]"));

    public void enterLogin(String login) {
        wait.until(ExpectedConditions.presenceOfElementLocated(furtherButtonLocator));
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(furtherButtonLocator).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(restorePasswordLocator));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(furtherButtonLocator).click();
    }

}
