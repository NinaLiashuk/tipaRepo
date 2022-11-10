package Aston.com.tests.UITests.main_page;

import Aston.com.managers.ManagerWebDriver;
import Aston.com.pages.main_page.ATinkMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Aston.com.constants.GlobalData.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class ATinkMainPageTest {
    ATinkMainPage page = new ATinkMainPage();

    @BeforeAll
    public static void openApp() {
        ManagerWebDriver.getDriver().get(BASE_URL);
    }

    @Test()
    @DisplayName("Цвет элемента меняется при наведении на него курсора мыши")
    public void testAssertThatColorIsChangeWhenMouseMoveToElement() {
        assertThat(page.isTabBranchesAndATMsColorChanges()).isTrue();
        assertThat(page.isTabExchangeRatesColorChanges()).isTrue();
        assertThat(page.isTabContactsColorChanges()).isTrue();
    }

    @Test
    @DisplayName("Слайдер меняется через каждые три секунды")
    public void testAssertThatTimeForSliderMovingCycleIsAboutNineSecond() {
        assertThat(page.getTimeOfSlidersMovingCycle()).isLessThan(11000);
    }

    @Test
    @DisplayName("Слайдер отображается с индивидуальным текстом и картинкой")
    public void testAssertThatSliderContainPersonalTextAndImage() {
        assertThat(page.isSliderPaymentsAndTransfersVisibleWithPersonalTextAndPicture()).isTrue();
        assertThat(page.isSliderLoanVisibleWithPersonalTextAndPicture()).isTrue();
        assertThat(page.isSliderIndividualRateVisibleWithPersonalTextAndPicture()).isTrue();
    }

    @Test
    @DisplayName("Вкладки 'Отделения и банкоматы', 'Курсы валют' и 'Контакты' кликабельны")
    public void testAssertThatClickOnTabsOpensNewPage() {
        assertThat(page.crossToBranchesAndATMsPage()).isNotNull();
        assertThat(page.crossToContactsPage()).isNotNull();
        page.crossToHomePage();
    }

    @AfterAll
    public static void closeBrowser() {
        ManagerWebDriver.reset();
    }
}
