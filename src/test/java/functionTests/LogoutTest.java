package functionTests;

import com.codecool.vizsgaremek.enums.PagesUrl;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import testUtilities.TestUtilities;

@Epic("'Logout' functions - These tests covers the verification of 'logout' function.")
public class LogoutTest extends TestUtilities {

    @BeforeEach
    void setUpPreconditionSteps() {
        getLandingPage().navigateTo();
        getTermsAndConditionsPage().clickAcceptTermsAndConditionsButton();
        getRegistrationAndLoginPage().typeBuiltInLoginCredentials();
        getRegistrationAndLoginPage().clickLoginButton();
    }
    @Test
    @Feature("'Logout' function")
    @Tag("LOUT01")
    @Description("Logout - verifying user logout is successful")
    @Story("Logout - Logged in user clicks on 'Logout' button.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("LOUT01 - Logout")
    void logoutTest () {
        getLandingPage().clickLogoutButton();

        shootScreenshot("Page status after logout");
        Assertions.assertEquals(PagesUrl.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(),"After logout the login page is expected to load. ");
        Assertions.assertTrue(getRegistrationAndLoginPage().verifyLoginWindow(),"Error: Login window is not visible after logout.");
    }

    @Test
    @Feature("'Logout' function")
    @Tag("LOUT02")
    @Description("Logout and press 'back arrow' button - validating user logout is successful")
    @Story("Logout - Logged in user clicks on 'Logout' button. After that, user presses 'back' button in browser.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("LOUT02 - Logout and press 'back'")
    void logoutAndPressBackTest() {
        getLandingPage().clickLogoutButton();
        getLandingPage().navigateBackBrowser();

        Assertions.assertFalse(getLandingPage().verifyLogoutButtonIsDisplayed(),"Error: After logout, and 'back' button is clicked, the browser successfully navigates back to page as a logged in user!");
    }
}
