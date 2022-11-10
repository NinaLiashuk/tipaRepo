package Aston.com.tests.UITests.registration_autorization.recovery_password;

import Aston.com.managers.ManagerWebDriver;
import Aston.com.pages.registration_autorization.recovery_password.RecoveryPasswordPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Aston.com.constants.GlobalData.BASE_URL;

@DisplayName("Тест восстановление пароля авторизации")
public class RecoveryPasswordPageTest {

    RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage();

    @BeforeAll
    public static void openApp(){
        ManagerWebDriver.getDriver().get(BASE_URL);
    }

    @Test
    @DisplayName("Тестирование восстановления пароля авторизации")
    public void moveByAllSteps(){
        Assertions.assertThat(recoveryPasswordPage.isButtonForgotPasswordDisplayed()).isTrue();
        recoveryPasswordPage.clickOnButtonForgotPassword();
        Assertions.assertThat(recoveryPasswordPage.isRecoveryPasswordTextDisplayed()).isTrue();
        Assertions.assertThat(recoveryPasswordPage.isPassportNumberTextDisplayed()).isTrue();
        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPutFirstPassportSymbol()).contains("короче 3 символов " +
                "и не длиннее 15");
        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPassportInvalid()).contains("недопустимые символы");
        Assertions.assertThat(recoveryPasswordPage.getHelperTextIfPassportFieldEmpty()).isEmpty();
        Assertions.assertThat(recoveryPasswordPage.isButtonContinueDisabledIfInvalidPassport()).isTrue();
        Assertions.assertThat(recoveryPasswordPage.isButtonContinueDisabledIfFieldIsEmpty()).isTrue();
        recoveryPasswordPage.setValidPassportNumber();
        recoveryPasswordPage.clickOnButtonContinue();
    }

    @AfterAll
    public static void closeBrowser(){
        ManagerWebDriver.reset();
    }
}
