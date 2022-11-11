package Aston.com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverDiscovery {

    private static ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();

    public WebDriverDiscovery() {
        if (remoteWebDriver.get() == null){
            startBrowser();
        }
    }

    private void startBrowser(){
        setRemoteWebDriver(new ChromeDriver());
    }

    public static void setRemoteWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }

}
