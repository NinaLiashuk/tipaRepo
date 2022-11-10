package Aston.com.pages;

import Aston.com.managers.ManagerWebDriver;
import Aston.com.managers.ThreadRemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(ThreadRemoteWebDriver.getDriver(), this);
    }

    public Actions actions = new Actions(ManagerWebDriver.getDriver());
}