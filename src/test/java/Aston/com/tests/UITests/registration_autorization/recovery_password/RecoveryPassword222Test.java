package Aston.com.tests.UITests.registration_autorization.recovery_password;

import Aston.com.managers.ManagerWebDriver;
import Aston.com.managers.WebDriverThreadLocal;
import Aston.com.pages.Base2;
import Aston.com.pages.registration_autorization.recovery_password.RecoveryPassword222;
import Aston.com.pages.registration_autorization.recovery_password.RecoveryPasswordPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Aston.com.constants.GlobalData.BASE_URL;

//@DisplayName("Тест восстановление пароля авторизации")
public class RecoveryPassword222Test {

//    RecoveryPassword222 recoveryPasswordPage = new RecoveryPassword222();
//
//    @BeforeClass
//    public void openApp(ChromeDriver driver){
////        navigate(BASE_URL);
//        this.recoveryPasswordPage = PageFactory.initElements(driver, RecoveryPassword222.class);
//        WebDriverThreadLocal.setDriver();
//        WebDriverThreadLocal.getDriver().get(BASE_URL);
//    }
//
////    @Test
////    @DisplayName("Тестирование восстановления пароля авторизации")
//    @Test
//    public void moveByAllSteps(){
//        Assertions.assertThat(recoveryPasswordPage.isButtonForgotPasswordDisplayed()).isTrue();
//        recoveryPasswordPage.clickOnButtonForgotPassword();
//        Assertions.assertThat(recoveryPasswordPage.isRecoveryPasswordTextDisplayed()).isTrue();
//        Assertions.assertThat(recoveryPasswordPage.isPassportNumberTextDisplayed()).isTrue();
//        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPutFirstPassportSymbol()).contains("короче 3 символов " +
//                "и не длиннее 15");
//        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPassportInvalid()).contains("недопустимые символы");
//        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPassportFieldEmpty()).isEmpty();
//        Assertions.assertThat(recoveryPasswordPage.isButtonContinueDisabledIfInvalidPassport()).isTrue();
//        Assertions.assertThat(recoveryPasswordPage.isButtonContinueDisabledIfFieldIsEmpty()).isTrue();
//        recoveryPasswordPage.setValidPassportNumber();
//        recoveryPasswordPage.clickOnButtonContinue();
//    }
//
//    @AfterClass
//    public static void closeBrowser(){
//        ManagerWebDriver.reset();
//    }
}
