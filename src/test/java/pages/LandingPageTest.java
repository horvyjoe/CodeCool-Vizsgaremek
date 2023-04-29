package pages;

import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.LandingPage;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class LandingPageTest {
    public WebDriver driver;
    private LandingPage landingPage;
    private RegistrationAndLoginPage registrationAndLoginPage;
    private TermsAndConditions termsAndConditions;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();
        landingPage = new LandingPage(driver);
        landingPage.navigateTo();
        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.clickAcceptTermsAndConditionsButton();

    }


    @Test
    @Description("This test checks if with existing username and password the login is possible.")
    @Story("A username and password is given. This test verifies login is successful with the given login credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with existing user")
    void loginTest() {
        registrationAndLoginPage.performLogin();
        Assertions.assertTrue(landingPage.verifyLogin());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Home' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'Home' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Home button")
    void clickHomeButtonTest() {
        registrationAndLoginPage.performLogin();
        landingPage.clickHomeButton();
        Assertions.assertFalse(landingPage.verifyHomeButtonNavigation());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'About' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'About' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click About button")
    void clickAboutButtonTest() {
        registrationAndLoginPage.performLogin();
        landingPage.clickAboutButton();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Get in touch' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'Get in touch' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Get in touch button")
    void clickGetInTouchButtonTest() {
        registrationAndLoginPage.performLogin();
        landingPage.clickGetInTouchButton();
        Assertions.assertEquals(PagesUrl.GET_IN_TOUCH.getUrl(), driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}