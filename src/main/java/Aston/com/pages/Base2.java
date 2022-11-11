package Aston.com.pages;

import Aston.com.managers.WebDriverDiscovery;
import Aston.com.managers.WebDriverThreadLocal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Aston.com.constants.GlobalData.BASE_URL;

public class Base2 {

    private WebDriverThreadLocal webDriver;

    public Base2(){
        PageFactory.initElements(WebDriverThreadLocal.getDriver(),this);
//        this.webDriverDiscovery = new WebDriverDiscovery();
//        this.driver = webDriverDiscovery.getWebDriver();
    }

 //   public Actions actions = new Actions(WebDriverThreadLocal.getDriver());

}
