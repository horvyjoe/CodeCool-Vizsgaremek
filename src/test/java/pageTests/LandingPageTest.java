package pageTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import com.codecool.vizsgaremek.pages.LandingPage;
import com.codecool.vizsgaremek.pages.RegistrationAndLoginPage;
import testUtilities.TestUtilities;
import testUtilities.WebDriverFactory;
import com.codecool.vizsgaremek.pages.TermsAndConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class LandingPageTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditions() {
        getLandingPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().performBuiltInLogin();
    }

    @Test
    @Description("This test checks if with existing username and password the login is possible.")
    @Story("A username and password is given. This test verifies login is successful with the given login credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with existing user")
    void loginTest() {
        Assertions.assertTrue(getLandingPage().verifyLogin());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Home' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'Home' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Home button")
    void clickHomeButtonTest() {
        getLandingPage().clickHomeButton();
        Assertions.assertFalse(getLandingPage().verifyHomeButtonNavigation());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'About' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'About' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click About button")
    void clickAboutButtonTest() {
        getLandingPage().clickAboutButton();
        Assertions.assertEquals(PagesUrl.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @Description("The test verifies that on LandingPage the 'Get in touch' button is visible, and clicking on it navigates to the correct page.")
    @Story("When on landing page, the 'Get in touch' button must navigate to the correct url.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Click Get in touch button")
    void clickGetInTouchButtonTest() {
        getLandingPage().clickGetInTouchButton();
        Assertions.assertEquals(PagesUrl.GET_IN_TOUCH.getUrl(), driver.getCurrentUrl());
    }


}