package pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Epic("'-Register' and '-Login' functions - These tests covers the validation of features accessible directly from https://lennertamas.github.io/roxo/index.html url. Also verifies the url is correct.")
class RegistrationAndLoginPageTest {
    private WebDriver driver;
    private RegistrationAndLoginPage registrationAndLoginPage;
    private TermsAndConditions termsAndConditions;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.navigateTo();
        termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.clickAcceptTermsAndConditionsButton();

    }

    @Test
    @Feature("Check URL")
    @Tag("RL001")
    @Description("Validates navigating to the given URL is successful.")
    @Story("User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Navigate to URL")
    void navigateToUrlTest() {
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("RL002")
    @Description("Using correct credentials - validating new user registration is possible")
    @Story("By clicking on 'Register' tab, the tab switches and allows user to register a new user.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Register new user tab")
    void registerNewUser () {
        registrationAndLoginPage.clickRegisterButton();
        Assertions.assertTrue(registrationAndLoginPage.validateRegisterWindow());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}