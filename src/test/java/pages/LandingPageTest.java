package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

class LandingPageTest {
    private WebDriver driver;
    private LandingPage landingPage;
    private RegistrationAndLoginPage registrationAndLoginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        landingPage = new LandingPage(driver);
        landingPage.navigateTo();
       // registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Description("")
    @Story(".")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with existing username")
    void loginTest() {
        landingPage.login();
        Assertions.assertTrue(landingPage.verifyLogin());

    }

    @Test
    @Description("")
    @Story(".")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Home button")
    void clickHomeButtonTest() {
        registrationAndLoginPage.clickAcceptTermsAndConditionsButton();
        landingPage.clickHomeButton();
        Assertions.assertFalse(registrationAndLoginPage.validateTermsAndConditionsPopupIsDisplayed());

    }

}