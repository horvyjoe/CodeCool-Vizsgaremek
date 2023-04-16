package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


@Epic("This test covers the validation of register and login functions on https://lennertamas.github.io/roxo/index.html website")
@Feature("Registration and login")
class RegistrationAndLoginPageTest {
    private WebDriver driver;

    private RegistrationAndLoginPage registrationAndLoginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.navigateTo();
    }


    @Test
    @Description("Validating Terms and conditions popup")
    @Story("Terms and conditions popup is displayed and can be accepted.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Accept Terms and conditions")
    void clickAcceptTermsAndConditionsButtonTest() {
        Assertions.assertTrue(registrationAndLoginPage.validateTermsAndConditionsPopupIsDisplayed());
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        Assertions.assertFalse(registrationAndLoginPage.validateTermsAndConditionsPopupIsDisplayed());

    }

    @Test
    @Description("Validating new user registration function")
    @Story("")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Register new user")
    void registerNewUser () {
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        registrationAndLoginPage.clickRegisterButton();
        Assertions.assertTrue(registrationAndLoginPage.validateRegisterWindow());

    }

    /* @AfterEach
    void tearDown() {
        driver.quit();
    }*/

}