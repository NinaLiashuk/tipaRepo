package Aston.com.tests;

import Aston.com.managers.ManagerWebDriver;
import org.junit.jupiter.api.AfterAll;

public class TestBase {
    @AfterAll
    public static void quit() {
        ManagerWebDriver.reset();
    }
}