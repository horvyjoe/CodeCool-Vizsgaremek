package pages;

import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


//@Epic("This test covers the validation of register and login functions on https://lennertamas.github.io/roxo/index.html website")
class RegistrationAndLoginPageTest {
    public WebDriver driver;
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

    @Epic("Register and login functions - These tests covers the validation of register and login functions on https://lennertamas.github.io/roxo/index.html website")
    @Feature("Terms and conditions popup function")
    @Test
    @Tag("")
    @Description("Validating Terms and conditions popup")
    @Story("Terms and conditions popup is displayed and can be accepted.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Accept Terms and conditions")
    void clickAcceptTermsAndConditionsButtonTest() {
        Assertions.assertTrue(registrationAndLoginPage.validateTermsAndConditionsPopupIsDisplayed());
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        Assertions.assertFalse(registrationAndLoginPage.validateTermsAndConditionsPopupIsDisplayed());
    }

    @Epic("Register and login functions - These tests covers the validation of register and login functions on https://lennertamas.github.io/roxo/index.html website")
    @Feature("Registration function")
    @Test
    @Description("Validating new user registration function is possible")
    @Story("By clicking on register new user tab, the tab switches and allows to create new user")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Register new user tab")
    void registerNewUser () {
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        registrationAndLoginPage.clickRegisterButton();
        Assertions.assertTrue(registrationAndLoginPage.validateRegisterWindow());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}