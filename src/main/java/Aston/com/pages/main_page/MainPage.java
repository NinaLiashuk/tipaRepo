package Aston.com.pages.main_page;

import Aston.com.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//label[@id = \":r1:-label\"]")
    private WebElement inputPhoneLabel;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//p[@id=\"my-helper-text\"]")
    private WebElement helperText;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submit;

    @FindBy(xpath = "//svg[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-s6jlyw\"]")
    private WebElement eyePassword;
    public void clickInputPhone() {
        inputPhone.click();
    }

    public void setPassword() {
        password.sendKeys("!Asdf12345");
    }

    public void setLogin() {
        inputPhone.sendKeys("4950123456");
    }

    public String getHelperText() {
        return helperText.getText();
    }

    public String getTextInputPhone() {
        return inputPhoneLabel.getText();
    }

    public String getMaskInputPhone() {
        return inputPhone.getAttribute("value");
    }

    public void enter() {
        submit.click();
    }

    public void eyePassword() {
        eyePassword.click();
    }
}