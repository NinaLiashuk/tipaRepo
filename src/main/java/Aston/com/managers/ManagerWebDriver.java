package Aston.com.managers;

import Aston.com.helpers.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Aston.com.constants.Configuration.WAIT_TIMEOUT;
import static Aston.com.constants.GlobalData.BASE_URL;

public class ManagerWebDriver {

    protected static WebDriver driver;

    private static synchronized WebDriver createDriver() {

        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        return driver;
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            try {
                driver = createDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void reset() {
        driver.quit();
    }

    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public static WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}