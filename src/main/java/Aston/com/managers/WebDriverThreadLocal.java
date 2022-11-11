package Aston.com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverThreadLocal {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        if (driver == null){
            try {
                setDriver();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public WebElement waitForElementVisible(By by){
        Wait<WebDriver> wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
