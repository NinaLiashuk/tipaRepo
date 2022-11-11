package Aston.com.pages.main_page;

import Aston.com.managers.ManagerWebDriver;
import Aston.com.pages.BasePage;
import Aston.com.pages.registration_autorization.branches.BranchesAndATMs;
import Aston.com.pages.registration_autorization.contacts.ContactsPage;
import Aston.com.pages.registration_autorization.exchange_rates.ExchangeRates;
import io.qameta.allure.Step;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;


public class ATinkMainPage extends BasePage {

    @FindBy(xpath = "//img[@data-testid=\"logo\"]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(@class, 'MuiTypography-root') and contains(text(), 'Отделения')]")
    private WebElement tabBranchesAndATMs;

    @FindBy(xpath = "//a[contains(@class, 'MuiTypography-root') and contains(text(), 'Курсы валют')]")
    private WebElement tabExchangeRates;

    @FindBy(xpath = "//a[contains(@class, 'MuiTypography-root') and contains(text(), 'Контакты')]")
    private WebElement tabContacts;

    @FindBy(xpath = "//h2[contains(@class, 'MuiTypography-root') and contains(text(), 'Платежи и переводы')]")
    private WebElement sliderPaymentsAndTransfers;

    @FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle') and contains(text(), 'Совершай платежи с карты " +
            "на карту')]")
    private WebElement textWithSliderPaymentsAndTransfers;

    @FindBy(xpath = "//img[contains(@src, 'DollarLogo')]")
    private WebElement imageDollarLogo;

    @FindBy(xpath = "//h2[contains(@class, 'MuiTypography-root') and contains(text(), 'Кредит без визита')]")
    private WebElement sliderLoan;

    @FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle') and contains(text(), 'Оформляй онлайн')]")
    private WebElement textWithSliderLoan;

    @FindBy(xpath = "//img[contains(@src, 'PercentLogo')]")
    private WebElement imagePercentLogo;

    @FindBy(xpath = "//h2[contains(@class, 'MuiTypography-root') and contains(text(), 'Индивидуальный курс валют')]")
    private WebElement sliderIndividualRate;

    @FindBy(xpath = "//h6[contains(@class, 'MuiTypography-subtitle') and contains(text(), 'Предложи банку свой курс')]")
    private WebElement textWithSliderIndividualRate;

    @FindBy(xpath = "//img[contains(@src, 'PersonLogo')]")
    private WebElement imagePersonLogo;

    private final String SLIDER_PATTERN = "//h2[contains(@class, 'MuiTypography-root') and contains(text(), '%s')]";

    @FindBy(xpath = "//a[contains(@class, 'MuiButtonBase-root')]")
    private WebElement submitToLearnMore;

    @FindBy(xpath = "//div[contains(@class,'MuiBox-root') and ../span[contains(@class, 'MuiRadio-root')]]")
    private WebElement tabLines;

    @Step("Проверка видимости кнопки и переход на страницу 'Отделения и банкоматы'")
    public BranchesAndATMs crossToBranchesAndATMsPage() {
        if (tabBranchesAndATMs.isDisplayed() && tabBranchesAndATMs.isEnabled()) {
            tabBranchesAndATMs.click();
        }
        return new BranchesAndATMs();
    }

    @Step("Проверка видимости кнопки и переход на страницу 'Контакты'")
    public ContactsPage crossToContactsPage() {
        if (tabContacts.isDisplayed() && tabContacts.isDisplayed()) {
            tabContacts.click();
        }
        return new ContactsPage();
    }

    @Step("Проверка видимости кнопки и переход на страницу 'Курсы валют'")
    public ExchangeRates crossToExchangeRatesPage() {
        if (tabExchangeRates.isDisplayed() && tabExchangeRates.isEnabled()) {
            tabExchangeRates.click();
        }
        return new ExchangeRates();
    }

    @Step("Возврат на главную страницу")
    public ATinkMainPage crossToHomePage() {
        logo.click();
        return this;
    }

    @Step("Сравнение цвета элемента при наведении и удаление от него курсора")
    public boolean isColorsEquals(WebElement element) {
        String ordinaryColor = Color.fromString(element.getCssValue("color")).asHex();
        actions.moveToElement(element).build().perform();
        String colorWhenMouseOn = Color.fromString(element.getCssValue("color")).asHex();
        actions.moveToElement(logo).build().perform();
        String colorWithoutMouse = Color.fromString(element.getCssValue("color")).asHex();
        return ordinaryColor.equals(colorWithoutMouse) && !ordinaryColor.equals(colorWhenMouseOn);
    }

    @Step("Цвет элемента 'Отделения и банкоматы' меняется при наведении мыши")
    public boolean isTabBranchesAndATMsColorChanges() {
        return isColorsEquals(tabBranchesAndATMs);
    }

    @Step("Цвет элемента 'Курсы валют' меняется при наведении мыши")
    public boolean isTabExchangeRatesColorChanges() {
        return isColorsEquals(tabExchangeRates);
    }

    @Step("Цвет элемента 'Контакты' меняется при наведении мыши")
    public boolean isTabContactsColorChanges() {
        return isColorsEquals(tabContacts);
    }

    @Step("Слайдер 'Платежи и переводы' отображается со своей картинкой и рекламным текстом")
    public boolean isSliderPaymentsAndTransfersVisibleWithPersonalTextAndPicture() {
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Платежи и переводы")));
        return sliderPaymentsAndTransfers.isDisplayed() && textWithSliderPaymentsAndTransfers.isDisplayed() &&
                imageDollarLogo.isDisplayed();
    }

    @Step("Слайдер 'Кредит без визита' отображается со своей картинкой и рекламным текстом")
    public boolean isSliderLoanVisibleWithPersonalTextAndPicture() {
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Кредит без визита")));
        return sliderLoan.isDisplayed() && textWithSliderLoan.isDisplayed() &&
                imagePercentLogo.isDisplayed();
    }

    @Step("Слайдер 'Индивидуальный курс валют' отображается со своей картинкой и рекламным текстом")
    public boolean isSliderIndividualRateVisibleWithPersonalTextAndPicture() {
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Индивидуальный курс валют")));
        return sliderIndividualRate.isDisplayed() && textWithSliderIndividualRate.isDisplayed() &&
                imagePersonLogo.isDisplayed();
    }

    @Step("Слайдеры меняются каждые 3 секунды")
    public long getTimeOfSlidersMovingCycle() {
        StopWatch timer = new StopWatch();
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Платежи и переводы")));
        timer.start();
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Кредит без визита")));
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Индивидуальный курс валют")));
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN, "Платежи и переводы")));
        timer.stop();
        return timer.getTime();
    }



    @FindBy(xpath = "//*[@data-testid=\"ArrowBackIcon\"]")
    public WebElement arrowBack;

    @FindBy(xpath = "//*[@data-testid=\"ArrowForwardIcon\"]")
    public WebElement arrowForward;

    @Step("Нажатие стрелки 'назад' в слайдере")
    public void clickOnArrowBack(){
        arrowBack.click();
    }

    @Step("Нажатие стрелки 'вперед' в слайдере")
    public void clickOnArrowForward(){
        arrowForward.click();
    }

    @Step("При нажатии стрелки 'назад' отображается предыдущий слайдер")
    public boolean clickOnArrowBackChangeSlider(){
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN,"Кредит без визита")));
        clickOnArrowBack();
        return sliderPaymentsAndTransfers.isDisplayed();
    }

    @Step("При нажатии стрелки 'вперед' отображается следующий слайдер")
    public boolean clickOnArrowForwardChangeSlider(){
        ManagerWebDriver.waitForElementVisible(xpath(format(SLIDER_PATTERN,"Индивидуальный курс валют")));
        clickOnArrowForward();
        return sliderPaymentsAndTransfers.isDisplayed();
    }


    @FindBy(xpath = "//img[contains(@src, 'puulm')]//parent::a")
    private WebElement tabAppStore;
    @FindBy(xpath = "//img[contains(@src, 'UgAAAS4A')]//parent::a")
    private WebElement tabGooglePlay;
    @Step("Проверка видимости и некликабельности кнопки 'Download on the AppStore'")
    public boolean clickOnImageAppStoreIsDisable(){
        return tabAppStore.isDisplayed() && tabAppStore.getAttribute("outerHTML").contains("href=\"#");
    }
    @Step("Проверка видимости и некликабельности кнопки 'Get it on Google Play'")
    public boolean clickOnImageGooglePlayIsDisable(){
        return tabGooglePlay.isDisplayed() && tabGooglePlay.getAttribute("outerHTML").contains("href=\"#");
    }
}