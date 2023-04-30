package pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;


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

    @Rule
    public TestWatcher watcher = new TestWatcher() {

        protected void failed(Throwable e, Description description) {
            // teszthiba esetén rögzítünk egy képernyőképet
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] data = screenshot.getScreenshotAs(OutputType.BYTES);
            // itt történik meg az allure screenshot létrehozása
            Allure.addAttachment("Hiba", new ByteArrayInputStream(data));
        }
    };

    @Test
    @Feature("Check URL")
    @Tag("REG001")
    @Description("Validates navigating to the given URL is successful.")
    @Story("URL check - User navigates to https://lennertamas.github.io/roxo/index.html URL.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Navigate to URL")
    void navigateToUrlTest() {
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("REG002")
    @Description("Register tab - validating switching tab when 'Register' tab is clicked")
    @Story("Register tab - By clicking on 'Register' tab, the tab switches and allows user to register a new user.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Switch to 'Register' tab")
    void switchToRegisterTabTest () {
        registrationAndLoginPage.clickRegisterTab();
        Assertions.assertTrue(registrationAndLoginPage.validateRegisterWindow());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("REG003")
    @Description("Using correct credentials - validating new user registration is possible")
    @Story("Correct credentials - User registers a new user with correct credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Correct credentials registration")
    void registerNewUserTest () {
        String username = "John";
        String password = "Doe123";
        String email = "johndoe@gmail.com";
        String description = "John Doe is back";
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.performRegistration(username, password, email, description);

        Assertions.assertTrue(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("REG004")
    @Description("Using 'empty' credentials - validating new user registration is not possible when no valid data's are provided")
    @Story("Empty credentials - User registers a new user with empty credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Empty credentials registration")
    void registerWithEmptyCredentialsTest () {
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.clickRegisterButton();

        Assertions.assertFalse(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }

    @Test
    @Feature("'Registration' function")
    @Tag("REG005")
    @Description("Using 'invalid email' credentials - new user registration is not possible when no valid email address is provided")
    @Story("Invalid email credential - User registers a new user with invalid email credential.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Invalid email credential registration")
    void registerWithInvalidEmailTest () {
        String username = "johnDoe";
        String password = "Doe123";
        String email = "j@hnd@e@gmail+c@m";
        String description = "John Doe is back";
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.performRegistration(username, password, email, description);

        Assertions.assertFalse(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }

    /*@Test
    @Feature("'Registration' function")
    @Tag("REG006")
    @Description("Multiply user register - Reading valid registration credentials from a file, multiply users can be registered.")
    @Story("Multiply user register - User registers multiply accounts from credentials stored in a file.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Multiply user register")
    void registerMultipleUsersTest () {
        registrationAndLoginPage.clickRegisterTab();
        CsvActions csvActions = new CsvActions();
        csvActions.registerUsersFromCSV("testData/users.csv");


        Assertions.assertFalse(registrationAndLoginPage.verifyRegistrationIsSuccessful());
    }*/

    // Login tests
    @Test
    @Feature("'Login' function")
    @Tag("LOG001")
    @Description("Login window - validates after handling the 'Terms and conditions' window, the 'Login' window is visible by default")
    @Story("Login window - after handling the 'Terms and conditions' window, the 'Login' window is visible by default.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Login' window check")
    void loginWindowTest () {
        Assertions.assertTrue(registrationAndLoginPage.verifyLoginWindow());
    }

    @Test
    @Feature("'Login' function")
    @Tag("LOG002")
    @Description("Login tab - Verifies after switching to 'Register' tab, register window is displayed. 'Login' tab is active, and when a click is performed on it, the 'login' window will be displayed")
    @Story("Login tab - User switches to 'Register' tab, then switches back to 'Login' tab.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Login' tab check")
    void loginTabTest () {
        registrationAndLoginPage.clickRegisterTab();
        registrationAndLoginPage.clickLoginTab();

        Assertions.assertTrue(registrationAndLoginPage.verifyLoginWindow());
    }

    @Test
    @Feature("'Login' function")
    @Tag("LOG003")
    @Description("Empty credentials login - validating user login is not possible when no login data is provided")
    @Story("Empty credentials login - User leaves login credential fields empty, and clicks on 'Login' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Empty' credentials login")
    void emptyCredentialLoginTest () {
        registrationAndLoginPage.clickLoginButton();
        Assertions.assertTrue(registrationAndLoginPage.verifyLoginFailed());
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Feature("'Login' function")
    @Tag("LOG004")
    @Description("Built-in credentials login - validating user login is possible with built-in login credentials")
    @Story("Built-in credentials login - User logs in with built-in login credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Built-in' credentials login ")
    void builtInCredentialLoginTest () {
        registrationAndLoginPage.performBuiltInLogin();
        Assertions.assertEquals(PagesUrl.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(registrationAndLoginPage.verifyLoginSuccessful());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}