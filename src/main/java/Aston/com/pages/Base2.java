package Aston.com.pages;

import Aston.com.managers.ThreadRemoteWebDriver;

import static Aston.com.constants.GlobalData.BASE_URL;

public class Base2 {

    public static synchronized void openApp(){
        ThreadRemoteWebDriver.createDriver().get(BASE_URL);
    }
}
