package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;
@Epic("'Login' functions - These tests covers the verifications of login related features and page behaviours.")
public class LoginTest extends TestUtilities {
    @BeforeEach
    void setUpPreconditionSteps(){
        getRegistrationAndLoginPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
    }

    @Test
    @Feature("'Login' function")
    @Tag("LIN001")
    @Description("Login window - Verifies after handling the 'Terms and conditions' window, the 'Login' window is visible by default")
    @Story("Login window - after handling the 'Terms and conditions' window, the 'Login' window is visible by default.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Login' window check")
    void loginWindowTest () {
        shootScreenshot("Page status after entering login page");
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginWindow(),"Login window is NOT displayed!");
    }

    @Test
    @Feature("'Login' function")
    @Tag("LIN002")
    @Description("Login tab - Verifies after switching to 'Register' tab, register window is displayed. 'Login' tab is active, and when a click is performed on it, the 'login' window will be displayed")
    @Story("Login tab - User switches to 'Register' tab, then switches back to 'Login' tab.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Login' tab check")
    void loginTabTest () {
        getRegistrationAndLoginPage().clickRegisterTab();
        Assertions.assertTrue(getRegistrationAndLoginPage().validateRegisterWindow(),"Failed switch to 'Register' tab! Test stops, and can't continue to check switching to 'Login' tab");
        getRegistrationAndLoginPage().clickLoginTab();

        shootScreenshot("Page status after switching from register tab to login tab");
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginWindow(),"Failed switch to 'Login' tab");
    }

    @Test
    @Tag("LIN003")
    @Description("Empty credentials login - verifying user login is not possible when no login data is provided")
    @Story("Empty credentials login - User leaves login credential fields empty, and clicks on 'Login' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Empty' credentials login")
    void emptyCredentialLoginTest () {
        getRegistrationAndLoginPage().clickLoginButton();
        shootScreenshot("Page status after login attempt with empty user credentials");
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginFailed(),"The following error message is not displayed: 'Username or password is not correct!'");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL doesn't match expected URL");
    }

    @Test
    @Tag("LIN004")
    @Description("Built-in credentials login - validating user login is possible with built-in login credentials")
    @Story("Built-in credentials login - User logs in with built-in login credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("'Built-in' credentials login ")
    void builtInCredentialLoginTest () {
        getRegistrationAndLoginPage().performBuiltInLogin();
        shootScreenshot("Page status after login attempt with built-in user credentials");
        Assertions.assertEquals(PagesUrl.LANDING_PAGE.getUrl(), driver.getCurrentUrl(),"The actual URL doesn't match expected URL. After successful login, browser must navigate to 'Landing page URL'");
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginSuccessful(),"User's 'profile button' is not visible! After successful login, this element must be accessible!");
    }
}
