package Aston.com.tests.UITests.main_page;

import Aston.com.managers.ManagerWebDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Aston.com.constants.GlobalData.BASE_URL;

@DisplayName("Тесты начальной страницы")
public class MainPageTest extends BaseMainPage {

//    @Test
//    @DisplayName("Проверка маски поля - Телефон")
//    public void checkInputPhone() {
//        ManagerWebDriver.getDriver().get(BASE_URL);
//        mainPageTest.clickInputPhone();
//        mainPageTest.getMaskInputPhone();
//        System.out.println(mainPageTest.getHelperText());
//        Assertions.assertTrue(mainPageTest.getMaskInputPhone().equals("+7 "));
//        mainPageTest.setLogin();
//        mainPageTest.setPassword();
//        mainPageTest.enter();
//    }
}