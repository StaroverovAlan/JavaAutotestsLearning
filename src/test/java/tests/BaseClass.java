package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    static WebDriver driver;
    static WebDriverWait wait;
    static String ChromeDriverProperty = "webdriver.chrome.driver";
    static String ChromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @Before
    public void testSetup() {
        System.setProperty(ChromeDriverProperty, ChromeDriverPath);
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 5));
    }

    @After
    public void finishTest() {
        driver.quit();
    }
}
