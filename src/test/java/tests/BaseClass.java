package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    static WebDriver driver;
    static WebDriverWait wait;
    static String ChromeDriverProperty = "webdriver.chrome.driver";
    static String ChromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeClass
    public void testSetup() {
        System.setProperty(ChromeDriverProperty, ChromeDriverPath);
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 5));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void finishTest() {
        driver.quit();
    }
}
