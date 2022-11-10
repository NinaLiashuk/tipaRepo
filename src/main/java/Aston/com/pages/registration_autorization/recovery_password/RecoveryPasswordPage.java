package Aston.com.pages.registration_autorization.recovery_password;

import Aston.com.constants.DataForUITests;
import Aston.com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class RecoveryPasswordPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'MuiTypography-root')]")
    private WebElement buttonForgotPassword;

    @FindBy(xpath = "//div[contains(@class, 'StepIcon-circle')]//ancestor::div[@class=\"css-5ud93d\"]")
    private WebElement firstStepCircle;

    @FindBy(xpath = "//h3[contains(@class, 'MuiTypography-root')]")
    private WebElement headerPasswordRecovery;

    @FindBy(xpath = "//label[contains(@class, 'MuiFormLabel-root') and contains(text(), 'Номер паспорта')]")
    private WebElement headerPassportNumber;

    @FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root')]/span")
    private Button buttonBack;

    @FindBy(xpath = "//input[(@name=\"passNumber\")]")
    private WebElement windowPassportEnter;

    @FindBy(xpath = "//p[contains(@class,'MuiFormHelperText-root')]")
    private WebElement helperText;

    @FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root') and contains(text(), 'Продолжить')]")
    private WebElement buttonContinue;

    @FindBy(xpath = "//input[@id=\"cell0\"]")
    private WebElement windowForCode;//   //input[contains(@class, 'MuiInputBase-input')]

    public String getButtonForgotPasswordText() {
        return buttonForgotPassword.getAttribute("innerText");
    }

    @Step("Кнопка 'Забыли пароль?' отображается")
    public boolean isButtonForgotPasswordDisplayed() {
        return buttonForgotPassword.isDisplayed() && getButtonForgotPasswordText().contains("Забыли пароль?");
    }

    @Step("Клик на кнопку 'Забыли пароль'")
    public void clickOnButtonForgotPassword() {
        buttonForgotPassword.click();
    }

    @Step("Отображается текст 'Восстановление пароля'")
    public boolean isRecoveryPasswordTextDisplayed() {
        return headerPasswordRecovery.isDisplayed();
    }

    @Step("Отображается текст 'Номер паспорта'")
    public boolean isPassportNumberTextDisplayed() {
        return headerPassportNumber.isDisplayed();
    }

    @Step("Кнопка 'Назад' активна")
    public boolean isButtonBackDisplayedAndActive() {
        return buttonBack.isVisible();
    }

    @Step("При вводе первого символа паспорта появляется подсказка 'Номер паспорта должен быть не короче 3 символов " +
            "и не длиннее 15 символов'")
    public String getHelperTextIfPutFirstPassportSymbol() {
        clickAndCleanWindowPassport();
        windowPassportEnter.sendKeys("2");
        return helperText.getAttribute("innerText");
    }

    @Step("Ввод валидного номера паспорта")
    public void setValidPassportNumber() {
        clickAndCleanWindowPassport();
        windowPassportEnter.sendKeys(DataForUITests.VALID_PASSPORT_NUMBER);
    }

    @Step("Клик по кнопке 'Продолжить'")
    public void clickOnButtonContinue() {
        buttonContinue.click();
    }

    @Step("Ввод шестизначного кода из смс")
    public void setCode() {
        windowForCode.click();
        windowForCode.sendKeys();
    }

    @Step("При вводе невалидного паспорта появляется подсказка 'Использованы недопустимые символы'")
    public String getHelperTextIfPassportInvalid() {
        clickAndCleanWindowPassport();
        windowPassportEnter.sendKeys(DataForUITests.INVALID_PASSPORT_NUMBER);
        return helperText.getAttribute("innerText");
    }

    @Step("При стирании данных с поля ввода паспорта подсказка 'Использованы недопустимые символы' исчезает")
    public String getHelperTextIfPassportFieldEmpty() {
        clickAndCleanWindowPassport();
        return helperText.getAttribute("innerText");
    }

    @Step("Кнопка 'Продолжить' неактивна при пустом поле ввода")
    public boolean isButtonContinueDisabledIfFieldIsEmpty() {
        clickAndCleanWindowPassport();
        return buttonContinue.isDisplayed();
    }

    @Step("Кнопка 'Продолжить' неактивна до ввода валидного паспорта")
    public boolean isButtonContinueDisabledIfInvalidPassport() {
        clickAndCleanWindowPassport();
        windowPassportEnter.sendKeys(DataForUITests.INVALID_PASSPORT_NUMBER);
        return buttonContinue.isDisplayed();
    }

    @Step("Клик мыши и очистка поля ввода")
    public void clickAndCleanWindowPassport() {
        windowPassportEnter.click();
        windowPassportEnter.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        windowPassportEnter.sendKeys(Keys.DELETE);
    }
}



