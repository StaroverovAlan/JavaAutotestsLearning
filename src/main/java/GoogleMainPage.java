import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleMainPage extends MainClass{

    public static String googleWebPage = "https://www.google.com/";
    public static By enterButtonLocator = By.xpath("//a[contains(text(), \"Войти\")]");
    public static By findTitle = By.xpath("//title[contains(text(), \"Google\")]");

    public void openGooglePage() {
        driver.get(googleWebPage);
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(enterButtonLocator));
        driver.findElement(enterButtonLocator).click();
    }

    public void isLoggedIn(String userFirstName, String userSecondName, String userEmail) {
        By checkLoggedInAccount = By.xpath("//a[@aria-label=\"Аккаунт Google: " + userFirstName + " " + userSecondName + "  \n" + "(" + userEmail + ")\"]");
        System.out.println(checkLoggedInAccount);
        wait.until(ExpectedConditions.presenceOfElementLocated(findTitle));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkLoggedInAccount));
    }

}
