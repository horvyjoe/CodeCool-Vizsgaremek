package pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


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
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Navigate to URL")
    void navigateToUrlTest() {
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("RL002")
    @Description("Register tab - validating new user registration tab is displayed")
    @Story("Register tab - By clicking on 'Register' tab, the tab switches and allows user to register a new user.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Switch tab to register new user")
    void switchToregisterTab () {
        registrationAndLoginPage.clickRegisterTab();
        Assertions.assertTrue(registrationAndLoginPage.validateRegisterWindow());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("RL003")
    @Description("Using correct credentials - validating new user registration is possible")
    @Story("Correct credentials - User registers a new user with correct credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Correct credentials registration")
    void registerNewUser () {
        String username = "John";
        String password = "Doe123";
        String email = " johndoe@gmail.com";
        String description = "John Doe is back";
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.performRegistration(username, password, email, description);

        Assertions.assertTrue(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("RL004")
    @Description("Using 'empty' credentials - validating new user registration is not possible when no valid data's are provided")
    @Story("Empty credentials - User registers a new user with empty credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Empty credentials registration")
    void registerWithEmptyCredentials () {
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.clickRegisterButton();

        Assertions.assertFalse(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}