package Aston.com.managers;

import Aston.com.helpers.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Aston.com.constants.Configuration.WAIT_TIMEOUT;

public class ThreadRemoteWebDriver {
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromedriver"));
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        return driver;
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void reset() {

        if (driver.get() != null){
            driver.get().close();
            driver.remove();
        }
    }

    public static WebElement findElement(By by) {
        return driver.get().findElement(by);
    }

    public static WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
